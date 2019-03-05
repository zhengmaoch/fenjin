package com.fenjin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients(basePackages= {"com.fenjin.fjtms.core.services"})
@ComponentScan("com.fenjin")
@EnableHystrix
public class FenjinCloudOauth27050Application {

    public static void main(String[] args) {
        SpringApplication.run(FenjinCloudOauth27050Application.class, args);
    }

}
