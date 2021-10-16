package com.atguigu.linkedlist;
/**
 *@ClassName Josephu
 *@Description  TODO
 *@Author hqb
 *@Date 2021/10/15 16:17
 *@Version 1.0
 */
public class Josephu{

    public static void main(String[] args) {

    }
}
//创建一个环形的单向链表

class Boy{
    private int no;//编号
    private Boy next; //指向下一个节点，默认null

    public Boy(int no, Boy next) {
        this.no = no;
        this.next = next;
    }
}

