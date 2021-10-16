package com.atguigu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@ClassName ContextServlet
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/7/20 12:00
 *@Version 1.0
 */
public class ContextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取web.xml中配置上下文参数context-param

        ServletContext context = getServletContext();

        String username = context.getInitParameter("username");
        System.out.println("context-param参数username的值是：" + username);
        System.out.println("context-param参数password的值是：" + context.getInitParameter("password"));

//        2、获取当前的工程路径，格式：/工程路径
        System.out.println("当前工程路径" + context.getContextPath());
//        3、获取工程部署后在服务器上的绝对路径
        /*
            / 斜杠被服务器解析为：http:ip:port/工程名/    映射到IDEA代码的web目录
         */
        System.out.println("工程部署路是：" +context.getRealPath("/"));
        System.out.println("工程下css目录的绝对路径是" +context.getRealPath("/css"));
        System.out.println("工程下imgs下1.jpg的绝对路径是" +context.getRealPath("/imgs/1.jpg"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}

