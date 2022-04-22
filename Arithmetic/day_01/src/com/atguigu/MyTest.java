package com.atguigu;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@ClassName mytest
 *@Description  TODO
 *@Author hqb
 *@Date 2021/12/25 15:25
 *@Version 1.0
 */
public class MyTest {

    public static void main(String[] args) {
       Lock reentrantLock = new ReentrantLock(true);
        System.out.println('b' + 10);
        System.out.println('b');

    }

    @Test
   public void test01(){

        String a1 = null;
        String b1 = null;
        System.out.println(a1 == b1);

    }

    protected static final class aa{}


}
class qq{

}

