package com.fenjin.cloud.config;

import com.fenjin.cloud.services.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;

/**
 * @ClassName: AuthorizationServerConfig
 * @Descriprion: TODO(认证服务器配置，提供授权的用户信息)
 * @author: changzhengmao
 * @date: 2019-03-01 10:47
 * @version 1.0
 */
@Slf4j
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    // 认证管理器
    private AuthenticationManager authenticationManager;

    @Autowired
    // 存储客户信息
    private DataSource dataSource;

    @Autowired
    // 用户信息相关的实现
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    // redis存储连接
    private RedisConnectionFactory redisConnectionFactory;


    @Bean
    // token 存放位置
    RedisTokenStore redisTokenStore(){

        return new RedisTokenStore(redisConnectionFactory);
    }

    @Bean
    // 用户信息存储到 MySQL
    public ClientDetailsService clientDetails() {

        return new JdbcClientDetailsService(dataSource);
    }

    /**
     * 配置认证管理器、Token存储服务及用户信息业务实现
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(redisTokenStore())
                .userDetailsService(userDetailsService)
                .authenticationManager(authenticationManager) // Default URL: /oauth/authorize
                .tokenServices(defaultTokenServices()); // Default URL: /oauth/token
        log.info("AuthorizationServerEndpointsConfigurer is complete!");
    }

    /**
     * 配置生成Token的有效期及存储方式（此处用redis）
     * <p>注意，自定义TokenServices的时候，需要设置@Primary，否则报错，</p>
     * @return
     */
    @Primary
    @Bean
    public DefaultTokenServices defaultTokenServices(){
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(redisTokenStore());
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setClientDetailsService(clientDetails());
        // token有效期自定义设置，默认12小时
        tokenServices.setAccessTokenValiditySeconds(60*60*12);
        // refresh_token默认30天
        tokenServices.setRefreshTokenValiditySeconds(60 * 60 * 24 * 7);
        return tokenServices;
    }

    /**
     * 配置认证规则
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

        security.allowFormAuthenticationForClients()
                // 开启/oauth/token_key验证端口无权限访问
                .tokenKeyAccess("permitAll()")
                // 开启/oauth/check_token验证端口认证权限访问
                .checkTokenAccess("isAuthenticated()");
        log.info("AuthorizationServerSecurityConfigurer is complete!");
    }

    /**
     * 配置客户端
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.withClientDetails(clientDetails());
//        clients.inMemory()
//                .withClient("android")
//                .scopes("read")
//                .secret("android")
//                .authorizedGrantTypes("password", "authorization_code", "refresh_token")
//                .and()
//                .withClient("webapp")
//                .scopes("read")
//                .authorizedGrantTypes("implicit")
//                .and()
//                .withClient("browser")
//                .authorizedGrantTypes("refresh_token", "password")
//                .scopes("read");
    }
}
