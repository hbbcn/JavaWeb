package com.atguigu.factorybean;

import com.atguigu.collectiontype.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 *@ClassName MyBean
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/11 21:07
 *@Version 1.0
 */
public class MyBean implements FactoryBean<Course> {


    //定义返回bean
    @Override
    public Course getObject() throws Exception {

        Course course = new Course();
        course.setCname("abc");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}

