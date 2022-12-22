package com.atguigu.proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 *@ClassName JDKProxy
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/13 12:50
 *@Version 1.0
 */
public class JDKProxy{

    public static void main(String[] args) {

        //创建实现类代理对象
        UserDaoImpl userDao = new UserDaoImpl();

        Class[] interfaces = {UserDao.class};
        UserDao dao = (UserDao)Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int result = dao.add(1, 2);
        System.out.println("11" +dao);
        System.out.println("result:" + result);

    }
}

class UserDaoProxy implements InvocationHandler{


    // 1、把创建的是谁的代理对象，把谁传递过来
    // 有参构造传递
    private Object obj;

    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    //增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //方法之前
        System.out.println("方法之前执行...." + method.getName() + ":传递的参数..."  + Arrays.toString(args));

        //被增强的方法执行
        Object res = method.invoke(obj, args);
//        System.out.println(res);

        //方法之后
        System.out.println("方法之后执行..." + obj);
        return res;
    }


}


