package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@ClassName Response1
 *@Description
 *
 * 一、请求重定向：请求重定向，是指客户端给服务器发请求，然后我给你一新地址。你去新地址访问。
 *      叫请求重定向（因为之前的地址可能已经被废弃）
 * 二、请求重定向的特点
 *      1、浏览器地址栏会发生变化
 *      2、两次请求
 *      3、不共享Request域中的数据
 *      4、不能访问WEB-INF下的资源
 *      4、可以访问工程外的资源
 *@Author HuangQingbin
 *@Date 2021/7/21 20:36
 *@Version 1.0
 */
public class Response1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("曾到此一游 Response1");

//        req.setAttribute("key","value");

        //方式一
        //设置响应状态码302: 表示重定向。(已搬迁)
        resp.setStatus(302);

        //设置响应头，说明新的地址在哪里
        resp.setHeader("Location","http://localhost:8080/07_servlet/response2");

        //方式二 ; 不推荐使用
//        resp.sendRedirect("http://localhost:8080");
    }

}

