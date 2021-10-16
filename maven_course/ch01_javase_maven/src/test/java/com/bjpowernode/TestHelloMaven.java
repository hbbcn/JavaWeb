package com.bjpowernode;

import org.junit.Assert;
import org.junit.Test;

/**
 *@ClassName TestHelloMaven
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/21 19:37
 *@Version 1.0
 */
public class TestHelloMaven{

    @Test
    public void testAdd(){

        System.out.println("测试testAdd....");
        HelloMaven hello = new HelloMaven();
        int res = hello.add(10, 20);
        //判断结果是否正确
        Assert.assertEquals(30,res);
    }
}

