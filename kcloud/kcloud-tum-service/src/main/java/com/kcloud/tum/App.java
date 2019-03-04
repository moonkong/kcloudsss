package com.kcloud.tum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan; 
 

@EnableDiscoveryClient//Eureka微服务注解
@EnableFeignClients
@SpringBootApplication   
@ComponentScan(basePackages = {"com.kcloud.common", "com.kcloud.tum"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
} 
