package com.atguigu.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@ClassName Servlet1
 *@Description  TODO
 *
 * 一、请求转发是指，服务器收到请求以后，从一次资源跳转到另一个服务器资源的操作叫请求转发
 *
 * 二、请求转发的特点：
 *      1、浏览器地址栏没有变化
 *      2、他们是一次请求
 *      3、他们共享Request域中的数据
 *      4、可以转发到WEB-INF目录下
 *      5、不可以访问工程以外的资源
 *@Author HuangQingbin
 *@Date 2021/7/21 15:41
 *@Version 1.0
 */
public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数(办事的材料)查看
        String username = req.getParameter("username");
        System.out.println("在Servlet(柜台1)中查看（参数）" + username);

        //给材料，盖一个章，并传递到Servlet2(柜台2)去查看
        req.setAttribute("key","柜台1的章");

        //问路：Servlet2(柜台2)去查看
        /*
            请求转发必须要以斜杠打头：/  斜杠表示地址为：http://ip:port/工程名/，映射到IDEA代码的web目录

         */
//      RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/form.html");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");

//走向Servlet2(柜台2)
        requestDispatcher.forward(req,resp);

                }
                }
