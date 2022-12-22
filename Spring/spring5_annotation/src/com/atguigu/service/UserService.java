package com.atguigu.service;

import com.atguigu.dao.UserDao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.zip.Adler32;

/**
 * @ClassName UserService
 * @Description 一、什么是注解：
 * 1、注解是代码特殊标记格式
 * 2、使用注解:注解作用在类上面，方法上面，属性上面
 * 3、使用注解目的：简化xml配置
 * <p>
 * 二、Spring针对Bean管理中创建对象提供注解
 * ① @Component
 * ② @Service
 * ③ @Controller
 * ④ @Repository
 * <p>
 * 三、基于注解方式实现对象创建
 * 第一步 添加依赖 spring-aop-5.2.6RELEASE.jar
 * 第二步 开启组件扫描
 * 第三步 创建类，在类上面添加创建对象注解
 * @Author HuangQingbin
 * @Date 2021/8/12 20:17
 * @Version 1.0
 */
/*
    注意里面value属性值可以省略不写
    默认值是类名称首字母小写
 */
//@Component(value = "userService")//该注解等价于 <bean id="userService" class="...">
@Service
public class UserService {

    //定义dao类型属性
    //不需要添加set方法
    //添加注入属性注解
   /* @Autowired //根据类型进行注入
     @Qualifier(value = "userDaoImpl1") //根据名称进行注入 需要和Autowired一起使用
    private UserDao userDao;
*/

    @Value(value = "abc")
    private String name;

    @Resource//根据类型进行注入
//  @Resource(name = "userDaoImpl1")//根据名称注入
    private UserDao userDao;


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add() {
        System.out.println("service add...." + name);
        userDao.add();
    }
}

