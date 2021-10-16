package com.atguigu.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *@ClassName MyServletContextListenImpl
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/7/25 19:21
 *@Version 1.0
 */
public class MyServletContextListenImpl implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext对象被创建");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext对象被销毁");
    }
}

