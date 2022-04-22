package com.atguigu.demo;

import java.util.Random;

/**
 *@ClassName Test
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/14 20:01
 *@Version 1.0
 */
public class RandomTest {

    public static void main(String[] args) {
        int n = 7/4;
        double random = Math.random();
        System.out.println(random);

        Random random1 = new Random();
        random1.nextInt(100);

        System.out.println(n);
    }
}

