package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@ClassName testController
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/26 21:21
 *@Version 1.0
 */
@Controller
public class TestController {

   /* @RequestMapping("/")
    public String index(){
        return "index";
    }*/

    @RequestMapping("/test_view")
    public String testView(){
        return "test_view";
    }

    @RequestMapping("/test_rest")
    public String test_rest(){
        return "test_rest";
    }
}

