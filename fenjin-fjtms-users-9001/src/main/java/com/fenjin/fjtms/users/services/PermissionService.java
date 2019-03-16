package com.fenjin.fjtms.users.services;

import com.fenjin.fjtms.core.domain.users.Permission;
import com.fenjin.fjtms.core.domain.users.Role;
import com.fenjin.fjtms.core.domain.users.User;
import com.fenjin.fjtms.core.utils.DateUtils;
import com.fenjin.fjtms.core.utils.StringUtil;
import com.fenjin.fjtms.users.dao.IPermissionRepository;
import com.fenjin.fjtms.users.dao.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
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
@CacheConfig(cacheNames="permissions")
public class PermissionService implements IPermissionService{

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IPermissionRepository permissionRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Override
//    @Cacheable(key = "'permissionsbypermissionname_'+#permissionname")
    public List<Permission> getAllPermissions(String permissionname) {

        Specification<Permission> specification = new Specification<Permission>() {
            @Override
            public Predicate toPredicate(Root<Permission> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                if(StringUtil.isEmpty(permissionname)) {
                    return null;
                }
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
//    @Cacheable(key = "'permissionsbyroleid_'+#roleId")
    public List<Permission> getPermissionsByRoleId(String roleId) {

        String key = "permissionsbyroleid_" + roleId;
        if(redisTemplate.hasKey(key)){
            return redisTemplate.opsForList().range(key, 0, -1);
        }
        Role role = roleRepository.findOne(roleId);
        redisTemplate.opsForList().rightPushAll(key, role.getPermissions());
        return role.getPermissions();
    }

    @Transactional
    @Override
    @CacheEvict(allEntries = true)
    public Permission createPermission(Permission permission) {

        permission.setCreatedTime(new Date());
        permission.setUpdatedTime(new Date());
        permission.setDeleted(false);
        return permissionRepository.save(permission);
    }

    @Transactional
    @Override
    @CacheEvict(allEntries = true)
    public Permission deletePermission(Permission permission) {

        permission.setDeleted(true);
        permission.setName(permission.getName() + "-Deleted-" + DateUtils.toString(new Date()));
        return updatePermission(permission);
    }

    @Transactional
    @Override
    @CacheEvict(allEntries = true)
    public Permission updatePermission(Permission permission) {

        permission.setUpdatedTime(new Date());
        return permissionRepository.save(permission);
    }
}
