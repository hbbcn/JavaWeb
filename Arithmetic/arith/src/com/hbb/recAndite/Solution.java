package com.hbb.recAndite;
/**
 *@ClassName Solution
 *@Description  TODO
 *@Author hqb
 *@Date 2022/5/2 0:00
 *@Version 1.0
 */
public class Solution{
    public static void main(String[] args) {

        int f = f(5);
        System.out.println(f);
    }

    /**
     * 求1-n的和
     */
    public static int f(int n){

        if (n > 0){
            return n + f(n-1);
        }else {
            return 0;
        }
    }
}

