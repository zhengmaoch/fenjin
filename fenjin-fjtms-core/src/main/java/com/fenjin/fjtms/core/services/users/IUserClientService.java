package com.fenjin.fjtms.core.services.users;

import com.fenjin.fjtms.core.domain.users.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 客户端面向接口编程来访问微服务FENJIN-FJTMS-USERS，服务降级熔断由UserClientServiceFallbackFactory负责处理
 */
@FeignClient(value = "FENJIN-FJTMS-USERS", fallbackFactory = UserClientServiceFallbackFactory.class)
public interface IUserClientService {

    @PostMapping("/user/create")
    void create(User user);

    @DeleteMapping("/user/delete/{id}")
    void delete(@PathVariable("id") String id);

    @PutMapping("/user/edit")
    void edit(User user);

    @GetMapping("/user/list")
    List<User> list();

    @GetMapping("/user/get/{id}")
    User get(@PathVariable("id") String id);

    @GetMapping("/discovery")
    Object discovery();
}
