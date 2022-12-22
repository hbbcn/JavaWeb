package com.atguigu.Exer;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Test
 * @Description TODO
 * @Author HuangQingbin
 * @Date 2021/8/11 20:23
 * @Version 1.0
 */
public class TestStudent {


    @Test
    public void testStudent() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanExer.xml");
        Student student = context.getBean("student", Student.class);
        student.test();
    }
}

