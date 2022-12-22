package com.atguigu.service;

import com.atguigu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@ClassName UserService
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/30 16:45
 *@Version 1.0
 */

@Service
public class UserService{


    @Autowired
    private UserDao userDao;

    public void testAdd(){

        userDao.add();
    }

}

