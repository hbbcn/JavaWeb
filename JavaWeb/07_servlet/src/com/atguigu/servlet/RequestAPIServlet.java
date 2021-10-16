package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@ClassName RequestAPIServlet
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/7/20 18:28
 *@Version 1.0
 */
public class RequestAPIServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /*

       HttpServletRequest类常用的方法
        1.getRequestURI()       获取请求的资源路径
        2.getRequestURL()       获取请求的统一资源定位符（绝对路径）
        3.getRemoteHost()       获取客户端的ip地址
        4.getHeader()           获取请求头
        5.getMethod             获取请求的方式GET或POST
        */



        //获取请求资源路径
        System.out.println("URI-->" + req.getRequestURI());
        //获取请求的统一资源定位符(绝对路径)
        System.out.println("URL-->" + req.getRequestURL());
        //获取客户端IP地址
        /*
            在IDEA中，使用localhost访问时，得到的客户端ip地址是 ----> 127.0.0.1
            在IDEA中，使用127.0.0.1访问时，得到的客户端ip地址是 ----> 127.0.0.1
            在IDEA中，使用真实ip访问时，得到的客户端ip地址是 ----> 真实ip地址

         */
        System.out.println("客户端ip地址 -->" + req.getRemoteHost());

        //获取请求头
        System.out.println("请求头User-Agent --->" + req.getHeader("User-Agent"));

        //请求的方式
        System.out.println("请求的方式 --->" + req.getMethod());
    }
}

