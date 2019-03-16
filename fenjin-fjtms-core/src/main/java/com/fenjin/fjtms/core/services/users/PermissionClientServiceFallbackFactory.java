package com.fenjin.fjtms.core.services.users;

import com.fenjin.fjtms.core.controller.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @ClassName: PermissionClientServiceFallbackFactory
 * @Descriprion: TODO(用一句话描述这个类的作用)
 * @author: changzhengmao
 * @date: 2019-03-06 12:13
 */
@Component
public class PermissionClientServiceFallbackFactory implements FallbackFactory<IPermissionClientService> {
    @Override
    public IPermissionClientService create(Throwable throwable) {
        return new IPermissionClientService() {
            @Override
            public Result getByRoleId(String roleId) {
                return new Result().failed("角色Id为" + roleId + "的角色没有分配任何权限");
            }
        };
    }
}
