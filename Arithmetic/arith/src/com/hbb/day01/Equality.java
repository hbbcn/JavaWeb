package com.hbb.day01;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 *@ClassName Equality
 *@Description  TODO
 *@Author hqb
 *@Date 2022/4/11 20:42
 *@Version 1.0
 */

//求x+2y+3z=100的非负数整数解组合有多少种
public class Equality {
    @Test
    public void method01(){
        //暴力破解法  程序运行时间：330ms 循环次数为167501334
        int x = 1000;
        int y = 500;
        int z = 333;
        int count = 0;
        int num = 0;
        long startTime = System.currentTimeMillis(); //获取开始时间
        System.out.println("程序开始运行时间" + startTime);
        for (x = 1000; x >= 0; x--){
            for (y=500; y >= 0; y--){
                for (z=333; z>= 0; z--){
                    num++;
                    if (x+2*y+3*z == 1000){
                        count++;
                    }
                }
            }
        }
        long endTimes = System.currentTimeMillis();//获取结束时间
        System.out.println("程序运行时间：" + (endTimes - startTime) + "ms");
        System.out.println("非负数整数解组合有" + count + "种");
        System.out.println("循环次数为" + num);
    }

    @Test
    public void method02(){
        //解法2 程序运行时间：181ms  循环次数为167501334
        int x = 1000;
        int y = 500;
        int z = 333;
        int sum = 0; //x+zy
        int num = 0;
        int count = 0;
        long startTime = System.currentTimeMillis(); //获取开始时间
        for (z = 333; z>=0; z--){
            sum = 1000 - z*3;
            for (x = 1000; x >= 0; x--){
                for (y = 500; y >= 0; y--){
                    num++;
                    if (sum == x+2*y){
                        count++;
                    }
                }
            }
        }
        long endTimes = System.currentTimeMillis();//获取结束时间
        System.out.println("程序运行时间：" + (endTimes - startTime) + "ms");
        System.out.println("非负数整数解组合有" + count + "种");
        System.out.println("循环次数为" + num);
    }

    @Test
    public void method03(){
        //其他解法: 程序运行时间：219ms  循环次数为167501334
        int x = 1000;
        int y = 500;
        int z = 333;
        int sum = 0; //x+zy
        int sum01 = 0; //y得值
        int count = 0;
        int num = 0; //循环次数
        long startTime = System.currentTimeMillis(); //获取开始时间
        for (z = 333; z>=0; z--){
            sum = 1000 - z*3;
            for (y = 500; y >= 0; y--){
                sum01 = sum - 2 * y;
                for (x = 1000; x >= 0; x--){
                    num++;
                    if (x == sum01){
                        count++;
                    }
                }
            }

        }
        long endTimes = System.currentTimeMillis();//获取结束时间
        System.out.println("程序运行时间：" + (endTimes - startTime) + "ms");
        System.out.println("非负数整数解组合有" + count + "种");
        System.out.println("循环次数为" + num);
    }
    @Test
    public void method04(){
        //解法3
        //由公式x + z*y + 3z = 100 可得规律为
        //1，3，4，5，6，7 ，.... 49 51 之和  51 = 100 / 2 + 1：
        //前两个数相加为4，10，16 .....100 等差为6的等比数列
        long startTime = System.currentTimeMillis();
        int sum =  (100+4)*(100-4)/(2*6) + (100+4)/2;
        long endTimes = System.currentTimeMillis();//获取结束时间
        System.out.println("程序运行时间：" + (endTimes - startTime) + "ms");
        System.out.println("非负数整数解组合有" + sum + "种");

    }
}

