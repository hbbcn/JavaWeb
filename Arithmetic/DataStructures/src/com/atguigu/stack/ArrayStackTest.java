package com.atguigu.stack;

import java.awt.*;
import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

/**
 *@ClassName ArrayStackTest
 *@Description  TODO
 *@Author hqb
 *@Date 2022/4/1 19:42
 *@Version 1.0
 */
public class ArrayStackTest{

    public static void main(String[] args) {
        ArrayStack01 arrayStack01 = new ArrayStack01(4);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("show:表示显示栈");
            System.out.println("exit:表示离开栈");
            System.out.println("push:表示向栈中添加数据");
            System.out.println("pop:表示向栈中取出数据");
            String str = scanner.next();
            switch (str){
                case "show":
                    arrayStack01.list();
                    break;
                case "exit":
                    loop = false;
                    scanner.close();
                    break;
                case "push":
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    arrayStack01.push(value);
                    break;
                case "pop":
                    arrayStack01.pop();
                    break;
                    default:
                        break;
            }
        }

    }

}

class ArrayStack01{
    int maxSize; //栈的大小
    private int[] stack; //数组模拟栈
    private int top = -1; //表示栈为空

    public ArrayStack01(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull(){
       return top == maxSize - 1;
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int i){
       if(isFull()) {
           System.out.println("栈满");
       }else {
           top ++;
           stack[top] = i;
       }
    }

    //出栈
    public void pop(){
        if (isEmpty()){
            System.out.println("栈为空");
        }else {
            System.out.println(stack[top]);
            top--;
        }
    }

    //遍历栈
    public void list(){
        if (isEmpty()){
            System.out.println("栈为空");
        }
        for (int i = top;i > -1;i--){
            System.out.println("出栈的数据是：" + stack[i]);
        }
    }
}

