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
    public List<User> getAllUsers(Date createdFrom, Date createdTo, String username, String fullName, String roleIds,
                                  String phone, String email, boolean active, String sorts, String page) {

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
                predicates.add(join.get("roleId").in(roleIds.split(",")));

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
        int pageIndex = 1;
        int pageSize = 20;
        Pageable pageable = new PageRequest(pageIndex, pageSize);;
        if(!StringUtil.isEmpty(page) && page.contains(",")){
            pageIndex = Integer.valueOf(page.split(",")[0]);
            pageSize = Integer.valueOf(page.split(",")[1]);
            pageable = new PageRequest(pageIndex, pageSize);
        }

        // 处理排序
        if (!StringUtil.isEmpty(sorts) && sorts.contains(",")){
            String[] ss = sorts.split(",");
            List<Sort.Order> orders = new ArrayList<>();
            for(String s: ss){
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
    public List<User> getAllUsers(UserSearchModel userSearchModel, int pageIndex, int pageSize) {

        Pageable pageable = new PageRequest(pageIndex, pageSize);

        if (userSearchModel != null) {
            Specification<User> specification = new Specification<User>() {
                @Override
                public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                    List<Predicate> predicates = new ArrayList<>();
                    if (userSearchModel.getSearchCreatedFrom() != null) {
                        predicates.add(cb.greaterThanOrEqualTo(root.get("createdTime"), userSearchModel.getSearchCreatedFrom()));
                    }
                    if (userSearchModel.getSearchCreatedTo() != null) {
                        predicates.add(cb.lessThanOrEqualTo(root.get("createdTime"), userSearchModel.getSearchCreatedTo()));
                    }

                    if (!StringUtil.isEmpty(userSearchModel.getSearchUsername())) {
                        predicates.add(cb.equal(root.get("username"), userSearchModel.getSearchUsername()));
                    }
                    if (!StringUtil.isEmpty(userSearchModel.getSearchFullname())) {
                        predicates.add(cb.like(root.get("fullName").as(String.class), "%" + userSearchModel.getSearchFullname() + "%"));
                    }
                    if (!StringUtil.isEmpty(userSearchModel.getSearchDepartmentId())) {
                        predicates.add(cb.equal(root.get("departmentId"), userSearchModel.getSearchDepartmentId()));
                    }
                    if (!StringUtil.isEmpty(userSearchModel.getSearchPhone())) {
                        predicates.add(cb.like(root.get("phone").as(String.class), "%" + userSearchModel.getSearchPhone() + "%"));
                    }
                    if (!StringUtil.isEmpty(userSearchModel.getSearchIpAddress())) {
                        predicates.add(cb.like(root.get("lastIpAddress").as(String.class), "%" + userSearchModel.getSearchIpAddress() + "%"));
                    }
                    if (userSearchModel.getSearchLastActivityFrom() != null) {
                        predicates.add(cb.greaterThanOrEqualTo(root.get("lastActivityDate"), userSearchModel.getSearchLastActivityFrom()));
                    }

                    predicates.add(cb.isFalse(root.get("deleted")));

                    if (predicates.size() > 0) {
                        return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
                    }
                    return null;
                }
            };

            return userRepository.findAll(specification, pageable).getContent();
        } else {
            return userRepository.findAll(pageable).getContent();
        }

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