package com.atguigu.service;

import com.atguigu.dao.UserDao;

/**
 *@ClassName UserService
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/30 14:09
 *@Version 1.0
 */
public class UserService{

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void testUserDao(){
        System.out.println("userService>>>>>>>>>>>");
        userDao.update();
    }
}

