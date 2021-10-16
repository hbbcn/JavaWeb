package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@ClassName LoginServlet
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/1 15:07
 *@Version 1.0
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if("wzg168".equals(username) && "123456".equals(password)){
            //登录成功
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60 * 24 * 7);//当前cookie一周之内有效
            resp.addCookie(cookie);
            System.out.println("登录成功");
        }else {
            //登录失败
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            System.out.println("登录失败");
        }
    }
}

