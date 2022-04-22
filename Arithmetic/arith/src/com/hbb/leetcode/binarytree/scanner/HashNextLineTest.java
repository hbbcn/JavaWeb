package com.hbb.leetcode.binarytree.scanner;

import java.util.Scanner;

/**
 *@ClassName HashNextLineTest
 *@Description  TODO
 *@Author hqb
 *@Date 2022/4/13 16:56
 *@Version 1.0
 */
public class HashNextLineTest{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            System.out.println(s);
        }
    }
}

