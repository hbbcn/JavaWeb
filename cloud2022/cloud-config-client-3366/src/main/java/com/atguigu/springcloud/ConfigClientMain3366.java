package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 *@ClassName ConfigClientMain3366
 *@Description  TODO
 *@Author hqb
 *@Date 2022/2/28 10:12
 *@Version 1.0
 */

@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientMain3366{

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3366.class,args);
    }
}

