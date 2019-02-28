package com.fenjin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FenjinCloudEureka7003Application {

    public static void main(String[] args) {
        SpringApplication.run(FenjinCloudEureka7003Application.class, args);
    }

}

