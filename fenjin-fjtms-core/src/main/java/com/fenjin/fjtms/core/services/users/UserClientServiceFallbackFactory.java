package com.fenjin.fjtms.core.services.users;

import com.fenjin.fjtms.core.Result;
import com.fenjin.fjtms.core.domain.users.User;
import com.fenjin.fjtms.core.models.users.UserSearchModel;
import com.fenjin.fjtms.core.query.AuthQuery;
import feign.hystrix.FallbackFactory;
import org.bouncycastle.asn1.ocsp.ResponseData;
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
            public Result getByUsername(String username) {
                return new Result().failed("用户" + username + "不存在");
            }
        };
    }
}
