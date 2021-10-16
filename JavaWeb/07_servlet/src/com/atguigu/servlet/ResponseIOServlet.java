package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

/**
 *@ClassName ResponseIOServlet
 *@Description  TODO
 * 字符流：getWriter()
 * 字节流：getOutputStream
 * 两个流不能同时使用
 *@Author HuangQingbin
 *@Date 2021/7/21 19:59
 *@Version 1.0
 */
public class ResponseIOServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        System.out.println(resp.getCharacterEncoding());// 服务器默认ISO-8859-1

        //设置服务器字符集为UTF-8
        resp.setCharacterEncoding("UTF-8");


        // 通过响应头，设置浏览器也使用UTF-8字符集
        resp.setHeader("Content-Type","text/html; Charset=UTF-8");

        //它会同时设置服务器和客户端使用UTF-8字符集，还设置了响应头
        //此方法一定要在获取流对象之前调用才有效
        resp.setContentType("text/html; charSet=UTF-8");
        //要求： 往客户端回传字符串数据。
        PrintWriter writer = resp.getWriter();
        writer.write("我爱中国共产党");
    }
}

