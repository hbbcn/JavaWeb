package com.atguigu.bean;
/**
 *@ClassName UserBean
 *@Description  TODO
 *@Author hqb
 *@Date 2021/9/26 10:51
 *@Version 1.0
 */
public class UserBean{

     String name;
     int age;
     UserDao userDao;


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void test(){
        userDao.test01();
    }

    public void getUser(){
        System.out.println("name:" + name + ",age:" + age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

