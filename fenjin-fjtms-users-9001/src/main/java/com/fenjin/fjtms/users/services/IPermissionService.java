package com.fenjin.fjtms.users.services;

import com.fenjin.fjtms.core.domain.users.Permission;
import com.fenjin.fjtms.core.domain.users.Role;

import java.util.List;

/**
 * @version 1.0
 * @ClassName: IPermissionService
 * @Descriprion: TODO(用一句话描述这个接口的作用)
 * @author: changzhengmao
 * @date: 2019-03-05 19:24
 */
public interface IPermissionService {

    /**
     * 查询权限信息
     * @param permissionname
     * @return
     */
    List<Permission> getAllPermissions(String permissionname);

    /**
     * 根据Id查询权限信息
     * @param id
     * @return 权限
     */
    Permission getPermissionById(String id);

    /**
     * 根据用户Id查询角色列表
     * @param roleId
     * @return 角色列表
     */
    List<Permission> getPermissionsByRoleId(String roleId);

    /**
     * 创建权限
     * @param permission
     */
    boolean createPermission(Permission permission);

    /**
     * 删除权限
     * @param permission
     * @return
     */
    boolean deletePermission(Permission permission);

    /**
     * 修改权限
     * @param permission
     * @return
     */
    boolean updatePermission(Permission permission);
}
