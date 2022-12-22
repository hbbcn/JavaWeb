package com.hbb.recAndite;
/**
 *@ClassName Solution02
 *@Description  TODO
 *@Author hqb
 *@Date 2022/5/2 0:23
 *@Version 1.0
 */
public class Solution02{
    public static void main(String[] args) {
        int fun = fun(5);
        System.out.println(fun);
    }

    //求n!
    public static int fun(int n){
        if (n == 1){
            return 1;
        }else{
            return n * fun(n - 1);
        }

    }
}

