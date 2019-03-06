package com.fenjin.fjtms.users.controllers;


import com.fenjin.fjtms.core.BaseController;
import com.fenjin.fjtms.core.Result;
import com.fenjin.fjtms.core.domain.users.User;
import com.fenjin.fjtms.core.models.users.UserSearchModel;
import com.fenjin.fjtms.core.utils.StringUtil;
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
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@Api(tags = "UserController",description = "用户管理控制器")
@RequestMapping("/users")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    // 服务发现客户端
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('create')")
    @ApiOperation(value = "创建新用户", notes = "用户Id由系统自动生成，Json格式用户对象", produces = "application/json")
    @ApiImplicitParam(paramType="body", name = "user", value = "有效的用户实例", required = true, dataType = "User")
    public Result create(@Valid @RequestBody User user, BindingResult bindingResult) {

        // 后续问题：前台除了提供用户基本信息，也需要提供该用户的用户角色，用户所属部门等信息。

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

            return Result(userService.createUser(user));
        }
        catch (Exception e){
            log.error(e.getMessage());
            return Result(false);
        }
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('delete')")
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

    @DeleteMapping("/delete")
    @PreAuthorize("hasAnyAuthority('delete')")
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

    @PutMapping("/edit")
    @PreAuthorize("hasAnyAuthority('edit')")
    @ApiOperation(value = "修改用户", notes = "传输Json格式用户对象", produces = "application/json")
    @ApiImplicitParam(paramType="body", name = "user", value = "有效的用户实例", required = true, dataType = "User")
    public Result edit(@Valid @RequestBody User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            FieldError error = (FieldError) bindingResult.getAllErrors().get(0);
            return new Result().validateFailed(error.getDefaultMessage());
        }
        if(user != null){
            try {
                userService.updateUser(user);
                return Result(true);
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

    @PostMapping("/list/{pageIndex}/{pageSize}")
    @PreAuthorize("hasAnyAuthority('query')")
    @ApiOperation(value = "分页查询指定条件的用户集合")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", name = "userSearchModel", value = "用户查询参数", required = false, dataType = "UserSearchModel"),
            @ApiImplicitParam(paramType = "query", name = "pageIndex", value = "当前页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    public Result list(@RequestBody(required = false) UserSearchModel userSearchModel, @PathVariable Integer pageIndex, @PathVariable Integer pageSize) {

        int total = userService.getAllUsers(userSearchModel, 0, Integer.MAX_VALUE).size();
        List users = userService.getAllUsers(userSearchModel, pageIndex, pageSize);
        return Result(pageIndex, pageSize, total, users);
    }


    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyAuthority('query')")
    @ApiOperation(value = "查询指定Id的用户")
    @ApiImplicitParam(paramType="query", name = "id", value = "用户Id", required = true, dataType = "String")
    public Result get(@PathVariable String id) {

        return Result(userService.getUserById(id));
    }

    @GetMapping("/discovery")
    @PreAuthorize("hasAnyAuthority('manager')")
    @ApiOperation(value = "获取当前微服务部署地址和端口号")
    public Result discovery()
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
