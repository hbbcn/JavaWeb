package com.atguigu.admin.controller;

import com.atguigu.admin.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName helloController
 *@Description  TODO
 *@Author hqb
 *@Date 2021/10/29 17:47
 *@Version 1.0
 */

@RestController
public class HelloController {

    @Autowired
    Person person;


    @RequestMapping("/person")
    public Person person(){

        return person;
    }


    /**
     *  只要静态资源放在类路径下：called/static(or /public or /resources or /META-INF/resources)
     *  访问：当前项目根路径/ +静态资源名
     *
     *  原理：静态映射/**
     *  请求进来，先去找controller看能不能处理。不能处理的所有请求有都交给静态资源处理器。静态资源找不到404
     * @return
     */
    @RequestMapping("/5.jpg")
    public String hello(){
        return "aaaa";
    }
}

