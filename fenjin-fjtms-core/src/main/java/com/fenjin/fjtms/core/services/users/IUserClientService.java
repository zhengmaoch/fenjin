package com.fenjin.fjtms.core.services.users;

import com.fenjin.fjtms.core.CommonResult;
import com.fenjin.fjtms.core.domain.users.User;
import com.fenjin.fjtms.core.models.users.UserSearchModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 客户端面向接口编程来访问微服务FENJIN-FJTMS-USERS，服务降级熔断由UserClientServiceFallbackFactory负责处理
 */
@FeignClient(value = "FENJIN-FJTMS-USERS", fallbackFactory = UserClientServiceFallbackFactory.class)
public interface IUserClientService {

    @PostMapping("/users/create")
    CommonResult create(@RequestBody User user);

    @DeleteMapping("/users/delete/{id}")
    CommonResult delete(@PathVariable("id") String id);

    @DeleteMapping("/users/delete")
    CommonResult delete(@RequestBody List<String> ids);

    @PutMapping("/users/edit")
    CommonResult edit(@RequestBody User user);

    @PostMapping("/list/{pageIndex}/{pageSize}")
    CommonResult list(@RequestBody(required = false) UserSearchModel userSearchModel, @PathVariable("pageIndex") Integer pageIndex, @PathVariable("pageSize") Integer pageSize);

    @GetMapping("/users/get/{id}")
    CommonResult get(@PathVariable("id") String id);

    /**
     * 根据用户名称查询用户信息
     * @param username
     * @return 用户
     */
    @GetMapping("/users/getByUsername/{username}")
    CommonResult getUserByUsername(@PathVariable("username") String username);

    @GetMapping("/users/discovery")
    CommonResult discovery();
}
