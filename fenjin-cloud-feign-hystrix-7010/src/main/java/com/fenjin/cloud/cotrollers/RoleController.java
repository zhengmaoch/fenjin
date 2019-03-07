package com.fenjin.cloud.cotrollers;

import com.fenjin.fjtms.core.Result;
import com.fenjin.fjtms.core.services.users.IRoleClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @ClassName: RoleController
 * @Descriprion: TODO(用一句话描述这个类的作用)
 * @author: changzhengmao
 * @date: 2019-03-07 20:10
 */
@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private IRoleClientService roleClientService;

    @GetMapping("/getByUserId/{userId}")
    public Result get(@PathVariable("userId") String userId){

        return roleClientService.getByUserId(userId);
    }
}
