package com.fenjin.fjtms.users.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;

/**
 * @version 1.0
 * @ClassName: ResourceServerConfig
 * @Descriprion: TODO(OAuth资源服务配置)
 * @author: changzhengmao
 * @date: 2019-03-05 17:20
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                .requestMatchers().antMatchers("/users/**","/roles/**","/permissions/**")
                .and()
                .authorizeRequests()
                .antMatchers("/users/**","/roles/**","/permissions/**").authenticated()
                .and()
                .httpBasic();
    }
}