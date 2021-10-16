package com.atguigu.filter;

import javax.servlet.*;
import java.io.IOException;
import java.security.interfaces.RSAKey;

/**
 *@ClassName Filter1
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/4 18:52
 *@Version 1.0
 */

/**
 * 一、Chain.doFilter()方法的作用
 *   1、执行下一个Filter过滤器(如果有Filter)
 *   2、执行目标资源（没有Filter)
 *
 * 二、在多个Filter过滤器执行的时候，它们指向的顺序是由它们
 *   在web.xml中从上到下配置的顺序决定的！！！
 *
 * 三、多个Filter过滤器执行的特点
 *    1、所有filter和目标资源默认都执行在同一线程中
 *    2、多个Filter共同执行的时候，它们都使用同一个Request对象
 *
 */
public class Filter1 implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter1 前置代码");
        chain.doFilter(request, response);
        System.out.println("Filter1 后置代码");
    }

    @Override
    public void destroy() {


    }
}

