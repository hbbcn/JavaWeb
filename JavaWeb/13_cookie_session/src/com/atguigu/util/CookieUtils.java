package com.atguigu.util;

import com.sun.source.tree.IfTree;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@ClassName CookieUtils
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/1 11:32
 *@Version 1.0
 */
public class CookieUtils{



    public static Cookie findCookie(String name,Cookie[] cookies){
    if(name == null || cookies == null || cookies.length == 0 ){
        return null;
    }

        for (Cookie cookie : cookies){
            if (name.equals(cookie.getName())){
                 return  cookie;
            }
        }

        return null;

    }
}

