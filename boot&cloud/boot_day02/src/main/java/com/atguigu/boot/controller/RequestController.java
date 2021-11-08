package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 *@ClassName RequestController
 *@Description  TODO
 *@Author hqb
 *@Date 2021/10/31 11:43
 *@Version 1.0
 */

@Controller
public class RequestController{


    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){

        request.setAttribute("msg", "成功了");
        request.setAttribute("code",200);

        return "forward:/success"; //转发到 /success请求
    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute(value = "msg",required = false) String msg,
                       @RequestAttribute(value = "code",required = false) Integer code,
                       HttpServletRequest request){

        Object msg1 = request.getAttribute("msg");

        Object hello = request.getAttribute("hello");
        Object world = request.getAttribute("world");
        Object message = request.getAttribute("message");


        HashMap map = new HashMap();
        map.put("reqMethod",msg1);
        map.put("annotation",msg);

        map.put("hello", hello);
        map.put("world",world);
        map.put("message",message);
        return map;
    }


    @GetMapping("/params")
    public String testParam(Map<String,Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response){


        map.put("hello","world666");
        model.addAttribute("world","helloWorld");
        request.setAttribute("message","helloMessage");

        Cookie cookie = new Cookie("c1", "v1");
        cookie.setDomain("localhost");
        response.addCookie(cookie);

        return "forward:/success";
    }

}

