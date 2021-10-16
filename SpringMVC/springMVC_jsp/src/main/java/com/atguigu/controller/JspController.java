package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@ClassName jspController
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/27 14:37
 *@Version 1.0
 */

@Controller
public class JspController {


    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}

