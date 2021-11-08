package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 *@ClassName ViewTestController
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/1 19:14
 *@Version 1.0
 */

@Controller
public class ViewTestController{


    @GetMapping("/atguigu")
    public String atguigu(Model model){

        //model中的数据会别放在请求域中 相当于request.setAttribute("a",aa)

        model.addAttribute("msg","你好，guigu");
        model.addAttribute("link", "http://www.baidu.com");
        return "success";
    }
}

