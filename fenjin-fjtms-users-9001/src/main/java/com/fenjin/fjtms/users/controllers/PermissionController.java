package com.fenjin.fjtms.users.controllers;


import com.fenjin.fjtms.core.BaseController;
import com.fenjin.fjtms.core.Result;
import com.fenjin.fjtms.core.domain.users.Permission;
import com.fenjin.fjtms.users.services.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@Api(tags = "PermissionController",description = "权限管理控制器")
@RequestMapping("/permission")
public class PermissionController extends BaseController {

    @Autowired
    private PermissionService permissionService;

    // 服务发现客户端
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    @ApiOperation(value = "创建新权限", notes = "权限Id由系统自动生成，Json格式权限对象", produces = "application/json")
    @ApiImplicitParam(paramType="body", name = "permission", value = "有效的权限实例", required = true, dataType = "Permission")
    public Result create(@Valid @RequestBody Permission permission, BindingResult bindingResult) {

        // 后续问题：前台除了提供权限基本信息，也需要提供该权限的权限角色，权限所属部门等信息。

        if (bindingResult.hasErrors()) {
            FieldError error = (FieldError) bindingResult.getAllErrors().get(0);
            return new Result().validateFailed(error.getDefaultMessage());
        }
        try {

            if(permissionService.getAllPermissions(permission.getName()) != null){
                return new Result().validateFailed("权限名已存在");
            }

            return commonResult(permissionService.createPermission(permission));
        }
        catch (Exception e){
            log.error(e.getMessage());
            return commonResult(false);
        }
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除指定Id的权限", notes = "该操作为逻辑删除")
    @ApiImplicitParam(paramType="query", name = "id", value = "权限Id", required = true, dataType = "String")
    public Result delete(@PathVariable String id) {

        Permission permission = permissionService.getPermissionById(id);
        if(permission != null){
            return commonResult(permissionService.deletePermission(permission));
        }
        else {
            return commonResult(false);
        }
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "根据Id集合批量删除权限", notes = "该操作为逻辑删除", produces = "application/json")
    @ApiImplicitParam(paramType="query", name = "ids", value = "权限Id集合", dataType = "List<String>")
    public Result delete(@RequestBody List<String> ids) {

        if(ids != null){
            for(String id : ids){
                permissionService.deletePermission(permissionService.getPermissionById(id));
            }
            return commonResult(true);
        }
        else {
            return commonResult(false);
        }
    }

    @PutMapping("/edit")
    @ApiOperation(value = "修改权限", notes = "传输Json格式权限对象", produces = "application/json")
    @ApiImplicitParam(paramType="body", name = "permission", value = "有效的权限实例", required = true, dataType = "Permission")
    public Result edit(@Valid @RequestBody Permission permission, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            FieldError error = (FieldError) bindingResult.getAllErrors().get(0);
            return new Result().validateFailed(error.getDefaultMessage());
        }
        if(permission != null){
            try {
                permissionService.updatePermission(permission);
                return commonResult(true);
            }
            catch (Exception e){
                log.error(e.getMessage());
                return commonResult(false);
            }
        }
        else {
            return commonResult(false);
        }


    }

    @PostMapping("/list")
    @ApiOperation(value = "查询指定条件的权限集合")
    public Result list(@RequestBody(required = false) String permissionName) {

        List<Permission> permissions = permissionService.getAllPermissions(permissionName);
        return commonResult(permissions);
    }


    @GetMapping("/get/{id}")
    @ApiOperation(value = "查询指定Id的权限")
    @ApiImplicitParam(paramType="query", name = "id", value = "权限Id", required = true, dataType = "String")
    public Result get(@PathVariable String id) {

        return commonResult(permissionService.getPermissionById(id));
    }

    @PostMapping("/getByRoleId/{roleId}")
    @ApiOperation(value = "查询指定roleId的权限集合")
    public Result getByRoleId(@PathVariable String roleId) {

        List<Permission> permissions = permissionService.getPermissionsByRoleId(roleId);
        return commonResult(permissions);
    }

    @GetMapping("/discovery")
    @ApiOperation(value = "获取当前微服务部署地址和端口号")
    public Result discovery()
    {
        List<String> list = discoveryClient.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = discoveryClient.getInstances("FENJIN-SERVICES-PERMISSIONS");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return commonResult(this.discoveryClient);
    }
}
