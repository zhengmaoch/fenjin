package com.fenjin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableOAuth2Sso
public class FenjinCloudZuulGateway7040Application {

    public static void main(String[] args) {
        SpringApplication.run(FenjinCloudZuulGateway7040Application.class, args);
    }

}

