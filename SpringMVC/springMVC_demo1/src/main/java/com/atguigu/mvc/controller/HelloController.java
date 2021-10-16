package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@ClassName HelloController
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/22 19:47
 *@Version 1.0
 */

@Controller
public class HelloController{

//    @RequestMapping 是一个注解，用来标识 http 请求地址与 Controller 类的方法之间的映射
    /*
    http:
    超文本传输协议，是一个基于请求与响应，无状态的，应用层的协议，常基于TCP/IP协议传输数据，
    互联网上应用最为广泛的一种网络协议,所有的WWW文件都必须遵守这个标准。设计HTTP的初衷是为了提供一种发布和接收HTML页面的方法。
     */
    @RequestMapping("/")
    public String index(){
        //返回视图名称
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget(){
        return "target";
    }

}

