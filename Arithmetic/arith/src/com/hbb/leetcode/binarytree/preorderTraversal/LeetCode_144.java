package com.hbb.leetcode.binarytree.preorderTraversal;

import java.util.*;

/**
 *@ClassName LeetCode_144
 *@Description  TODO
 *@Author hqb
 *@Date 2022/4/12 22:49
 *@Version 1.0
 */
public class LeetCode_144{
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(10);

        root.right = node1;
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        List<Integer> li = preorderTraversal(root);
        System.out.println(li);

        List<Integer> list = recursionTraversal(root);
        System.out.println(list);


    }
    //递归遍历
   static ArrayList<Integer> array = new ArrayList<>();
    public static List<Integer> recursionTraversal(TreeNode root){

          if (root==null) return array;
          array.add(root.val);
          recursionTraversal(root.left);
          recursionTraversal(root.right);
          return array;


    }

    //迭代遍历二叉树
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        if(root == null) return array;
        Deque<TreeNode> stack = new ArrayDeque();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            preOrder.add(cur.val);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
        return preOrder;
    }
}
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode() {
    }

    public TreeNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }



    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
