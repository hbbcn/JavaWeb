package com.atguigu.controller;

import com.atguigu.bean.AA;
import com.atguigu.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@ClassName HttpController
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/28 11:35
 *@Version 1.0
 */
@Controller
public class HttpController{

    @RequestMapping(value = "/testRequestBody")
    public String testRequestBody(@RequestBody  String requestBody){
//        int i = 10/0;
        System.out.println("requestBody:" + requestBody);

        return "success";
    }

    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){

        //当前requestEntity表示整个请求报文的信息
        System.out.println("请求头：" + requestEntity.getHeaders());
        System.out.println("请求体" + requestEntity.getBody());
        return "success";
    }

    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse resp) throws IOException {
        resp.getWriter().write("hello,response");
    }



    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody(){

        return "responseSuccess";
    }


    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser(){
    return new User(1001,"admin","123",10,"男");
    }
}

