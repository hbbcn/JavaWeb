package com.atguigu.hashtab;

import com.atguigu.tree.BinaryTreeDemo;

import java.util.Calendar;
import java.util.Scanner;

/**
 * @ClassName HashTabDemo
 * @Description TODO
 * @Author hqb
 * @Date 2022/4/17 23:30
 * @Version 1.0
 */
public class HashTabDemo {
    public static void main(String[] args) {
        //创建哈希表
        HashTab hashTab = new HashTab(7);
        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("exit:退出系统");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

//创建HashTab 管理多条链表
class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size; //表示有多少条链表

    //构造器
    public HashTab(int size) {
        //初始化empLinkedListArray
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        //?留个坑 这时不要忘记分别初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }

    }

    //添加雇员
    public void add(Emp emp) {
        //根据员工id,得到该员工应当添加到哪条链表
        int empLinkedListNO = hashFun(emp.id);
        //将emp,添加到对应的链表中
        empLinkedListArray[empLinkedListNO].add(emp);
    }

    //遍历所有的链表 遍历
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //编写一个散列函数，使用一个简单的取模法
    public int hashFun(int id) {
        return id % size;
    }
}

//表示一个雇员
class Emp {
    public int id;
    public String name;
    public Emp next; //next为空

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

//创建一个EmpLinkedList,表示链表
class EmpLinkedList {
    //头指针，执行第一个Emp，因此我们这个链表的head,是指向第一个Emp
    private Emp head; //默认为空

    //添加雇员到链表
    //说明
    //1.假定，当添加雇员时，id是自增的,即id的分配总是从小到大
    // 因此我们将该雇员直接加入到本链表的最后即可
    public void add(Emp emp) {
        //如果添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助指针，帮助定位到最后
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                break;
            }
              curEmp = curEmp.next;//后移
        }
        curEmp.next = emp;
        //退出时将emp加入链表即可

    }

    //遍历链表细信息
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + (no+1) + "链表为空");
            return;
        }
        System.out.print("第"+(no+1) +"链表的信息为:");
        Emp curEmp = head; //辅助指针
        while (true) {
            System.out.printf("id = %d name = %s", curEmp.id, curEmp.name);
            if (curEmp.next == null) { //说明curEmp已经到最后节点
                break;
            }
            curEmp = curEmp.next;
        }
    }
}
