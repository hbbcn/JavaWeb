package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 *@ClassName UserServiceTest
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/7/23 11:15
 *@Version 1.0
 */
public class UserServiceTest{

  UserService userService =  new UserServiceImpl();
    @Test
    public void registUser(){

        userService.registUser(new User(null,"bb168","666666","bbj168@qq.com"));
        User user = new User();

    }

    @Test
    public void login(){

        System.out.println(userService.login(new User(null,"admin123","123456",null)));
    }

    @Test
    public void existsUsername(){

       if( userService.existsUsername("admin123")){
           System.out.println("用户名已存在！");
       }else {
           System.out.println("用户名可用！");
       }
    }

}

