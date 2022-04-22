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
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);//加入五个小孩节点
        circleSingleLinkedList.showBoy();

        //测试一把出圈是否正确
        circleSingleLinkedList.countBoy(1,2,5);//2,4,1,5,3
    }
}
//创建一个环形的单向链表
class CircleSingleLinkedList{
    //创建一个first节点，当前没有编号
    private Boy first = new Boy(-1);

    //添加小孩节点，构建成一个环形链表
    public void addBoy(int nums){
        //
        if (nums < 1){
            System.out.println("nums的值不正确");
        }
        //使用for循环来创建我们的环形链表

        Boy curBoy = null; //辅助指针，帮助构建环形链表
        for(int i = 1; i <= nums; i++){
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩节点
            if (i == 1){
                first = boy;
                first.setNext(first);
                curBoy = first;
            }
            curBoy.setNext(boy);
            curBoy = boy;
            boy.setNext(first);
        }
    }

    //遍历当前环形链表
    public void showBoy(){
        Boy cur = first;
        while (true){

            if (first == null){
                break;
            }
            System.out.println("小孩序号为：" + cur.getNo());
            cur = cur.getNext();
            if (cur == first){
                break;
            }
        }
    }

    //根据用户的输入，计算出小孩出圈的顺序
    public void countBoy(int startNo, int countNum, int nums){
        //先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums){
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //创建一个辅助指针，完成小孩出圈
        Boy helper = first;
        //需要创建一个辅助指针变量helper,事先应该指向环形链表的最后这个节点
        while (true){
            if (helper.getNext() == first){
                //说明helper指向最后一个小孩节点
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让first和helper移动k - 1次
        for (int j = 0; j < startNo - 1; j ++){
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让first 和 helper 指针同时移动 m-1次，然后出圈
        //这里是一个循环操作，知道圈中有几个点
        while (true){

            if (first == helper){//说明圈中只有一个点
                break;
            }
            for (int j = 0; j < countNum - 1; j++){
                first = first.getNext();
                helper = helper.getNext();
            }

            //这时first指向的节点，就是要出圈的节点
            System.out.println("小孩出圈节点为：" +first.getNo());

            first = first.getNext();
            helper.setNext(first);//
        }
        System.out.println("最后留在圈中的小号节点为：" +helper.getNo());
    }
}

class Boy{
    private int no;//编号
    private Boy next; //指向下一个节点，默认null

    public Boy(int no) {
        this.no = no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}

