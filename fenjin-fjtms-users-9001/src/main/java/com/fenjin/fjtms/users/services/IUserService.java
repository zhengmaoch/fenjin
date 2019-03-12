package com.fenjin.fjtms.users.services;


import com.fenjin.fjtms.core.domain.users.User;
import com.fenjin.fjtms.core.models.users.UserSearchModel;

import java.util.List;

/**
 * @ClassName: IUserService
 * @Descriprion: TODO(用户服务)
 * @author: changzhengmao
 * @date: 2019-02-28 17:30
 * @version 1.0
 */
public interface IUserService {

    /**
     * 分页查询用户信息
     * @param userSearchModel
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<User> getAllUsers(UserSearchModel userSearchModel, int pageIndex, int pageSize);

    /**
     * 根据Id查询用户信息
     * @param id
     * @return 用户
     */
    User getUserById(String id);

    /**
     * 根据用户名称查询用户信息
     * @param username
     * @return 用户
     */
    User getUserByUsername(String username);

    /**
     * 根据邮箱地址查询用户信息
     * @param email
     * @return 用户
     */
    User getUserByEmail(String email);

    /**
     * 创建用户
     * @param user
     */
    User createUser(User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    User deleteUser(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    User updateUser(User user);

}