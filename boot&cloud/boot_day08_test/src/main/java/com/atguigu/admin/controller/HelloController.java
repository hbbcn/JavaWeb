package com.atguigu.admin.controller;

import com.atguigu.admin.service.HelloService;
import com.atguigu.hello.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName HelloController
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/13 15:01
 *@Version 1.0
 */
@RestController
public class HelloController{

    @Autowired
    HelloService helloService;


    @GetMapping("/hello")
    public String sayHello(){

        String s = helloService.sayHello("张三");

        return s;
    }
}

