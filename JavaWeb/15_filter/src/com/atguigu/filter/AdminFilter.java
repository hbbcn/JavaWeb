package com.atguigu.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *@ClassName AdminFilter
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/4 17:26
 *@Version 1.0
 */
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

/*
*
     * doFilter方法，专门用于拦截请求。可以做权限检查
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
*/

    /**
     * 一、Chain.doFilter()方法的作用
     *   1、执行下一个Filter过滤器(如果有Filter)
     *   2、执行目标资源（没有Filter)
     *
     * 二、在多个Filter过滤器执行的时候，它们指向的顺序是由它们
     *    在web.xml中从上到下配置的顺序决定的！！！
     *
     * 三、多个Filter过滤器执行的特点
     *    1、所有filter和目标资源默认都执行在同一线程中
     *    2、多个Filter共同执行的时候，它们都使用同一个Request对象
     *
     * 四、Filter的拦截路径
     *      精确匹配：   <url-pattern>/target.jsp</url-pattern>
     *      目录匹配：   <url-pattern>/admin/*</url-pattern>
     *      后缀名匹配： <url-pattern>*.html</url-pattern>
     *  Filter 过滤器它只关心请求地址是否匹配，不关心请求的资源是否存在
     */

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        //如果等于null,说明没有登录
        if(user == null){
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }else{
            chain.doFilter(request,response);
        }

    }

    @Override
    public void destroy() {

    }
}

