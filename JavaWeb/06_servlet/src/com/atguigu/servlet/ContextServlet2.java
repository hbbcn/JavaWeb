package com.atguigu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ContextServlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    /**
     * 什么是ServletContext?
     *     1、ServletContext是一个接口，它表示Servlet上下文对象
     *     2、一个web工程，只有一个ServletContext对象实例
     *     3、ServletContext对象是一个域对象
     *     4、ServletContext是在web工程部署启动的时候创建。在web工程停止的时候销毁。
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        System.out.println("context2 中获取域数据的值是" + context.getAttribute("key1"));
    }
}
