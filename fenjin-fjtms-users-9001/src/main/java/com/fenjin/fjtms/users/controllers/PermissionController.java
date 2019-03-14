package com.fenjin.fjtms.users.controllers;


import com.fenjin.fjtms.core.BaseController;
import com.fenjin.fjtms.core.RequestBodyList;
import com.fenjin.fjtms.core.Result;
import com.fenjin.fjtms.core.domain.users.Permission;
import com.fenjin.fjtms.users.services.IPermissionService;
import com.fenjin.fjtms.users.services.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
@Api(tags = "PermissionController",description = "权限管理控制器")
@RequestMapping("/permissions")
public class PermissionController extends BaseController {

    @Autowired
    private IPermissionService permissionService;

    // 服务发现客户端
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ManagePermissions')")
    @ApiOperation(value = "创建新权限", notes = "权限Id由系统自动生成，Json格式权限对象", produces = "application/json")
    @ApiImplicitParam(paramType="body", name = "permission", value = "有效的权限实例", required = true, dataType = "Permission")
    public Result create(@Valid @RequestBody Permission permission, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            FieldError error = (FieldError) bindingResult.getAllErrors().get(0);
            return new Result().validateFailed(error.getDefaultMessage());
        }
        try {

            if(permissionService.getAllPermissions(permission.getName()).size() > 0){
                return new Result().validateFailed("权限名已存在");
            }

            return Result(permissionService.createPermission(permission));
        }
        catch (Exception e){
            log.error(e.getMessage());
            return Result(false);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ManagePermissions')")
    @ApiOperation(value = "删除指定Id的权限", notes = "该操作为逻辑删除")
    @ApiImplicitParam(paramType="query", name = "id", value = "权限Id", required = true, dataType = "String")
    public Result delete(@PathVariable String id) {

        Permission permission = permissionService.getPermissionById(id);
        if(permission != null){
            return Result(permissionService.deletePermission(permission));
        }
        else {
            return Result(false);
        }
    }

    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('ManagePermissions')")
    @ApiOperation(value = "根据Id集合批量删除权限", notes = "该操作为逻辑删除", produces = "application/json")
    @ApiImplicitParam(paramType="query", name = "ids", value = "权限Id的RequestBodyList集合", dataType = "RequestBodyList<String>")
    public Result delete(@RequestBody RequestBodyList<String> ids) {

        if(ids != null){
            for(String id : ids.getLists()){
                permissionService.deletePermission(permissionService.getPermissionById(id));
            }
            return Result(true);
        }
        else {
            return Result(false);
        }
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ManagePermissions')")
    @ApiOperation(value = "修改权限信息", notes = "传输Json格式权限对象", produces = "application/json")
    @ApiImplicitParam(paramType="body", name = "permission", value = "有效的权限实例", required = true, dataType = "Permission")
    public Result edit(@Valid @RequestBody Permission permission, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            FieldError error = (FieldError) bindingResult.getAllErrors().get(0);
            return new Result().validateFailed(error.getDefaultMessage());
        }
        if(permission != null){
            try {
                permissionService.updatePermission(permission);
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

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ManagePermissions')")
    @ApiOperation(value = "查询指定条件的权限集合")
    public Result list(@RequestBody(required = false) String permissionName) {

        return Result(permissionService.getAllPermissions(permissionName));
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ManagePermissions')")
    @ApiOperation(value = "查询指定Id的权限")
    @ApiImplicitParam(paramType="query", name = "id", value = "权限Id", required = true, dataType = "String")
    public Result get(@PathVariable String id) {

        return Result(permissionService.getPermissionById(id));
    }

    @GetMapping("/roleid/{roleId}")
    @PreAuthorize("hasAnyAuthority('ManagePermissions')")
    @ApiOperation(value = "查询指定roleId的权限集合")
    public Result getByRoleId(@PathVariable String roleId) {

        return Result(permissionService.getPermissionsByRoleId(roleId));
    }

    @GetMapping("/info")
    @PreAuthorize("hasAnyAuthority('ManagePermissions')")
    @ApiOperation(value = "获取当前微服务部署地址和端口号")
    public Result info()
    {
        List<String> list = discoveryClient.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = discoveryClient.getInstances("FENJIN-SERVICES-PERMISSIONS");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return Result(this.discoveryClient);
    }
}
