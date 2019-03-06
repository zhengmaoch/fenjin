package com.fenjin.fjtms.users.dao;

import com.fenjin.fjtms.core.domain.users.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName: IPermissionRepository
 * @Descriprion: TODO(用一句话描述这个类的作用)
 * @author: changzhengmao
 * @date: 2019-03-05 17:30
 * @version 1.0
 */
public interface IRoleRepository extends JpaRepository<Role, String >, JpaSpecificationExecutor<Role> {
}
