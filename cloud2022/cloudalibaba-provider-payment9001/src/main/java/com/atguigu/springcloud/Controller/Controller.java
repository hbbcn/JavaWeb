package com.atguigu.springcloud.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName Controller
 *@Description  TODO
 *@Author hqb
 *@Date 2022/2/21 9:21
 *@Version 1.0
 */
@RestController
public class Controller{

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/nacos/{id}")

    public String getPayment(@PathVariable("id") Integer id){
        return "nacos registry, serverPort:" + serverPort+ "\t id" +id;
    }
}

