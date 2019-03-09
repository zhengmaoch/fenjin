package com.fenjin.cloud.services;

import com.fenjin.fjtms.core.domain.users.Permission;
import com.fenjin.fjtms.core.domain.users.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @version 1.0
 * @ClassName: UserDetailsServiceImpl
 * @Descriprion: TODO(获得授权用户信息)
 * @author: changzhengmao
 * @date: 2019-03-01 17:31
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IAuthService authService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.fenjin.fjtms.core.domain.users.User user = authService.getUserByUsername(username);
//        if (userResult.getCode() != Result.SUCCESS) {
        if(user == null){
            throw new UsernameNotFoundException("用户:" + username + "不存在!");
        }

//        ObjectMapper mapper = new ObjectMapper();
//        com.fenjin.fjtms.core.domain.users.User user = mapper.convertValue(userResult.getData(), com.fenjin.fjtms.core.domain.users.User.class);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        // 获取角色
        List<Role> roles = authService.getRolesByUserId(user.getId());
//        if (roleResult.getCode() == Result.SUCCESS){
//            List<Role> roles = mapper.convertValue(roleResult.getData(), new TypeReference<List<Role>>() { });
            for (Role role:roles){
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getSystemName());
                grantedAuthorities.add(grantedAuthority);
                //获取权限
                List<Permission> permissions  = authService.getPermissionsByRoleId(role.getId());
//                if (permissionResult.getCode() == Result.SUCCESS){
//                    List<Permission> permissions = mapper.convertValue(permissionResult.getData(), new TypeReference<List<Permission>>() { });
                    for (Permission permission:permissions) {
                        GrantedAuthority authority = new SimpleGrantedAuthority(permission.getSystemName());
                        grantedAuthorities.add(authority);
                    }
//                }
            }
//        }

        boolean enabled = true; // 可用性 :true:可用 false:不可用
        boolean accountNonExpired = true; // 过期性 :true:没过期 false:过期
        boolean credentialsNonExpired = true; // 有效性 :true:凭证有效 false:凭证无效
        boolean accountNonLocked = true; // 锁定性 :true:未锁定 false:已锁定

        return new User(user.getUsername(), user.getPassword(), enabled,
                accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
    }
}
