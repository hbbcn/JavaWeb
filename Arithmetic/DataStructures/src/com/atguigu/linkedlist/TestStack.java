package com.atguigu.linkedlist;

import java.util.Stack;

/**
 *@ClassName TestStack
 *@Description  TODO
 *@Author hqb
 *@Date 2021/10/15 15:20
 *@Version 1.0
 */
public class TestStack{

    public static void main(String[] args) {

        //入栈
        Stack<String> stack = new Stack<String>();
        stack.add("jack");
        stack.add("tome");
        stack.add("smith");

        //出栈
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }

    }
}

