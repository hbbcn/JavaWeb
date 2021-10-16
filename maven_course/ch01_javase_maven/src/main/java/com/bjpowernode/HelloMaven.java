package com.bjpowernode;

import javax.xml.transform.Source;

/**
 *@ClassName HelloMaven
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/21 19:35
 *@Version 1.0
 */
public class HelloMaven{

    public int add(int n1, int n2){
        return  n1 + n2;
    }

    public static void main(String[] args) {
        HelloMaven hello = new HelloMaven();
        int ref = hello.add(10, 20);
        System.out.println("10 + 20 = " + ref);
    }
}

