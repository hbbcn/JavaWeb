package com.atguigu.test;

import com.atguigu.bean.UserBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *@ClassName TestDemo1
 *@Description  TODO
 *@Author hqb
 *@Date 2021/9/26 10:48
 *@Version 1.0
 */
public class TestDemo1{

    @Test
    public void testUserBean(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserBean bean = context.getBean(UserBean.class);
        bean.getUser();

    }
    @Test
    public void testUserBean01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserBean bean = context.getBean("userBean2",UserBean.class);
        bean.test();
    }

}

