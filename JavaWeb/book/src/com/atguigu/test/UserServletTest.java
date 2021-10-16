package com.atguigu.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *@ClassName UserServletTest
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/7/27 20:53
 *@Version 1.0
 */
public class UserServletTest {

    public void login() {
        System.out.println("这是login()方法调用了");
    }

    public void regist() {
        System.out.println("这是regist()方法调用了");
    }

    public void updateUsername() {
        System.out.println("这是updateUsername()方法调用了");
    }

    public void updateUsernamePassword() {
        System.out.println("这是updateUsernamePassword()方法调用了");
    }

//    public static void main(String[] args) {
//        String action = "regist";
//        try {
//
//            //获取action业务鉴别字符串，获取相应的业务，方法反射对象
//            Method method = UserServletTest.class.getDeclaredMethod(action);
//            //调用目标业务 方法
//            method.invoke(new UserServletTest());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    public static void main(String[] args) {
        Person p = new Person(1, "刘德华");
        System.out.println(p.getClass());
        System.out.println(p.getClass().getName());
    }
}

    class Person{
        int id;
        String name;
        public Person(int id, String name) {
            super();
            this.id = id;
            this.name = name;
        }
    }


class BB{



}


