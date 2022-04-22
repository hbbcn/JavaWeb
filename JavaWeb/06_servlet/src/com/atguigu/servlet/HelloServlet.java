package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName HelloServlet
 * @Description Servlet的生命周期
 * 1、执行Servlet构造方法
 * 2、执行inint初始化方法
 * 第一、第二步，是在第一次访问的时候创建Servlet程序会调用
 * 3、执行service方法
 * 第三步、每次访问都会调用
 * 4、执行destory销毁方法
 * 第四步、在web工程停止的时候调用
 * @Author HuangQingbin
 * @Date 2021/7/19 9:21
 * @Version 1.0
 */
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("1.构造器方法");
    }

    /**
     * ServletConfig类的三大作用
     *      1.可以获取Servlet程序的别名servlet-name的值
     *      2.获取初始化参数 init-param
     *      3.获取ServletContext对象
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2.init初始化方法");

        // 1、可以获取Servlet程序的别名Servlet-name的值
        System.out.println("HelloServlet程序的别名是：" + servletConfig.getServletName());
        // 2、获取初始化参数init-param
        System.out.println("初始化参数username的值是：" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是：" + servletConfig.getInitParameter("url"));
        String url = servletConfig.getInitParameter("url");
        //3、获取ServletContext对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法是专门用来处理请求和响应的
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3.service == Hello Service 被访问了");

        // 类型转换（因为它有getMethod()方法；
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //获取请求的方式
        String method = httpServletRequest.getMethod();
//        System.out.println(method);

        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }
    }

    public void doGet() {
        System.out.println("get请求");
        System.out.println("get请求");
    }

    public void doPost(){
        System.out.println("post请求");
        System.out.println("post请求");
    }


    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4.销毁方法");
    }
}

