package com.fenjin.fjtms.core.services.users;

import com.fenjin.fjtms.core.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @ClassName: RoleClientServiceFallbackFactory
 * @Descriprion: TODO(用一句话描述这个类的作用)
 * @author: changzhengmao
 * @date: 2019-03-06 12:13
 */
@Component
public class RoleClientServiceFallbackFactory implements FallbackFactory<IRoleClientService> {
    @Override
    public IRoleClientService create(Throwable throwable) {
        return new IRoleClientService() {
            @Override
            public Result getByUserId(String userId) {
                return new Result().failed("用户Id为" + userId + "的用户没有分配任何角色");
            }
        };
    }
}
