package com.atguigu.bit_operation;

import org.junit.Test;

import java.util.Scanner;

/**
 *@ClassName Test
 *@Description  TODO
 *@Author hqb
 *@Date 2021/10/7 20:20
 *@Version 1.0
 */

/**
 * 输入一个整数m，求m的二进制序列中1的个数。
 * 例如：输入 7，二进制序列中1的个数为3，输出3。
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
        System.out.println(i++ == 4 & ++j==4);
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



