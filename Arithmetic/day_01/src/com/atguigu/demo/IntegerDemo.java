package com.atguigu.demo;


/**
 *@ClassName Integer
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/5 10:28
 *@Version 1.0
 */
public class IntegerDemo {

    public static void main(String[] args) {
        Integer n1 = 127;
        Integer n2 = 127;
        Integer n3 = 130;
        Integer n4 = 130;
        int n5 = 131;
        int n6 = 131;

        System.out.println(n3 == n4);
        Integer integer = new Integer(127);
        Integer integer1 = Integer.valueOf(127);

        System.out.println(n1 == n2);
        System.out.println(n1 == integer);
        System.out.println(n1 == integer1);

        int[] ints = new int[]{1,2,3};
        int[] array = {1,2,3};
        int n = array.length;
        String str = "adf";
        str.length();
        double d = 1.3;
        int c = 3;
        d = c;

    }


    void m1(){};

    public static void m2(){

    }

    public void m3(){}
}

class AA extends IntegerDemo{
    @Override
    public void m3() {
        super.m3();
    }

    public static void m2(){

    }

    @Override
    void m1() {
        super.m1();
    }
}


