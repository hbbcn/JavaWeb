package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

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
 *@Date 2021/7/23 14:00
 *@Version 1.0
 */
public class RegistServlet extends HttpServlet {


    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取Session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除Session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //1、获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2、检查：验证码是否正确  === 先写死，要求验证码为：abcde

        if(token.equalsIgnoreCase(code)){
            //3、检查用户名是否可用
            if (userService.existsUsername(username)){
                System.out.println("用户名[" + username +"]已存在");
                req.setAttribute("msg","用户名已存在");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);

            }else {
                //可用 调用Service保存到数据库
                userService.registUser(new User(null,username,password,email));
                //跳转到注册成功的页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }

        }else {

            //把回显信息保存到request域中
            req.setAttribute("msg","验证码错误 !!");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            System.out.println("验证码["+ code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }

    }
}

