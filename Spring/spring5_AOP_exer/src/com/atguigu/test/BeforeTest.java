package com.atguigu.test;

import com.atguigu.aopannotation.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *@ClassName BeforeTest
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/30 20:05
 *@Version 1.0
 */
public class BeforeTest{

    @Test
    public void testBefore(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean(User.class);
        user.add();

    }
}

