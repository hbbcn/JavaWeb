package com.atguigu.jedis;

import org.junit.Test;

import java.util.Scanner;

/**
 *@ClassName Test
 *@Description  TODO
 *@Author hqb
 *@Date 2021/10/7 20:20
 *@Version 1.0
 */
public class Test01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入数字：");
        int i = scanner.nextInt();
        String s = Integer.toBinaryString(i);
        int count = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '1'){
                count++;
            }
        }
        System.out.println(count);
    }
    @Test
    public void getNum(){
        int i=3, j=3;
        if(i++ == 4 & ++j==4){
            i=5;
        }
        System.out.println("i= " + i + "j = " + j);
    }
    public static void test01(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入数字：");
        int i = scanner.nextInt();
        String s = Integer.toBinaryString(i);
        System.out.println(s);
        int count = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '1'){
                count++;
            }
        }
        System.out.println(count);

    }

}
class Super{
    public float getNum(){
        return .30f;
    }
}
class Sub extends Super{

 /*   public float getNum(){
        return 4.0f;
    }*/

    public void getNum(double d){

    }

}



