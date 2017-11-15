package com.binea;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudServicesApplication {

    public static void main(String[] args) {
//		SpringApplication.run(SpringCloudServicesApplication.class, args);
        new SpringApplicationBuilder(SpringCloudServicesApplication.class).web(true).run(args);
    }
}
