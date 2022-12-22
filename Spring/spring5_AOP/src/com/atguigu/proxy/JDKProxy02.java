package com.atguigu.proxy;

import com.atguigu.aopannotation.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *@ClassName JDKProxy02
 *@Description  TODO
 *@Author hqb
 *@Date 2022/2/8 19:48
 *@Version 1.0
 */
public class JDKProxy02{

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        UserDao userDao = new UserDaoImpl();
        UserDaoProxy02 userDaoProxy02 = new UserDaoProxy02(userDao);

        Class[] userDaoClass = {UserDao.class};


//        UserDao dao = (UserDao)Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        UserDao userDao1= (UserDao) Proxy.newProxyInstance(JDKProxy02.class.getClassLoader(), userDaoClass, userDaoProxy02);
        System.out.println(userDao1);

        int add = userDao1.add(3, 6);
        System.out.println(add);
    }
}


class UserDaoProxy02 implements InvocationHandler{

    private Object obj;

    public  UserDaoProxy02(Object obj) {
        this.obj = obj;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        System.out.println("方法之前执行");
        Object invoke = method.invoke(obj, args);
        return invoke;
    }
}

