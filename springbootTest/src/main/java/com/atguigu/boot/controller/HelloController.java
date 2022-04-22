package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName HelloController
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/9 14:15
 *@Version 1.0
 */

/**
 * profile功能
 * 为了方便环境适配，springboot简化了profile功能
 * application-profile功能
 * 默认配置文件 application.yaml 任何时候都会加载
 * 指定配置文件 application-env.yaml
 * 激活指定配置文件
 *  配置文件激活
 *  命令行激活 java-jar xxx.jar --spring.profiles.active=prod
 *
 *  同名配置profile优先
 *
 */

@RestController
public class HelloController{

    @Value("${person.name:helloWorld}")
    private String name;

    @Autowired
    private Person person;

    @Value("${os.name}")
    private String osName;

    @GetMapping("/")
    public String  hello(){
        return "hello" + name;
    }

    @GetMapping("/person")
    public Person  hello1(){

        return person;
    }

    @GetMapping("/msg")
    public String getMsg(){
        return osName;
    }
}

