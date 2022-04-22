package com.atguigu.springcloud;

import com.atguigu.springcloud.entities.Payment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *@ClassName PaymentMain8004
 *@Description  TODO
 *@Author hqb
 *@Date 2022/2/25 21:48
 *@Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8004{

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class,args);
    }
}

