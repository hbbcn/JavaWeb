package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 *@ClassName ParameterServlet
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/7/20 19:46
 *@Version 1.0
 */
public class ParameterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

//      String hobby = req.getParameter("hobby");
        //多个值的时候选择getParameterValues()
        String[] hobbies = req.getParameterValues("hobby");


        System.out.println("用户名:" + username);
        System.out.println("密码:" + password);
        System.out.println("兴趣爱好:" + Arrays.asList(hobbies) );

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置请求字体的字符集为UTF-8,从而解决post请求的中文乱码问题

//        String password = req.getParameter("password");
        //设置请求字符集 需要在获取请求参数之前调用才有效
        req.setCharacterEncoding("UTF-8");

        String password = req.getParameter("password");
        String username = req.getParameter("username");
        System.out.println("------- doPost -------");

        String[] hobbies = req.getParameterValues("hobby");

        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
        System.out.println("兴趣爱好：" + Arrays.asList(hobbies));

    }
}

