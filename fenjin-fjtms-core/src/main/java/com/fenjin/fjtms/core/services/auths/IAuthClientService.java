package com.fenjin.fjtms.core.services.auths;

import com.fenjin.fjtms.core.Result;
import com.fenjin.fjtms.core.config.FeignConfiguration;
import com.fenjin.fjtms.core.query.AuthQuery;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @version 1.0
 * @ClassName: AuthRemoteClient
 * @Descriprion: TODO(认证服务API调用客户端)
 * @author: changzhengmao
 * @date: 2019-03-12 23:27
 */
@FeignClient(value = "FENJIN-CLOUD-OAUTH2", path = "/oauth",configuration = FeignConfiguration.class, fallbackFactory = AuthClientServiceFallbackFactory.class)
public interface IAuthClientService {

    /**
     * 调用认证,获取token
     * @param query
     * @return
     */
    @PostMapping("/token")
    Result auth(@RequestBody AuthQuery query);
}
