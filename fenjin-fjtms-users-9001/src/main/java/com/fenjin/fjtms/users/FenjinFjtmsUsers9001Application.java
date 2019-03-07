package com.fenjin.fjtms.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableJpaRepositories("com.fenjin.fjtms.users.dao")
@EntityScan("com.fenjin.fjtms.core.domain.users")
@EnableCaching
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class FenjinFjtmsUsers9001Application {

    public static void main(String[] args) {

        SpringApplication.run(FenjinFjtmsUsers9001Application.class, args);
    }
}

