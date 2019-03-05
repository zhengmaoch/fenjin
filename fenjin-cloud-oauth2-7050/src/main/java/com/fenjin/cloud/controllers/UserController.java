package com.fenjin.cloud.controllers;

import com.fenjin.fjtms.core.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @version 1.0
 * @ClassName: UserController
 * @Descriprion: TODO(用户信息查看及注销logout)
 * @author: changzhengmao
 * @date: 2019-03-01 16:49
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    /**
     * 通过token获取用户信息
     * @param user
     * @return
     */
    @GetMapping("/user")
    public Principal user(Principal user) {

        return user;
    }

    @DeleteMapping(value = "/exit")
    public CommonResult revokeToken(String token){

        if (consumerTokenServices.revokeToken(token)){
            return new CommonResult().success("注销成功");
        }else {
            return new CommonResult().failed();
        }
    }
}