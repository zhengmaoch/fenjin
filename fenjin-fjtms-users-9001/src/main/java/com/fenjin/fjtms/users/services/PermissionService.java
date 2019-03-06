package com.fenjin.fjtms.users.services;

import com.fenjin.fjtms.core.domain.users.Permission;
import com.fenjin.fjtms.core.domain.users.Role;
import com.fenjin.fjtms.core.utils.StringUtil;
import com.fenjin.fjtms.users.dao.IPermissionRepository;
import com.fenjin.fjtms.users.dao.IRoleRepository;
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
 * @ClassName: PermissionService
 * @Descriprion: TODO(用一句话描述这个类的作用)
 * @author: changzhengmao
 * @date: 2019-03-05 19:34
 */
@Service
public class PermissionService implements IPermissionService{

    @Autowired
    private IPermissionRepository permissionRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    @Cacheable(cacheNames = "permissions", key = "'permissions_'+#permissionname")
    public List<Permission> getAllPermissions(String permissionname) {

        if(StringUtil.isEmpty(permissionname)) {
            return null;
        }
        Specification<Permission> specification = new Specification<Permission>() {
            @Override
            public Predicate toPredicate(Root<Permission> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(root.get("name").as(String.class), "%" + permissionname + "%");
            }
        };

        return permissionRepository.findAll(specification);
    }

    @Override
    @Cacheable(cacheNames = "permissions", key = "'permissions_'+#id")
    public Permission getPermissionById(String id) {

        return permissionRepository.findOne(id);
    }

    @Override
    @Cacheable(cacheNames = "permissions", key = "'permissions_'+#roleId")
    public List<Permission> getPermissionsByRoleId(String roleId) {

        Role role = roleRepository.getOne(roleId);
        return role.getPermissions();
    }

    @Transactional
    @Override
    public boolean createPermission(Permission permission) {

        permission.setCreatedTime(new Date());
        permission.setUpdatedTime(new Date());
        permission.setDeleted(false);
        Permission result = permissionRepository.save(permission);
        return result.getId().length() > 0;
    }

    @Transactional
    @Override
    @CacheEvict(cacheNames = "permissions", allEntries = true)
    public boolean deletePermission(Permission permission) {

        permission.setDeleted(true);
        permission.setName(permission.getName() + "-Deleted-" + new Date());
        updatePermission(permission);

        return true;
    }

    @Transactional
    @Override
    @CacheEvict(cacheNames = "permissions", allEntries = true)
    public boolean updatePermission(Permission permission) {

        permission.setUpdatedTime(new Date());
        permissionRepository.save(permission);
        return true;
    }
}
