package com.fenjin.cloud.dao;


import com.fenjin.fjtms.core.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IUserRepository extends JpaRepository<User, String >, JpaSpecificationExecutor<User> {
}
