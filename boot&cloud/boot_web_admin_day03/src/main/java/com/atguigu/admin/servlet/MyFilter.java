package com.atguigu.admin.servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestAttribute;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;



/**
 *@ClassName MyFilter
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/4 11:35
 *@Version 1.0
 */
@Slf4j
//@WebFilter(urlPatterns = {"/css/*","/images/*"})
public class MyFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        log.info("MyFilter初始化完成");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        log.info("MyFilter工作");
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

        log.info("MyFilter销毁");
    }
}

