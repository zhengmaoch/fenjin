package com.fenjin.fjtms.core.services.auths;

import com.fenjin.fjtms.core.controller.Result;
import com.fenjin.fjtms.core.query.AuthQuery;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @ClassName: AuthClientServiceFallbackFactory
 * @Descriprion: TODO(通过FallbackFactory实现对IAuthClientService所有方法的降级处理)
 * @author: changzhengmao
 * @date: 2019-03-12 23:29
 */
@Component
public class AuthClientServiceFallbackFactory implements FallbackFactory<IAuthClientService> {

    @Override
    public IAuthClientService create(Throwable throwable) {
        return new IAuthClientService() {

            @Override
            public Result auth(AuthQuery query) {
                return new Result().failed("授权失败");
            }

        };
    }
}
