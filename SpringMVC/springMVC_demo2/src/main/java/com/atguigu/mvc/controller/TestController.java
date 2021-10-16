package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@ClassName TestController
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/25 20:39
 *@Version 1.0
 */
@Controller
public class TestController{

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/param")
    public String param(){
        return "test_param";
    }

}

