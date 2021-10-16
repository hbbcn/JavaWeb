package com.atguigu.servlet;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.font.TextHitInfo;
import java.io.IOException;

/**
 * @ClassName AjaxServelrt
 * @Description AJAX：Asynchronous JavaScript And XML 异步JavaScript和XML 是一种创建交互式网页应用的网页开发技术
 * 重点：ajax是一种浏览器通过js异步发起请求。局部更新页面的技术。
 * @Author HuangQingbin
 * @Date 2021/8/6 9:40
 * @Version 1.0
 */
public class AjaxServlet extends BaseServlet {


    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Ajax请求发过来了");

        Person person = new Person(1, "国歌");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //json格式的字符串
        Gson gson = new Gson();
        String s = gson.toJson(person);
        resp.getWriter().write(s);
    }


    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("jQueryAjax方法的调用");

        Person person = new Person(1, "国歌");

        //json格式的字符串
        Gson gson = new Gson();
        String s = gson.toJson(person);
        resp.getWriter().write(s);
    }

    protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("jQueryGet方法的调用");

        Person person = new Person(1, "国歌");

        //json格式的字符串
        Gson gson = new Gson();
        String s = gson.toJson(person);
        resp.getWriter().write(s);
    }


    protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("jQueryPost方法的调用");

        Person person = new Person(1, "国歌");

        //json格式的字符串
        Gson gson = new Gson();
        String s = gson.toJson(person);
        resp.getWriter().write(s);
    }

    protected void jQueryGetJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("jQueryGetJson方法的调用");

        Person person = new Person(1, "国歌");

        //json格式的字符串
        Gson gson = new Gson();
        String s = gson.toJson(person);
        resp.getWriter().write(s);
    }


    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("jQuerySerialize方法的调用");

        System.out.println("用户名" + req.getParameter("username"));
        System.out.println("密码" + req.getParameter("password"));

        Person person = new Person(1, "国歌");

        //json格式的字符串
        Gson gson = new Gson();
        String s = gson.toJson(person);
        resp.getWriter().write(s);
    }


}

