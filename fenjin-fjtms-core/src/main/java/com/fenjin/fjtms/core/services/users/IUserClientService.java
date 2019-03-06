package com.fenjin.fjtms.core.services.users;

import com.fenjin.fjtms.core.Result;
import com.fenjin.fjtms.core.domain.users.User;
import com.fenjin.fjtms.core.models.users.UserSearchModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 客户端面向接口编程来访问微服务FENJIN-FJTMS-USERS，服务降级熔断由UserClientServiceFallbackFactory负责处理
 */
@FeignClient(value = "FENJIN-FJTMS-USERS", fallbackFactory = UserClientServiceFallbackFactory.class)
public interface IUserClientService {

    /**
     * 根据用户名称查询用户信息
     * @param username
     * @return 用户
     */
    @GetMapping("/users/getByUsername/{username}")
    Result getByUsername(@PathVariable("username") String username);
}
