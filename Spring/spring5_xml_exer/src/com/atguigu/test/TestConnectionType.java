package com.atguigu.test;

import com.atguigu.collectionType.Stu;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *@ClassName TestConnlectionTyoe
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/30 14:55
 *@Version 1.0
 */
public class TestConnectionType {

    @Test
    public void test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beancollectionType.xml");
        Stu stu = context.getBean("stu", Stu.class);
        System.out.println(stu);

    }
}

