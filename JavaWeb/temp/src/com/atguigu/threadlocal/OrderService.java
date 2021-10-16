package com.atguigu.threadlocal;
/**
 *@ClassName OrderService
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/5 14:31
 *@Version 1.0
 */
public class OrderService{

    public  void createOrder(){
        String name = Thread.currentThread().getName();
        System.out.println("OrderService 当前线程[" +name + "]保存的数据是：" + ThreadLocalTest.threadLocal.get());
    }
}

