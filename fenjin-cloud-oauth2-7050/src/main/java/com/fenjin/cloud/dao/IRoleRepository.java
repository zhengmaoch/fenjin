package com.fenjin.cloud.dao;

import com.fenjin.fjtms.core.domain.users.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
<<<<<<< HEAD
 * @version 1.0
 * @ClassName: IRoleRepository
 * @Descriprion: TODO(用一句话描述这个类的作用)
 * @author: changzhengmao
 * @date: 2019-03-05 17:29
=======
 * @ClassName: IPermissionRepository
 * @Descriprion: TODO(用一句话描述这个类的作用)
 * @author: changzhengmao
 * @date: 2019-03-05 17:30
 * @version 1.0
>>>>>>> bf79e174b8c2617d8b2697ebc17153546a859359
 */
public interface IRoleRepository extends JpaRepository<Role, String >, JpaSpecificationExecutor<Role> {
}
