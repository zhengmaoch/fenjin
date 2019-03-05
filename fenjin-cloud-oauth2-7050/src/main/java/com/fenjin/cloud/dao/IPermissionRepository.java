package com.fenjin.cloud.dao;

import com.fenjin.fjtms.core.domain.users.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @version 1.0
 * @ClassName: IPermissionRepository
 * @Descriprion: TODO(用一句话描述这个类的作用)
 * @author: changzhengmao
 * @date: 2019-03-05 17:30
 */
public interface IPermissionRepository extends JpaRepository<Permission, String >, JpaSpecificationExecutor<Permission> {
}
