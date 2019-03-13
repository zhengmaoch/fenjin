package com.fenjin.fjtms.users.services;

import com.fenjin.fjtms.core.domain.users.User;
import com.fenjin.fjtms.core.domain.users.UserRoles;
import com.fenjin.fjtms.core.models.users.UserSearchModel;
import com.fenjin.fjtms.core.utils.StringUtil;
import com.fenjin.fjtms.users.dao.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @ClassName: UserService
 * @Descriprion: TODO(用一句话描述这个类的作用)
 * @author: changzhengmao
 * @date: 2019-02-28 17:30
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> getAllUsers(Date createdFrom, Date createdTo, String username, String fullName,
                                  List<String> roleIds, String phone, String email, boolean active,
                                  List<String> sorts, int pageIndex, int pageSize) {

        // 查询条件处理
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (createdFrom != null) {
                    predicates.add(cb.greaterThanOrEqualTo(root.get("createdTime"), createdFrom));
                }
                if (createdTo != null) {
                    predicates.add(cb.lessThanOrEqualTo(root.get("createdTime"), createdTo));
                }
                if (!StringUtil.isEmpty(username)) {
                    predicates.add(cb.equal(root.get("username"), username));
                }
                if (!StringUtil.isEmpty(fullName)) {
                    predicates.add(cb.like(root.get("fullName").as(String.class), "%" + fullName + "%"));
                }

                // 过滤角色id
                Join<User, UserRoles> join = root.join("roles", JoinType.LEFT);
                predicates.add(join.get("roleId").in(roleIds));

                if (!StringUtil.isEmpty(phone)) {
                    predicates.add(cb.like(root.get("phone").as(String.class), "%" + phone + "%"));
                }
                if (!StringUtil.isEmpty(email)) {
                    predicates.add(cb.like(root.get("email").as(String.class), "%" + email + "%"));
                }
                predicates.add(cb.equal(root.get("active"), active));
                predicates.add(cb.isFalse(root.get("deleted")));

                return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
            }
        };

        // 分页处理
        Pageable pageable = new PageRequest(pageIndex, pageSize);;

        // 处理排序
        if(sorts != null){
            List<Sort.Order> orders = new ArrayList<>();
            for(String s: sorts){
                if(s.substring(0,1) == "-"){
                    orders.add(new Sort.Order(Sort.Direction.DESC,s.substring(1)));
                }
                else {
                    orders.add(new Sort.Order(Sort.Direction.ASC,s));
                }
            }
            pageable = new PageRequest(pageIndex, pageSize, new Sort(orders));
        }
        return userRepository.findAll(specification, pageable).getContent();
    }

    @Override
    @Cacheable(cacheNames = "users", key = "'users_'+#id")
    public User getUserById(String id) {

        return userRepository.findOne(id);
    }

    @Override
    @Cacheable(cacheNames = "users", key = "'usersbyusername_'+#username")
    public User getUserByUsername(String username) {
        if (StringUtil.isEmpty(username)) {
            return null;
        }
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("username"), username);
            }
        };

        return userRepository.findOne(specification);
    }

    @Override
    @Cacheable(cacheNames = "users", key = "'usersbyemail_'+#email")
    public User getUserByEmail(String email) {
        if (StringUtil.isEmpty(email)) {
            return null;
        }
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("email"), email);
            }
        };

        return userRepository.findOne(specification);
    }

    /**
     * insertUser,updateUser,delete方法需要绑定事务
     * 使用@Transactional进行事务绑定
     */
    @Transactional
    @Override
    @CacheEvict(cacheNames = "users", allEntries = true)
    public User createUser(User user) {

        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        user.setDeleted(false);
        return userRepository.save(user);
    }

    @Transactional
    @Override
    @CacheEvict(cacheNames = "users", key = "'users_'+#id", beforeInvocation = true)
    public User deleteUser(User user) {

        user.setDeleted(true);
        user.setUsername(user.getUsername() + "-Deleted-" + new Date());
        return updateUser(user);
    }

    @Transactional
    @Override
    @CacheEvict(cacheNames = "users", key = "'users_'+#id")
    public User updateUser(User user) {

        user.setUpdatedTime(new Date());
        return userRepository.save(user);
    }

}