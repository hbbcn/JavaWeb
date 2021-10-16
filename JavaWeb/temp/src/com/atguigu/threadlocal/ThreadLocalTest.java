package com.atguigu.threadlocal;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

/**
 *@ClassName ThreadLocalTest
 *@Description
 *
 * ThreadLocal的作用，它可以解决多线程的数据安全问题。
 * ThreadLocal它可以给当前线程关联一个数据（可以是普通变量，对象，数组，集合）
 * ThreadLocal的特点：
 *      1、ThreadLocal可以为当前线程关联一个数据。（它可以像Map一样存取数据，key为当前线程）
 *      2、每一个ThreadLocal对象，只能为当前线程关联一个数据，如果要为当前线程关联多个数据，就需要使用多个ThreadLocal对象实例
 *      3、每个ThreadLocal对象实例定义的时候 一般都是static类型
 *      4、ThreadLocal中保存数据，在线程销毁后，会由JVM虚拟机自动释放。
 *
 *
 *@Author HuangQingbin
 *@Date 2021/8/5 14:09
 *@Version 1.0
 */
public class ThreadLocalTest{

//    public final static Map<String,Object> data = new Hashtable<>();
    private static Random random = new Random();
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();
    public static ThreadLocal<Object> threadLocal2 = new ThreadLocal<>();

    public static class Task implements Runnable{

        @Override
        public void run() {
            // 在Run方法中，随机生成一个变量（线程要关联的数据），然后以线程名为key保存到map中
            int i = random.nextInt(1000);
            String name = Thread.currentThread().getName();
            System.out.println("线程[" + name + "]生成的随机数是" + i);
//            data.put(name,i);
              threadLocal.set(i);
              threadLocal2.set(i+1);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            new OrderService().createOrder();
            //在Run方法结束之前，以当前线程名获取出数据并打印，查看是否可以取出操作
//            Object o = data.get(name);
            Object o = threadLocal.get();
            System.out.println("在线程[" + name +"]快结束时取出关联的数据是：" + o);


        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();
        }
    }

}

