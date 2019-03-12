package com.fenjin.fjtms.users.controllers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.fenjin.fjtms.core.BaseController;
import com.fenjin.fjtms.core.Result;
import com.fenjin.fjtms.core.domain.users.User;
import com.fenjin.fjtms.core.models.users.UserSearchModel;
import com.fenjin.fjtms.core.utils.JsonUtil;
import com.fenjin.fjtms.core.utils.StringUtil;
import com.fenjin.fjtms.users.services.ChangePasswordRequest;
import com.fenjin.fjtms.users.services.IRoleService;
import com.fenjin.fjtms.users.services.IUserService;
import com.fenjin.fjtms.users.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@Api(tags = "UserController",description = "用户管理控制器")
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
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="body", name = "user", value = "有效的用户实例", required = true, dataType = "User"),
            @ApiImplicitParam(paramType="body", name = "roleIds", value = "当前用户的角色Id列表", dataType = "List<String>")})
    public Result create(@Valid @RequestBody User user, @RequestBody List<String> roleIds, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            FieldError error = (FieldError) bindingResult.getAllErrors().get(0);
            return new Result().validateFailed(error.getDefaultMessage());
        }
        try {

            if(userService.getUserByUsername(user.getUsername()) != null){
                return new Result().validateFailed("用户名已存在");
            }
            if(!StringUtil.isEmpty(user.getEmail()) && userService.getUserByEmail(user.getEmail()) != null){
                return new Result().validateFailed("邮箱已存在");
            }

            // 密码加密
            BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword().trim()));

            // 设置用户的角色
            if(roleIds != null){
                for (String roleId: roleIds) {
                    user.getRoles().add(roleService.getRoleById(roleId));
                }
            }

            return Result(userService.createUser(user));
        }
        catch (Exception e){
            log.error(e.getMessage());
            return Result(false);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ManageUsers')")
    @ApiOperation(value = "删除指定Id的用户", notes = "该操作为逻辑删除")
    @ApiImplicitParam(paramType="query", name = "id", value = "用户Id", required = true, dataType = "String")
    public Result delete(@PathVariable String id) {

        User user = userService.getUserById(id);
        if(user != null){
            return Result(userService.deleteUser(user));
        }
        else {
            return Result(false);
        }
    }

    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('ManageUsers')")
    @ApiOperation(value = "根据Id集合批量删除用户", notes = "该操作为逻辑删除", produces = "application/json")
    @ApiImplicitParam(paramType="query", name = "ids", value = "用户Id集合", dataType = "List<String>")
    public Result delete(@RequestBody List<String> ids) {

        if(ids != null){
            for(String id : ids){
                userService.deleteUser(userService.getUserById(id));
            }
            return Result(true);
        }
        else {
            return Result(false);
        }
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ManageUsers')")
    @ApiOperation(value = "修改用户信息", notes = "传输Json格式用户对象", produces = "application/json")
    @ApiImplicitParam(paramType="body", name = "user", value = "有效的用户实例", required = true, dataType = "User")
    public Result edit(@Valid @RequestBody User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            FieldError error = (FieldError) bindingResult.getAllErrors().get(0);
            return new Result().validateFailed(error.getDefaultMessage());
        }
        if(user != null){
            try {
                return Result(userService.updateUser(user));
            }
            catch (Exception e){
                log.error(e.getMessage());
                return Result(false);
            }
        }
        else {
            return Result(false);
        }
    }

    @PutMapping("/password")
    @PreAuthorize("hasAnyAuthority('ManageUsers')")
    @ApiOperation(value = "修改用户密码", notes = "传输Json格式用户对象", produces = "application/json")
    @ApiImplicitParam(paramType="body", name = "request", value = "有效的用户密码请求", required = true, dataType = "ChangePasswordRequest")
    public Result changePassword(@RequestBody ChangePasswordRequest request, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            FieldError error = (FieldError) bindingResult.getAllErrors().get(0);
            return new Result().validateFailed(error.getDefaultMessage());
        }
        if(request == null){
            return new Result().validateFailed("request不能为空");
        }
        if(StringUtil.isEmpty(request.userId)){
            return new Result().validateFailed("userId不能为空");
        }

        User user = userService.getUserById(request.userId);
        if(user == null){
            return new Result().validateFailed("Id为" + request.userId + "的用户不存在");
        }

        // 密码加密
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        if(request.validateRequest && encoder.matches(request.oldPassword, user.getPassword())){
            return new Result().validateFailed("原始密码不正确");
        }

        if(request.oldPassword == request.newPassword){
            return new Result().validateFailed("新密码不能与原始密码相同");
        }

        user.setPassword(encoder.encode(request.newPassword));
        return Result(userService.updateUser(user));
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ManageUsers')")
    @ApiOperation(value = "分页查询指定条件的用户集合")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "createdFrom", value = "开始日期", dataType = "Date"),
            @ApiImplicitParam(paramType = "query", name = "createdTo", value = "结束日期", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "username", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "fullName", value = "姓名", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "roleIds", value = "角色Id集合", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "phone", value = "电话号码",  dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "email", value = "电子邮箱", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "active", value = "激活", dataType = "boolean"),
            @ApiImplicitParam(paramType = "query", name = "sorts", value = "排序属性，英文逗号分隔，前缀-为倒序", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "filters", value = "输出属性过滤，多个条件用英文逗号分隔",  dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "page", value = "分页，格式为{页数},{每页记录数}，例如'1,20'", defaultValue = "1,20", dataType = "String")
    })
    public Result list(@RequestParam Date createdFrom, @RequestParam Date createdTo, @RequestParam String username,
                       @RequestParam String fullName, @RequestParam String roleIds, @RequestParam String phone,
                       @RequestParam String email, @RequestParam boolean active, @RequestParam String sorts,
                       @RequestParam String filters, @RequestParam(defaultValue = "1,20") String page) {

        int total = userService.getAllUsers(createdFrom, createdTo, username, fullName, roleIds, phone,
                email, active, sorts, "1," + Integer.MAX_VALUE).size();

        List users = userService.getAllUsers(createdFrom, createdTo, username, fullName, roleIds, phone,
                email, active, sorts, page);

        // 处理过滤
        if(!StringUtil.isEmpty(filters)) {
            return new Result().pageSuccess(total, JsonUtil.objectToJson(users, filters));
        }else {
            return new Result().pageSuccess(total, JsonUtil.objectToJson(users));
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ManageUsers')")
    @ApiOperation(value = "查询指定Id的用户")
    @ApiImplicitParam(paramType="query", name = "id", value = "用户Id", required = true, dataType = "String")
    public Result get(@PathVariable String id) {

        return Result(userService.getUserById(id));
    }

    @GetMapping("/username/{username}")
    @PreAuthorize("hasAnyAuthority('ManageUsers')")
    @ApiOperation(value = "查询指定username的用户")
    @ApiImplicitParam(paramType="query", name = "username", value = "用户名", required = true, dataType = "String")
    public Result getByUsername(@PathVariable String username) {

        return Result(userService.getUserByUsername(username));
    }

    @GetMapping("/info")
    @PreAuthorize("hasAnyAuthority('ManageUsers')")
    @ApiOperation(value = "获取当前微服务部署地址和端口号")
    public Result info()
    {
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
