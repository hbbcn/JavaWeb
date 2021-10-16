package com.atguigu.linkedlist;

/**
 * @ClassName SingleLinkedList
 * @Description TODO
 * @Author hqb
 * @Date 2021/10/13 12:10
 * @Version 1.0
 */

/**
 * 1) 链表是以节点的方式来存储，链式存储
 * 2) 每个节点包含data域，next域：指向下一个节点
 * 3) 链表的各个节点不一定是连续存储的
 * 4) 链表分带头节点和没有带头节点的链表，根据实际的需求来确定
 *
 * 总结：可以使用flag来标志添加的链表是否存在，不存在为false,存在为true;
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {

        //进行测试
        //先创建几个节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList list = new SingleLinkedList();
//        list.add(hero1);
//        list.add(hero2);
//        list.add(hero3);
//        list.add(hero4);

        list.addByOrder(hero1);
        list.addByOrder(hero4);
        list.addByOrder(hero2);
        list.addByOrder(hero3);
        list.list();

        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟--");

        System.out.println("修改之后的链表");
        list.update(newHeroNode);
        list.list();

        System.out.println("删除之后的链表");
//        list.delete(5);
        list.del(2);
        list.list();
        int length = getLength(list.getHead());
        System.out.println(length);

        HeroNode lastIndexNode = findLastIndexNode(list.getHead(), 4);
        System.out.println(lastIndexNode);

        System.out.println("反转之后的链表");
        reverseList(list.getHead());
        list.list();
    }

    //方法：获取到单链表的节点的个数(如果是带头节点的链表，需要不统计头节点)

    //方法：查找单链表中的倒数第k个节点【新浪面试题】
    //思路
    //1.编写一个方法，接收head节点 同时接收一个index
    //2.index 表示是到数第index个节点
    //3.先把链表从头到尾遍历，得到链表的长度 getLength()
    //4.得到size后，我们从链表的第一个开始遍历（size - index）个
    public static HeroNode findLastIndexNode(HeroNode head, int index) {

        if (head.next == null) {
            return null;
        }
        int length = getLength(head);

        if (index <= 0 || index > length) {
            System.out.println("输入不合法");
            return null;
        }
        HeroNode cul = head.next;
        for (int i = 0; i < length - index; i++) {
            cul = cul.next;
        }

        return cul;
    }

    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode temp = head.next;

        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    //将单链表反转
    public static void reverseList(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，无需反转
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode reserveHead = new HeroNode(0, "", "");
        HeroNode cur = head.next;
        HeroNode temp;
        //动脑筋
        while (cur != null) {
            temp = cur.next; //得到当前节点的下一个节点
            cur.next = reserveHead.next;
            reserveHead.next = cur; //使新的头节点next指向链表的最后节点
            cur = temp;
    }

        head.next = reserveHead.next;
        //测试
//        System.out.println("######");
//        System.out.println(reserveHead.next);
//        System.out.println(reserveHead.next.next);
//        System.out.println("######");
    }

}

//定义SingleLinkedList 管理我们的英雄
class SingleLinkedList {
    //先初始化一个头节点，头节点不要动
    private HeroNode head = new HeroNode(0, "", "");
    //添加节点到单向链表
    //思路：当不考虑编号顺序时

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
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
    }

    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //（如果有这个排名，则添加失败，并给出提示）
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，需要一个辅助变量
        //因为单链表，所以我们要找temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false; //flag标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) { //说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) { //位置找到了
                break;
            } else if (temp.next.no == heroNode.no) {//说明要添加的heroNode的编号已经存在
                flag = true;//说明编号存在
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("准备添加的编号" + heroNode.no + "已经存在不能添加！");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点信息，根据no编号来修改，即no编号不能改
    public void update(HeroNode newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                temp.name = newHeroNode.name;
                temp.nickName = newHeroNode.nickName;
                break;
            }
            temp = temp.next;
        }
    }

    //删除节点信息 方式一
//    public void delete(int no){
//        HeroNode temp = head;
//        while (true){
//            if (temp.next == null){
//                System.out.println("链表为空或没有找到要删除的节点");
//                break;
//            }
//            if (temp.next.no == no){
//                temp.next = temp.next.next;
//                break;
//            }
//            temp = temp.next;
//        }
//
//    }

    //删除节点信息 方式二
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next; //temp后移，遍历
        }
        //判断flag
        if (flag) { //找到
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的%d 节点不存在\n", no);
        }
    }

    //显示链表【遍历】
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            System.out.println(temp.next);
            temp = temp.next;
        }

    }

}


//定义 HeroNode，每个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next; //指向下一个节点

    public HeroNode(int no, String name, String nickName) {
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
