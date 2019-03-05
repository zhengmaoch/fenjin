package com.fenjin.fjtms.core.services.users;

import com.fenjin.fjtms.core.Result;
import com.fenjin.fjtms.core.domain.users.User;
import com.fenjin.fjtms.core.models.users.UserSearchModel;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

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
            public Result create(User user) {
                return new Result().failed();
            }

            @Override
            public Result delete(String id) {
                return new Result().failed();
            }

            @Override
            public Result delete(List<String> ids) {
                return new Result().failed();
            }

            @Override
            public Result edit(User user) {
                return new Result().failed();
            }

            @Override
            public Result list(UserSearchModel userSearchModel, Integer pageIndex, Integer pageSize) {
                return new Result().failed();
            }

            @Override
            public Result get(String id) {
                return new Result().failed();
            }

            @Override
            public Result getUserByUsername(String username) {
                return new Result().failed();
            }

            @Override
            public Result discovery() {
                return new Result().failed();
            }
        };
    }
}
