package com.atguigu.linkedlist;

/**
 * @ClassName DoubleLinkedListDemo
 * @Description TODO
 * @Author hqb
 * @Date 2021/10/15 15:31
 * @Version 1.0
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {

        //测试
        System.out.println("双向链表的测试");
        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        //创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);


        doubleLinkedList.list();

        //删除
        doubleLinkedList.del(1);
        doubleLinkedList.list();
    }
}

class DoubleLinkedList {

    //先初始化一个头节点，头节点不要动
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表的方法
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            System.out.println(temp.next);
            temp = temp.next;
        }

    }

    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        //添加节点到单向链表
        while (true) {
            //遍历链表，找到最后
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向新的节点
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //删除节点
    //1、对于双链表，我们可以直接找到要删除的这个节点
    //2、找到后自我删除即可
    public void del(int no) {

        //判断当前链表是否为空
        if (head.next == null) {//空链表
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next; //temp后移，遍历

        }
        //判断flag
        if (flag) { //找到
            temp.pre.next = temp.next;
            //如果是最后一个节点，就不需要指向下面这句话
            if (temp.next != null) {
                temp.pre = temp.next.pre;
            }

        } else {
            System.out.printf("要删除的%d 节点不存在\n", no);
        }
    }

}

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next; //指向下一个节点 默认为null
    public HeroNode2 pre; //指向前一个节点
    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
    //为了显示方便，我们重写toString

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}



