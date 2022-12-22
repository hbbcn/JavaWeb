package com.atguigu.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 *@ClassName UserDaoImpl
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/30 16:44
 *@Version 1.0
 */

@Repository
public class UserDaoImpl implements UserDao{

    @Value("abc")
    private String username;

    @Value("1")
    private int b;

    @Override
    public void add() {
        System.out.println(">>>>>>>>>>>>>>>>>");
        System.out.println("username = " + username  + "::" + "b = " + b);
    }
}

