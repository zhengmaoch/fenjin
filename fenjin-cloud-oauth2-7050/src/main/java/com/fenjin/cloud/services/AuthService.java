package com.fenjin.cloud.services;

import com.fenjin.cloud.dao.IRoleRepository;
import com.fenjin.cloud.dao.IUserRepository;
import com.fenjin.fjtms.core.domain.users.Permission;
import com.fenjin.fjtms.core.domain.users.Role;
import com.fenjin.fjtms.core.domain.users.User;
import com.fenjin.fjtms.core.domain.users.UserRoles;
import com.fenjin.fjtms.core.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: AuthService
 * @Descriprion: TODO(用一句话描述这个类的作用)
 * @author: changzhengmao
 * @date: 2019-02-28 17:30
 * @version 1.0
 */
@Service
public class AuthService implements IAuthService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public User getUserByUsername(String username) {

        if(StringUtil.isEmpty(username)) {
            return null;
        }
        // 查询条件处理
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (!StringUtil.isEmpty(username)) {
                    predicates.add(cb.equal(root.get("username"), username));
                }
                predicates.add(cb.isTrue(root.get("active")));
                predicates.add(cb.isFalse(root.get("deleted")));
                return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
            }
        };
        return userRepository.findOne(specification);
    }

    @Override
    public List<Role> getRolesByUserId(String userId) {

        User user = userRepository.findOne(userId);
        return user.getRoles();
    }

    @Override
    public List<Permission> getPermissionsByRoleId(String roleId) {

        Role role = roleRepository.findOne(roleId);
        return role.getPermissions();
    }
}