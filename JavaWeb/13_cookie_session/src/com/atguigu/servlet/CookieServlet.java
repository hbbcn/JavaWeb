package com.atguigu.servlet;

import com.atguigu.util.CookieUtils;
import com.sun.jdi.Value;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@ClassName CookieServlet
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/1 10:40
 *@Version 1.0
 */
public class CookieServlet extends BaseServlet{



    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        for(Cookie cookie : cookies){

            // getName方法返回Cookie的key名
            // getValue方法返回Cookie的value值
            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "]<br/>");
        }


/*     for (Cookie cookie : cookies){
         if ("key2".equals(cookie.getName())){
             iWantCookie = cookie;
             break;
         }
     }*/
        Cookie iWantCookie = CookieUtils.findCookie("key2", cookies);

        //如果不等于null,说明赋过值，也就是找到了需要的Cookie
        if(iWantCookie != null){
            resp.getWriter().write("找到了需要的Cookie");
        }

    }

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、创建Cookie对象
        Cookie cookie = new Cookie("key3", "value3");
        //2、通知客户端保存Cookie
        resp.addCookie(cookie);
        Cookie cookie1 = new Cookie("key2", "value2");
        //2、通知客户端保存Cookie
        resp.addCookie(cookie1);

        resp.getWriter().write("Cookie创建成功");
    }

    public void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws IOException {

/*
        //方案一：
//     1、先创建一给要修改的同名的Cookie对象
//        2、在构造器，同时赋予新的Cookie的值
        Cookie cookie = new Cookie("key1", "newValue1");
//        3、调用response.addCookie(cookie)
        resp.addCookie(cookie);
        resp.getWriter().write("key1的cookie已经修改好了");
*/

        //方案二：

        //1、先查找需要修改的Cookie对象
        Cookie cookie = CookieUtils.findCookie("key2", req.getCookies());

        //2、调用setValue()方法赋予新的Cookie值
        if(cookie != null){
            cookie.setValue("newValue2");
        }

        //3、调用response.addCookie()通知客户端保存修改
        resp.addCookie(cookie);
    }

    public void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        Cookie cookie = new Cookie("default", "defaultValue");
        cookie.setMaxAge(-1);//设置存活时间
        resp.addCookie(cookie);
    }


    public void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        //1、先找到你要删除的Cookie对象
        Cookie cookie = CookieUtils.findCookie("key2", req.getCookies());
        if(cookie != null){
            //2、调用setMaxAge(0)设置存活时间
            cookie.setMaxAge(0);// 表示马上删除们都不需要等待浏览器关闭
        }
        resp.addCookie(cookie);
        //3、调用response.addCookie(cookie)
    }

    public void life3600(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie cookie = new Cookie("life3600", "life3600");
        cookie.setMaxAge(60 * 60);
        resp.addCookie(cookie);
        resp.getWriter().write("已经存活一小时的Cookie");
    }

    public void testPath(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie cookie = new Cookie("path1", "path1");
        //getContextPath()得到工程路径
        System.out.println(req.getContextPath());
        cookie.setPath(req.getContextPath() + "/abc");
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有工程路径的Cookie");

    }
}

