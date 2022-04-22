package com.atguigu.niuke;

import org.junit.Test;

import java.util.Random;

/**
 *@ClassName Test
 *@Description  TODO
 *@Author hqb
 *@Date 2021/10/2 8:19
 *@Version 1.0
 */
public class Test01 {
   @Test
    public void test01(){
        Integer i01 = 59;
        int i02 = 59;
        Integer i03 = Integer.valueOf(59);
        Integer i04 = new Integer(59);
        final String bcv = new String("bcv");
        System.out.println(i01);
        System.out.println(i02);
        System.out.println(i03);
        System.out.println(i04);
    }

    @Test
    public void test02(){

        Test01 test01 = test03();
        System.out.println(test01);
        Test01 test011 = test03();
        System.out.println(test011);

    }

    public Test01 test03(){
        Test01 test01 = new Test01();
        return test01;
    }

    @Test
    public void test04(){
        int j = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 5){
                j = i;
                break;
            }
        }

    }
}

class AA{
    public static void main(String[] args) {
        int i = test04();
        System.out.println(i);
    }

    public static int test04(){
        int j = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 5){
                j = i;
                return j;
            }
        }

        return j;
    }
}

