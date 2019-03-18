package com.fenjin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient // Spring Cloud Eureka 客户端
// 加载自定义Ribbon配置类，从而使配置生效，MySelfRule不能放在@ComponentScan所扫描的的包及子包下
//@RibbonClient(name = "FENJIN-SERVICES-USERS", configuration = MySelfRule.class)
@EnableFeignClients(basePackages= {"com.fenjin.fjtms.core.services"})
@ComponentScan("com.fenjin")
public class FenjinCloudFeignHystrix7010Application {

    public static void main(String[] args) {

        SpringApplication.run(FenjinCloudFeignHystrix7010Application.class, args);
    }

}

