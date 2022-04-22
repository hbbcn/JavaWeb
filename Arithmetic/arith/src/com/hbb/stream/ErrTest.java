package com.hbb.stream;

import java.util.Arrays;

/**
 *@ClassName ErrTest
 *@Description  TODO
 *@Author hqb
 *@Date 2022/4/21 0:17
 *@Version 1.0
 */
public class ErrTest{
    /**
     * System.err.println无缓存，直接输出，且输出的信息为红色。
     * System.out.println有缓存，不能在测试代码时，直接输出错误。
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(1);
        System.out.println(2);
        System.err.println(3);
        System.err.println(4);
        System.err.println(5);
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(arr));

    }
}

