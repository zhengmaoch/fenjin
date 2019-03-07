package com.fenjin.cloud.cotrollers;

import com.fenjin.fjtms.core.Result;
import com.fenjin.fjtms.core.services.users.IPermissionClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @ClassName: PermissionController
 * @Descriprion: TODO(用一句话描述这个类的作用)
 * @author: changzhengmao
 * @date: 2019-03-07 20:10
 */
@RestController
@RequestMapping("/permissions")
public class PermissionController {

    @Autowired
    private IPermissionClientService permissionClientService;

    @GetMapping("/getByRoleId/{roleId}")
    Result getByRoleId(@PathVariable String roleId){
        return permissionClientService.getByRoleId(roleId);
    }
}
