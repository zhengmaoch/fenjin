package com.fenjin.fjtms.users.dao;


import com.fenjin.fjtms.core.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends JpaRepository<User, String >, JpaSpecificationExecutor<User> {
}
