package com.atguigu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpClient;

/**
 *@ClassName ContextServlet1
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/7/20 16:12
 *@Version 1.0
 */
public class ContextServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取ServletContext对象
        ServletContext context = getServletContext();

        System.out.println("保存之前 context1 中获取域数据的值是" + context.getAttribute("key1"));

        //像Map一样存取数据
        context.setAttribute("key1","value1");
        System.out.println("context1 中获取域数据的值是" + context.getAttribute("key1"));
        System.out.println("context1 中获取域数据的值是" + context.getAttribute("key1"));

    }
}

