package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@ClassName TestController
 *@Description  拦截器的演示
 *@Author hqb
 *@Date 2021/8/29 11:50
 *@Version 1.0
 */
@Controller
public class TestController{

    @RequestMapping("/**/testInterceptor")
    public String testInterceptor(){

        return "success";
    }

    @RequestMapping("/testExceptionHandler")
    public String testExceptionHandler(){

        return "success";
    }

}

