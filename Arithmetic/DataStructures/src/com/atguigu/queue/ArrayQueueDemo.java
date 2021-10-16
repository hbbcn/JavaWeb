package com.atguigu.queue;

import com.sun.security.auth.module.Krb5LoginModule;

import java.time.chrono.IsoEra;
import java.util.Scanner;

/**
 * @ClassName ArrayQueueDemo
 * @Description 队列是一个有序的列表，遵循先进先出原则
 * 问题优化：目前数组使用一次就不能用了，没有达到复用效果
 *           将这个数组使用算法，改进成一个环形的队列 取模
 * @Author hqb
 * @Date 2021/10/12 8:56
 * @Version 1.0
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {

        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列的数据");
            key = scanner.next().charAt(0); //接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }


        System.out.println("程序退出~~");
    }
}

//使用数组模拟队列-编写一个ArrayQueue类
class ArrayQueue {
    private int maxSize;//表示数组的最大容量
    private int front;//队列头
    private int rear; //队列尾
    private int[] arr;  //数组模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部，分析出front是指向队列头的前一个位置
        rear = -1; //指向队列尾，即就是队列最后一个数据
    }

    //判断队列是否满
    public boolean ifFull() {
        return rear == maxSize - 1;
    }

    //判断队列是为空
    public boolean isEmpty() {
        System.out.println(front == rear);
        return front == rear;
    }

    //添加数九到队列
    public void addQueue(int n) {
        //判断队列是否满
        if (ifFull()) {
            System.out.println("队列满，不能添加数据~");
            return;
        }
        rear++; //让rear后移
        arr[rear] = n;
    }

    //获取队列数据 出队列
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            //通过抛异常来处理
            throw new RuntimeException("队列为空");
        }

        front++; //front后移
        return arr[front];
    }

    //显示队列所有数据
    public void showQueue() {
        //遍历

        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示队列的头数据
    public int headQueue() {
        //判断
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }

}


