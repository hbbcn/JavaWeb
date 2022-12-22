package com.atguigu.dao;


import org.springframework.stereotype.Component;

/**
 *@ClassName UserDaoImpl
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/12 20:50
 *@Version 1.0
 */

@Component(value = "userDaoImpl1")
public class UserDaoImpl implements UserDao {


    @Override
    public void add() {
        System.out.println("UserDaoImpl add");
    }
}

