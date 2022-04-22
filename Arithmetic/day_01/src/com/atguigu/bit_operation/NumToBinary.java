package com.atguigu.bit_operation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 *@ClassName NumToBinary
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/14 19:58
 *@Version 1.0
 */
public class NumToBinary{

    //输入一个数，将其以二进制形式输出
    public static void main(String[] args) {
        System.out.print("请输入一个正数:");
        Scanner scanner = new Scanner(System.in);
        Integer i = scanner.nextInt();
        String str = "";
        int n;
         while (i > 0){
            n = i % 2;
            str = str + n;
            i = i/2;
        }
        char[] chars = str.toCharArray();
         for (int j = chars.length-1; j >= 0; j--){
             System.out.print(chars[j]);
         }



    }
}

