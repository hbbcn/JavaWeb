package com.atguigu.proxy;

import org.springframework.stereotype.Component;

/**
 *@ClassName UserDaoImpl
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/13 12:49
 *@Version 1.0
 */

//有接口的情况 使用jdk动态代理
@Component
public class UserDaoImpl implements UserDao{

    @Override
    public int add(int a, int b) {
        System.out.println("add方法执行了");
        return a + b;
    }

    @Override
    public String update(String id) {
        System.out.println("update方法执行了");
        return id;
    }
}

