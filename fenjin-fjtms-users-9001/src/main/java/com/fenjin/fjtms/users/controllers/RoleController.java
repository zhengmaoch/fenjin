package com.fenjin.fjtms.users.controllers;

import com.fenjin.fjtms.core.controller.BaseController;
import com.fenjin.fjtms.core.controller.RequestBodyList;
import com.fenjin.fjtms.core.controller.Result;
import com.fenjin.fjtms.core.domain.users.Role;
import com.fenjin.fjtms.users.services.IRoleService;
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
@Api(tags = "RoleController",description = "角色管理控制器")
@RequestMapping("/roles")
public class RoleController extends BaseController {

    @Autowired
    private IRoleService roleService;

    // 服务发现客户端
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ManageRoles')")
    @ApiOperation(value = "创建新角色", notes = "角色Id由系统自动生成，Json格式角色对象", produces = "application/json")
    @ApiImplicitParam(paramType="body", name = "role", value = "有效的角色实例", required = true, dataType = "Role")
    public Result create(@Valid @RequestBody Role role, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            FieldError error = (FieldError) bindingResult.getAllErrors().get(0);
            return new Result().validateFailed(error.getDefaultMessage());
        }
        try {

            if(roleService.getAllRoles(role.getName()).size() > 0){
                return new Result().validateFailed("角色名已存在");
            }

            return Result(roleService.createRole(role));
        }
        catch (Exception e){
            log.error(e.getMessage());
            return Result(false);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ManageRoles')")
    @ApiOperation(value = "删除指定Id的角色", notes = "该操作为逻辑删除")
    @ApiImplicitParam(paramType="query", name = "id", value = "角色Id", required = true, dataType = "String")
    public Result delete(@PathVariable String id) {

        Role role = roleService.getRoleById(id);
        if(role != null){
            return Result(roleService.deleteRole(role));
        }
        else {
            return Result(false);
        }
    }

    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('ManageRoles')")
    @ApiOperation(value = "根据Id集合批量删除角色", notes = "该操作为逻辑删除", produces = "application/json")
    @ApiImplicitParam(paramType="query", name = "ids", value = "角色Id的RequestBodyList集合", dataType = "RequestBodyList<String>")
    public Result delete(@RequestBody RequestBodyList<String> ids) {

        if(ids != null){
            for(String id : ids.getLists()){
                roleService.deleteRole(roleService.getRoleById(id));
            }
            return Result(true);
        }
        else {
            return Result(false);
        }
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ManageRoles')")
    @ApiOperation(value = "修改角色信息", notes = "传输Json格式角色对象", produces = "application/json")
    @ApiImplicitParam(paramType="body", name = "role", value = "有效的角色实例", required = true, dataType = "Role")
    public Result edit(@Valid @RequestBody Role role, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            FieldError error = (FieldError) bindingResult.getAllErrors().get(0);
            return new Result().validateFailed(error.getDefaultMessage());
        }
        if(role != null){
            try {
                return Result(roleService.updateRole(role));
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
    @PreAuthorize("hasAnyAuthority('ManageRoles')")
    @ApiOperation(value = "查询指定条件的角色集合")
    public Result list(@RequestBody(required = false) String roleName) {

        return Result(roleService.getAllRoles(roleName));
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ManageRoles')")
    @ApiOperation(value = "查询指定Id的角色")
    @ApiImplicitParam(paramType="query", name = "id", value = "角色Id", required = true, dataType = "String")
    public Result get(@PathVariable String id) {

        return Result(roleService.getRoleById(id));
    }

    @GetMapping("/userid/{userId}")
    @PreAuthorize("hasAnyAuthority('ManageRoles')")
    @ApiOperation(value = "查询指定userId的角色集合")
    public Result getByUserId(@PathVariable String userId) {

        return Result(roleService.getRolesByUserId(userId));
    }

    @GetMapping("/info")
    @PreAuthorize("hasAnyAuthority('ManageRoles')")
    @ApiOperation(value = "获取当前微服务部署地址和端口号")
    public Result info()
    {
        List<String> list = discoveryClient.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = discoveryClient.getInstances("FENJIN-SERVICES-ROLES");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return Result(this.discoveryClient);
    }
}
