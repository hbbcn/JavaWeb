package com.atguigu.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 *@ClassName Filter2
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/4 18:54
 *@Version 1.0
 */
public class Filter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        System.out.println("Filter2 前置代码");
        chain.doFilter(request, response);
        System.out.println("Filter2 后置代码");

    }

    @Override
    public void destroy() {

    }
}

