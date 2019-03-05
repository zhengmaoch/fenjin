package com.fenjin.fjtms.core.services.users;

import com.fenjin.fjtms.core.CommonResult;
import com.fenjin.fjtms.core.domain.users.User;
import com.fenjin.fjtms.core.models.users.UserSearchModel;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过FallbackFactory实现对IUserClientService所有方法的降级处理，
 * 达到对UserController注解@HystrixCommand达到服务熔断的解耦，避免代码膨胀
 */
@Component
public class UserClientServiceFallbackFactory implements FallbackFactory<IUserClientService> {

    @Override
    public IUserClientService create(Throwable throwable) {
        return new IUserClientService(){

            @Override
            public CommonResult create(User user) {
                return new CommonResult().failed();
            }

            @Override
            public CommonResult delete(String id) {
                return new CommonResult().failed();
            }

            @Override
            public CommonResult delete(List<String> ids) {
                return new CommonResult().failed();
            }

            @Override
            public CommonResult edit(User user) {
                return new CommonResult().failed();
            }

            @Override
            public CommonResult list(UserSearchModel userSearchModel, Integer pageIndex, Integer pageSize) {
                return new CommonResult().failed();
            }

            @Override
            public CommonResult get(String id) {
                return new CommonResult().failed();
            }

            @Override
            public CommonResult getUserByUsername(String username) {
                return new CommonResult().failed();
            }

            @Override
            public CommonResult discovery() {
                return new CommonResult().failed();
            }
        };
    }
}
