package com.atguigu.com;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 *@ClassName RegistServlet
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/2 11:50
 *@Version 1.0
 */
public class RegistServlet extends HttpServlet {

  /*
    表单重复提交三种常见的情况：
        一、提交完表单。服务器使用请求转发进行页面跳转。这个时候，用户按下功能键F5,就会发起最后一个请求。
        造成表单重复提交问题。
              解决方案：使用重定向进行跳转。

        二、用户正常提交服务器。但是由于网络延迟等原原因，迟迟未收到服务器的响应，这个时候，用户以为提交失败
        就会着急，然会多点几次提交按钮，也会造成表单重复提交
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        三、用户正常提交服务器，服务器也没有延迟，但是提交完成后，用户回退浏览器。重新提交。也会造成表单重复提交。

        二和三 使用验证码解决表单重复提交


   */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // 获取Session中的验证码
        String token = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 删除Session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        String code = req.getParameter("code");

        //获取用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(token != null && token.equalsIgnoreCase(code)){
            System.out.println("保存到数据库：" + username + "和密码" + password);
            resp.sendRedirect(req.getContextPath() + "/ok.jsp");
        }else{
            System.out.println("请不要重复提交表单");
        }






    }
}

