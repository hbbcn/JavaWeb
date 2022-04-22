package com.atguigu.tree;
/**
 *@ClassName ArrBinaryTreeDemo
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/21 18:03
 *@Version 1.0
 */
public class ArrBinaryTreeDemo{

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }
}

//编写一个ArrayBinaryTree,实现顺序存储二叉树的遍历

class ArrBinaryTree{

    private int[] arr; //存储数据节点是数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //重载preOrder
    public void preOrder(){
        this.preOrder(0);
    }

    //编写一个方法，完成顺序存储二叉树的前序遍历
    public void preOrder(int index){

        //如果数组为空，或者arr.length = 0
        if (arr == null && arr.length == 0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        System.out.println(arr[index]);

        //向左递归遍历
        if (2 * index + 1 < arr.length){
            preOrder(2 * index + 1);
        }

        //向右递归遍历
        if (index * 2 + 2 <arr.length){
            preOrder(2 * index + 2);
        }

    }
}

