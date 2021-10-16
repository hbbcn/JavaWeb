package com.atguigu.mvc.controller;

import com.atguigu.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 *@ClassName ParamController
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/26 15:59
 *@Version 1.0
 */
@Controller
public class ParamController{

    @RequestMapping("/testServletAPI")

    //形参位置request表示当前请求
    public String testServletAPI(HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println(session.getId());

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + ",password" + password);
        return "success";

    }

    @RequestMapping("/testParam")
    //RequestParam是将请求参数和控制器方法的形参创建映射关系
    //value:指定形参复制的请求参数的参数名
    //required;设置是否必须传输此请求参数，默认值为true
    //defaultValue属性，不管required属性值为true或false,当value所指定的请求参数没有参数传输时，则使用默认值为形参赋值
    public String testParam(@RequestParam(value = "user_name", required = false) String username,
                            String password,
                            String hobby[],
                            @RequestHeader("Host") String host,
                            @CookieValue("JSESSIONID") String s){

        //若请求参数中出现多个同名的请求参数，可以再控制器方法的形参位置设置字符串类型或者字符串类型的数组

        System.out.println("username:" + username + ",password：" + password + ",hobby:" + Arrays.toString(hobby));
        System.out.println("Host:" + host);
        System.out.println("JSESSIONID:" + s);
        return "success";
    }

    @RequestMapping("/testPOJO")
    public String testBean(User user){

        System.out.println(user);
        return "success";
    }
}

