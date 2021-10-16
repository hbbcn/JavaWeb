package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.test.UserServletTest;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 *@ClassName UserServlet
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/7/27 20:07
 *@Version 1.0
 */
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、销毁Session中用户信息(或者销毁Session)
        req.getSession().invalidate();
        // 2、重定向到首页
        resp.sendRedirect(req.getContextPath());
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //调用userService.login()登录处理业务
        User loginUser = userService.login(new User(null, username, password, null));
        //如果等于null,说明登录 失败
        if (loginUser == null){

            //把错误信息，和回显的表单项信息，保存到request域中
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            //跳回登录页面

            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{

            //登录成功 保存用户的信息到Session域中
            req.getSession().setAttribute("user",loginUser);
            //登录成功，跳到成功页面 login_success.jsp
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        //1、获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");


        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        //2、检查：验证码是否正确  === 先写死，要求验证码为：abcde

        if("abcde".equalsIgnoreCase(code)){


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

    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        //获取请求的参数username
        String username = req.getParameter("username");
        // 调用userService.existsUsername();
        boolean existsUsername = userService.existsUsername(username);
        // 把返回的结果封装成为map对象
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("existsUsername",existsUsername);

        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);


    }

}

