package com.fenjin.fjtms.users.controllers;

import com.fenjin.fjtms.core.BaseController;
import com.fenjin.fjtms.core.RequestBodyList;
import com.fenjin.fjtms.core.Result;
import com.fenjin.fjtms.core.domain.users.Role;
import com.fenjin.fjtms.core.domain.users.User;
import com.fenjin.fjtms.core.utils.DateUtils;
import com.fenjin.fjtms.core.utils.JsonUtil;
import com.fenjin.fjtms.core.utils.StringUtil;
import com.fenjin.fjtms.users.models.ChangePasswordModel;
import com.fenjin.fjtms.users.models.UserModel;
import com.fenjin.fjtms.users.services.IRoleService;
import com.fenjin.fjtms.users.services.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@Api(tags = "UserController", description = "用户管理控制器")
@RequestMapping("/users")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    // 服务发现客户端
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ManageUsers')")
    @ApiOperation(value = "创建新用户", notes = "用户Id由系统自动生成，Json格式用户对象", produces = "application/json")
    @ApiImplicitParam(paramType = "body", name = "userModel", value = "有效的UserModel", required = true, dataType = "UserModel")
    public Result create(@Valid @RequestBody UserModel userModel, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            FieldError error = (FieldError) bindingResult.getAllErrors().get(0);
            return new Result().validateFailed(error.getDefaultMessage());
        }
        try {

            if (userService.getUserByUsername(userModel.getUsername()) != null) {
                return new Result().validateFailed("用户名已存在");
            }
            if (!StringUtil.isEmpty(userModel.getEmail()) && userService.getUserByEmail(userModel.getEmail()) != null) {
                return new Result().validateFailed("邮箱已存在");
            }

            User user = new User();
            BeanUtils.copyProperties(userModel, user);
            // 密码加密
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword().trim()));
            // 设置用户的角色
            if (userModel.getRoleIds() != null) {
                for (String roleId : userModel.getRoleIds()) {
                    user.getRoles().add(roleService.getRoleById(roleId));
                }
            }

            return Result(userService.createUser(user));
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result(false);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ManageUsers')")
    @ApiOperation(value = "删除指定Id的用户", notes = "该操作为逻辑删除")
    @ApiImplicitParam(paramType = "query", name = "id", value = "用户Id", required = true, dataType = "String")
    public Result delete(@PathVariable String id) {

        User user = userService.getUserById(id);
        if (user != null) {
            return Result(userService.deleteUser(user));
        } else {
            return Result(false);
        }
    }

    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('ManageUsers')")
    @ApiOperation(value = "根据Id集合批量删除用户", notes = "该操作为逻辑删除", produces = "application/json")
    @ApiImplicitParam(paramType = "body", name = "ids", value = "用户Id集合RequestBodyList对象", dataType = "RequestBodyList<String>")
    public Result delete(@RequestBody RequestBodyList<String> ids) {

        if (ids != null) {
            for (String id : ids.getLists()) {
                userService.deleteUser(userService.getUserById(id));
            }
            return Result(true);
        } else {
            return Result(false);
        }
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ManageUsers')")
    @ApiOperation(value = "修改用户信息", notes = "传输Json格式UserModel对象", produces = "application/json")
    @ApiImplicitParam(paramType = "body", name = "userModel", value = "有效的UserModel", required = true, dataType = "UserModel")
    public Result edit(@Valid @RequestBody UserModel userModel, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            FieldError error = (FieldError) bindingResult.getAllErrors().get(0);
            return new Result().validateFailed(error.getDefaultMessage());
        }
        if (userModel != null) {
            try {
                User user = new User();
                BeanUtils.copyProperties(userModel, user);

                // 设置用户的角色
                if (userModel.getRoleIds() != null) {
                    for (String roleId : userModel.getRoleIds()) {
                        user.getRoles().add(roleService.getRoleById(roleId));
                    }
                }

                return Result(userService.updateUser(user));
            } catch (Exception e) {
                log.error(e.getMessage());
                return Result(false);
            }
        } else {
            return Result(false);
        }
    }

    @PutMapping("/password")
    @PreAuthorize("hasAnyAuthority('ManageUsers')")
    @ApiOperation(value = "修改用户密码", notes = "传输Json格式用户对象", produces = "application/json")
    @ApiImplicitParam(paramType = "body", name = "request", value = "有效的用户密码请求", required = true, dataType = "ChangePasswordModel")
    public Result changePassword(@RequestBody ChangePasswordModel request, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            FieldError error = (FieldError) bindingResult.getAllErrors().get(0);
            return new Result().validateFailed(error.getDefaultMessage());
        }
        if (request == null) {
            return new Result().validateFailed("request不能为空");
        }
        if (StringUtil.isEmpty(request.userId)) {
            return new Result().validateFailed("userId不能为空");
        }

        User user = userService.getUserById(request.userId);
        if (user == null) {
            return new Result().validateFailed("Id为" + request.userId + "的用户不存在");
        }

        // 密码加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (request.validateRequest && encoder.matches(request.oldPassword, user.getPassword())) {
            return new Result().validateFailed("原始密码不正确");
        }

        if (request.oldPassword == request.newPassword) {
            return new Result().validateFailed("新密码不能与原始密码相同");
        }

        user.setPassword(encoder.encode(request.newPassword));
        return Result(userService.updateUser(user));
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ManageUsers')")
    @ApiOperation(value = "分页查询指定条件的用户集合")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "createdFrom", value = "开始日期", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "createdTo", value = "结束日期", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "username", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "fullName", value = "姓名", dataType = "String"),
            @ApiImplicitParam(paramType = "body", name = "roleIds", value = "角色Id集合", required = false, dataType = "RequestBodyList<String>"),
            @ApiImplicitParam(paramType = "query", name = "phone", value = "电话号码", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "email", value = "电子邮箱", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "active", value = "激活", dataType = "Boolean"),
            @ApiImplicitParam(paramType = "body", name = "sorts", value = "排序属性，前缀-为倒序", required = false, dataType = "RequestBodyList<String>"),
            @ApiImplicitParam(paramType = "body", name = "filters", value = "属性过滤", required = false, dataType = "RequestBodyList<String>"),
            @ApiImplicitParam(paramType = "query", name = "pageIndex", value = "分页页数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页记录数", dataType = "Integer")
    })
    public Result list(@RequestParam(required = false) String createdFrom, @RequestParam(required = false) String createdTo, @RequestParam(required = false) String username,
                       @RequestParam(required = false) String fullName, @RequestBody(required = false) RequestBodyList<String> roleIds, @RequestParam(required = false) String phone,
                       @RequestParam(required = false) String email, @RequestParam(required = false) Boolean active, @RequestBody(required = false) RequestBodyList<String> sorts,
                       @RequestBody(required = false) RequestBodyList<String> filters, @RequestParam(required = false) Integer pageIndex, @RequestParam(required = false) Integer pageSize) {

        Date from = null;
        Date to = null;
        try {
            if (!StringUtil.isEmpty(createdFrom)) {
                from = DateUtils.toDate(createdFrom);
            }
            if (!StringUtil.isEmpty(createdFrom)) {
                to = DateUtils.toDate(createdTo);
            }
        } catch (ParseException e) {
            return new Result().validateFailed("日期参数格式不正确");
        }

        if (pageIndex == null) {
            pageIndex = 1;
        }

        if (pageSize == null) {
            pageSize = 20;
        }

        int total = userService.getAllUsers(from, to, username, fullName, roleIds == null? null : roleIds.getLists(), phone,
                email, active, sorts == null? null : sorts.getLists(), 0, Integer.MAX_VALUE).size();
        List users = userService.getAllUsers(from, to, username, fullName, roleIds == null? null : roleIds.getLists(), phone,
                email, active, sorts == null? null : sorts.getLists(), pageIndex - 1, pageSize);

        // 处理过滤
        if (filters != null) {
            return new Result().pageSuccess(total, JsonUtil.objectToJson(users, filters.getLists()));
        } else {
            return new Result().pageSuccess(total, users);
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ManageUsers')")
    @ApiOperation(value = "查询指定Id的用户")
    @ApiImplicitParam(paramType = "query", name = "id", value = "用户Id", required = true, dataType = "String")
    public Result get(@PathVariable String id) {

        User user = userService.getUserById(id);
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(user, userModel);
        List<Role> roles = roleService.getRolesByUserId(id);
        for (Role role : roles) {
            userModel.getRoleIds().add(role.getId());
        }
        return Result(userModel);
    }

    @GetMapping("/username/{username}")
    @PreAuthorize("hasAnyAuthority('ManageUsers')")
    @ApiOperation(value = "查询指定username的用户")
    @ApiImplicitParam(paramType = "query", name = "username", value = "用户名", required = true, dataType = "String")
    public Result getByUsername(@PathVariable String username) {

        return Result(userService.getUserByUsername(username));
    }

    @GetMapping("/info")
    @PreAuthorize("hasAnyAuthority('ManageUsers')")
    @ApiOperation(value = "获取当前微服务部署地址和端口号")
    public Result info() {
        List<String> list = discoveryClient.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = discoveryClient.getInstances("FENJIN-SERVICES-USERS");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return Result(this.discoveryClient);
    }
}
