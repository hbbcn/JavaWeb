package com.atguigu.test;

import com.atguigu.config.TxConfig;
import com.atguigu.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @ClassName TestBook
 * @Description TODO
 * @Author HuangQingbin
 * @Date 2021/8/13 21:19
 * @Version 1.0
 */
public class TestBook {

    @Test
    public void testTransfer(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.transfer();
    }

    @Test
    public void testTransfer1(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.transfer();
    }

    //完全注解方式测试
    @Test
    public void testTransfer2(){

        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.transfer();
    }
}

