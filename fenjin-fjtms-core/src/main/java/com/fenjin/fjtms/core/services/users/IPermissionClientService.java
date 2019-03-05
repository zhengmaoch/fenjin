package com.fenjin.fjtms.core.services.users;

import com.fenjin.fjtms.core.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @version 1.0
 * @ClassName: IPermissionClientService
 * @Descriprion: TODO(用一句话描述这个类的作用)
 * @author: changzhengmao
 * @date: 2019-03-01 17:56
 */
@FeignClient(value = "FENJIN-FJTMS-USERS")
public interface IPermissionClientService {

    @GetMapping("/permissions/getPermissionByRoleId/{roleId}")
    Result getPermissionsByRoleId(String roleId);
}
