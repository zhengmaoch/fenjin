package com.fenjin.fjtms.users.services;

import com.fenjin.fjtms.core.domain.users.Role;
import com.fenjin.fjtms.core.domain.users.User;
import com.fenjin.fjtms.core.utils.DateUtils;
import com.fenjin.fjtms.core.utils.StringUtil;
import com.fenjin.fjtms.users.dao.IRoleRepository;
import com.fenjin.fjtms.users.dao.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @ClassName: RoleService
 * @Descriprion: TODO(用一句话描述这个类的作用)
 * @author: changzhengmao
 * @date: 2019-03-05 19:34
 */
@Service
public class RoleService implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private IUserRepository userRepository;
    
    @Override
//    @Cacheable(cacheNames = "roles", key = "'rolesbyrolename_'+#rolename")
    public List<Role> getAllRoles(String rolename) {
        
        Specification<Role> specification = new Specification<Role>() {
            @Override
            public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                if(StringUtil.isEmpty(rolename)) {
                    return null;
                }
                return cb.like(root.get("name").as(String.class), "%" + rolename + "%");
            }
        };

        return roleRepository.findAll(specification);
    }

    @Override
    @Cacheable(cacheNames = "roles", key = "'roles_'+#id")
    public Role getRoleById(String id) {
        
        return roleRepository.findOne(id);
    }

    @Override
//    @Cacheable(cacheNames = "roles", key = "'rolesbyuserid_'+#userId")
    public List<Role> getRolesByUserId(String userId) {

        User user = userRepository.findOne(userId);
        return user.getRoles();
    }

    @Transactional
    @Override
    @CacheEvict(cacheNames = "roles", allEntries = true)
    public Role createRole(Role role) {

        role.setCreatedTime(new Date());
        role.setUpdatedTime(new Date());
        role.setDeleted(false);
        return roleRepository.save(role);
    }

    @Transactional
    @Override
    @CacheEvict(cacheNames = "roles", allEntries = true)
    public Role deleteRole(Role role) {

        role.setDeleted(true);
        role.setName(role.getName() + "-Deleted-" + DateUtils.toString(new Date()));
        return updateRole(role);
    }

    @Transactional
    @Override
    @CacheEvict(cacheNames = "roles", allEntries = true)
    public Role updateRole(Role role) {

        role.setUpdatedTime(new Date());
        return roleRepository.save(role);
    }
}
