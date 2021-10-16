package com.atguigu.bit_operation;
/**
 *@ClassName Test02
 *@Description  TODO
 *@Author hqb
 *@Date 2021/10/8 20:59
 *@Version 1.0
 */

import org.junit.Test;

/**
 * 1、左移（<<）
 * 5算成换二进制： 0000 0000 0000 0000 0000 0000 0000 0101
 * 5右移3位后结果为0，0的二进制为： 0000 0000 0000 0000 0000 0000 0000 0000  / (用0进行补位)
 * -5换算成二进制： 1111 1111 1111 1111 1111 1111 1111 1011
 * -5右移3位后结果为-1，-1的二进制为：  1111 1111 1111 1111 1111 1111 1111 1111   // (用1进行补位)
 * -5无符号右移3位后的结果 536870911 换算成二进制：  0001 1111 1111 1111 1111 1111 1111 1111   // (用0进行补位)
 *
 *
 */
public class Test02 {
//1、左移（<<）
    @Test
    public void test01(){
        System.out.println(Integer.toBinaryString(-5));
        System.out.println(-5 << 2);//运行结果20
    }

    @Test
    public void test03(){
        int n = -5;
        int count = 0;

        while (n != 0){
            if((n & 1) == 1){
                count++;
            }
          n = n >>> 1;
        }
        System.out.println(count);
    }
    @Test
    public void test02(){
        int n = 5;
        int count = 0;
        while (n != 0) {
            /*
             * 用1和n进行位与运算，
             * 结果要是为1则n的2进制形式
             * 最右边那位肯定是1，否则为0
             */
            if ((n & 1) == 1) {
                count++;
            }
            //把n的2进制形式往右推一位
            n = n >> 1;
        }
        System.out.println(count);
    }
}

