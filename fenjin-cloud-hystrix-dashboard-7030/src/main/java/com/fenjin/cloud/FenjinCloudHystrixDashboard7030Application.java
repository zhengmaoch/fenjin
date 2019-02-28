package com.fenjin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class FenjinCloudHystrixDashboard7030Application {

    public static void main(String[] args) {
        SpringApplication.run(FenjinCloudHystrixDashboard7030Application.class, args);
    }

}

