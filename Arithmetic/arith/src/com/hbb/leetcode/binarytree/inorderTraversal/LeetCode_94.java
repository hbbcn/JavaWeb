package com.hbb.leetcode.binarytree.inorderTraversal;
/**
 * @ClassName leetCode_94
 * @Description TODO
 * @Author hqb
 * @Date 2022/4/12 14:12
 * @Version 1.0
 */
import java.util.LinkedList;
import java.util.Stack;


/**
 * 给定一个二叉树的根节点 root ，返回它的中序遍历 。
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 输入：root = []
 * 输出：[]
 * 输入：root = [1]
 * 输出：[1]
 */


public class LeetCode_94 {
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

        LinkedList<Integer> res = recursion(root);
        System.out.println(res);

        LinkedList<Integer> iteration = iteration(root);
        System.out.println(iteration);


    }

    static LinkedList<Integer> list = new LinkedList<>();

    //递归遍历
    public static LinkedList<Integer> recursion(TreeNode root) {

        if (root != null) {
            recursion(root.left);
            list.add(root.val);
            recursion(root.right);
        }
        return list;
    }

    //迭代算法
    public static LinkedList<Integer> iteration(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack();
        if (root == null) return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            while (root != null ){
                root = root.left;
                stack.push(root);
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;


     /*   while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;*/
    }
}

class TreeNode {
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

