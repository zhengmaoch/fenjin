package com.fenjin.fjtms.users.services;

import com.fenjin.fjtms.core.domain.users.Role;

import java.util.List;

/**
 * @version 1.0
 * @ClassName: IRoleService
 * @Descriprion: TODO(用一句话描述这个接口的作用)
 * @author: changzhengmao
 * @date: 2019-03-05 19:23
 */
public interface IRoleService {

    /**
     * 查询角色信息
     * @param rolename
     * @return
     */
    List<Role> getAllRoles(String rolename);

    /**
     * 根据Id查询角色信息
     * @param id
     * @return 角色
     */
    Role getRoleById(String id);

    /**
     * 根据用户Id查询角色列表
     * @param userId
     * @return 角色列表
     */
    List<Role> getRolesByUserId(String userId);

    /**
     * 创建角色
     * @param role
     */
    Role createRole(Role role);

    /**
     * 删除角色
     * @param role
     * @return
     */
    Role deleteRole(Role role);

    /**
     * 修改角色
     * @param role
     * @return
     */
    Role updateRole(Role role);
}
