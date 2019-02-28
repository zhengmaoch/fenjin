package com.fenjin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class FenjinCloudConfig7020Application {

    public static void main(String[] args) {
        SpringApplication.run(FenjinCloudConfig7020Application.class, args);
    }

}