package com.atguigu.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 *@ClassName MyBeanPost
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/12 17:47
 *@Version 1.0
 */

//演示添加后置处理器效果
public class MyBeanPost implements BeanPostProcessor {
    @Nullable
   public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在初始化之前执行的方法");
        return bean;
    }

    @Nullable
    public  Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在初始化之后执行的方法");
        return bean;
    }

}

