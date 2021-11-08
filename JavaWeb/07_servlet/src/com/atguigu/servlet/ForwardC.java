package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@ClassName ForwordC
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/7/21 17:26
 *@Version 1.0
 */
public class ForwardC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("经过了ForwardC程序");

        // 请求转发 / 是被服务器解析 地址为当前工程下
        req.getRequestDispatcher("/form.html").forward(req,resp);



    }
}

