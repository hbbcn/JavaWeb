package com.atguigu.niuke;

import java.util.HashSet;
import java.util.concurrent.ForkJoinPool;

/**
 *@ClassName SubstrRepeats
 *@Description  TODO
 *@Author hqb
 *@Date 2021/10/2 22:51
 *@Version 1.0
 */
/*
  给你一个字符串 S，找出所有长度为 K 且包含重复字符的子串，请你返回全部满足要求的子串的数目。
 */
public class SubstrRepeats{

    public static void main(String[] args) {
        int a = numKLenSubstrRepeats("abacde", 3);
        System.out.println(a);
    }

    public static int numKLenSubstrRepeats(String s,int k){
        int len = s.length();
        int ref = 0;
        HashSet<Character>  set= new HashSet<>();
        for (int i = k - 1; i < len; i++) {
            for (int j = 0; j < k; j++){
                 set.add(s.charAt(i - j));
            }
            System.out.println(set);
            if (set.size() < k){
                ref++;
            }
            set.clear();
        }
    return ref;
    }
}

