package com.atguigu.tree;


/**
 *@ClassName BinaryTreeDemo
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/13 19:51
 *@Version 1.0
 */
public class BinaryTreeDemo{

    public static void main(String[] args) {

        //先需要创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4 ,"林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);

        binaryTree.setRoot(root);
        //测试
        System.out.println("前序遍历");
        binaryTree.preOrder();

        System.out.println("中序遍历");
        binaryTree.infixOrder();

        System.out.println("后序遍历");
        binaryTree.postOrder();

        //前序遍历查找
        //4次找到
        System.out.println("前序遍历方式查找");

        HeroNode heroNode = binaryTree.preOrderSearch(5);
        if (heroNode != null){
            System.out.println("找到了，信息为no=" + heroNode.getNo() + ",name=" + heroNode.getName());
        }else {
            System.out.printf("没有找到no=%d的英雄", 5);
        }

        //中序遍历查找 3次
        System.out.println("中序遍历查找！！");
        HeroNode heroNode1 = binaryTree.infixOrderSearch(5);
        if (heroNode1 != null){
            System.out.println("找到了，信息为no=" + heroNode1.getNo() + ",name=" + heroNode1.getName());
        }else {
            System.out.printf("没有找到no=%d的英雄", 5);
        }

        //后序遍历查找
        System.out.println("后序遍历查找");
        HeroNode heroNode2 = binaryTree.postOrderSearch(5);
        if (heroNode2 != null){
            System.out.println("找到了，信息为no=" + heroNode2.getNo() + ",name=" + heroNode2.getName());
        }else {
            System.out.printf("没有找到no=%d的英雄", 5);
        }

        //测试删除节点
        System.out.println("删除前，前序遍历");
        binaryTree.preOrder();//1,2,3,5,4
        binaryTree.delNode(5);
//        binaryTree.delNode(3);
        System.out.println("删除后，前序遍历");
        binaryTree.preOrder();//1,2,3,4


    }



}

//定义一个二叉树
class BinaryTree{

    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }


    //删除节点
    public void delNode(int no){
        if (root != null){
            if (root.getNo() == no){
                root = null;
            }else {
                //递归删除
                root.delNode(no);
            }
        }else {
            System.out.println("空树，不能删除");
        }
    }


    //前序遍历
    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no){
        if (this.root != null ){
            HeroNode heroNode = this.root.preOrderSearch(no);
            return heroNode;
        }else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    //中序遍历
    public HeroNode infixOrderSearch(int no){
        if (root != null){
            return root.infixOrderSearch(no);
        }else{
            return null;
        }
    }

    //后序遍历
    public HeroNode postOrderSearch(int no){
        if (root != null){
            return root.postOrderSearch(no);
        }else {
            return null;
        }

    }
}
//先创建HeroNode节点
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode() {
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //递归删除节点
    //1、如果删除的节点是叶子节点，则删除该节点
    //2、如果删除的节点是非叶子节点，则删除该子树

    public void delNode(int no){
        //1、如果当前节点的左子节点不为空，并且左子节点就是要删除的节点，就将this.left = null
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }

        //如果当前节点的右子节点不为空
        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }

        //4、我们需要向左子树进行递归删除
        if (this.left != null){
            this.left.delNode(no);
        }
        //5、则应当向右子树进行递归删除
        if (this.right != null){
            this.right.delNode(no);
        }

    }

    //编写前序遍历的方法
    public void preOrder(){
        System.out.println(this);//先输出父节点
        //递归向左子树遍历
        if (this.left != null){
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null){
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);

        if (this.right != null){
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }

        if(this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序遍历查找
    //如果找到就返回当前节点，如果没有找到就返回null
    public HeroNode preOrderSearch(int no){
        System.out.println("!!!!!!!!!!!");
        if (this.no == no){
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left;
            resNode = resNode.preOrderSearch(no);
        }
        if (resNode != null){//说明我们左子树找到
            return  resNode;
        }
        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no){
        HeroNode resNode = null;
        //判断当前节点的左子节点是否为空，如果不为空，则递归中序查找

        if (this.left != null){
             resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        System.out.println("!!!!!!!!1");
        if (this.no == no){
            return this;
        }
        if (this.right != null){
             resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //后序查找
    public HeroNode postOrderSearch(int no){
        HeroNode heroNode = null;

        if (this.left != null){
           heroNode = this.left.postOrderSearch(no);

        }
        if (heroNode != null){
            return heroNode;
        }
        if (this.right != null){
            heroNode = this.right.postOrderSearch(no);
        }
        if (heroNode != null){
            return heroNode;
        }
        System.out.println("!!!!!!!!!!!!");
        if (this.no == no){
            return this;
        }
        return heroNode;
    }

}


