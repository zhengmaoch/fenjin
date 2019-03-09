package com.fenjin.cloud.services;


import com.fenjin.fjtms.core.domain.users.Permission;
import com.fenjin.fjtms.core.domain.users.Role;
import com.fenjin.fjtms.core.domain.users.User;
import com.fenjin.fjtms.core.models.users.UserSearchModel;

import java.util.List;

/**
 * @ClassName: IAuthService
 * @Descriprion: TODO(用一句话描述这个类的作用)
 * @author: changzhengmao
 * @date: 2019-02-28 17:30
 * @version 1.0
 */
public interface IAuthService {

    User getUserByUsername(String username);

    /**
     * 根据用户Id查询角色列表
     * @param userId
     * @return 角色列表
     */
    List<Role> getRolesByUserId(String userId);

    /**
     * 根据用户Id查询角色列表
     * @param roleId
     * @return 角色列表
     */
    List<Permission> getPermissionsByRoleId(String roleId);
}