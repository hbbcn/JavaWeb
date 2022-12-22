package com.atguigu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *@ClassName JDKProxy
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/30 18:53
 *@Version 1.0
 */

public class JDKProxy{

    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        Class[] interfaces = {UserDao.class};
        UserDao dao = (UserDao)Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int result = dao.add(1, 2);
        System.out.println("result: " + result);
    }

}

class UserDaoProxy implements InvocationHandler{

    private UserDao userDao;

    public UserDaoProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDaoProxy() {

    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("方法之前执行");

        Object invoke = method.invoke(userDao, args);

        System.out.println("方法之后执行");

        return invoke;
    }
}

