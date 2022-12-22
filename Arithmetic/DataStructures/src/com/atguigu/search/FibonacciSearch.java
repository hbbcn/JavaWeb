package com.atguigu.search;

import java.net.Socket;
import java.util.Arrays;

/**
 *@ClassName FibonacciSearch
 *@Description  TODO
 *@Author hqb
 *@Date 2022/4/27 23:19
 *@Version 1.0
 */
//斐波那契数列
public class FibonacciSearch{

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fib()));
        int i = fib_rec(4);
        System.out.println(i);

    }
    //f(n) = f(n-1) + f(n-2) 编写一个斐波那契数列
    public static int fib_rec(int n){
        if (n <= 1){
            return n;
        }else {
            return fib_rec(n - 1) + fib_rec(n - 2);
        }
    }

    //非递归方法得到一个斐波那契数列
    public static int[] fib(){
        int[] f = new int[20];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i-1] + f[i - 2];
        }
        return f;
    }
}

