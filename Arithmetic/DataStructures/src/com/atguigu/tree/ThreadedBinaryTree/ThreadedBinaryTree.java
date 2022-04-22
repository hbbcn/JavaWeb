package com.atguigu.tree.ThreadedBinaryTree;


/**
 *@ClassName ThreadedBinaryTree
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/28 17:54
 *@Version 1.0
 */
public class ThreadedBinaryTree{


}

//
//定义一个ThreadedBinaryTree实现线索化功能的二叉树
class BinaryTree{

    private HeroNode root;

    //为了实现线索化，需要创建要给指向当前结点的前驱节点的指针
    //在递归进行线索化时，pre总是保留前一个节点
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //编写对二叉树进行中序线索化的方法
    /**
     *
     * @param node 就是当前需要线索化的节点
     */
    public void threadedNodes(HeroNode node){

        //如果node == null 不能线索化
        if (node == null){
            return;
        }

        //先线索化左子树
       threadedNodes(node.getLeft());
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
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    //说明
    //1.如果leftType==0表示指向的是左子树，如果是1则表示指向前驱节点
    //2.rightType==0表示指向是左子树，如果是1表示指向后继节点
    private int leftType;
    private int rightType;


    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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

    public void delNode(int no) {
        //1、如果当前节点的左子节点不为空，并且左子节点就是要删除的节点，就将this.left = null
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }

        //如果当前节点的右子节点不为空
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }

        //4、我们需要向左子树进行递归删除
        if (this.left != null) {
            this.left.delNode(no);
        }
        //5、则应当向右子树进行递归删除
        if (this.right != null) {
            this.right.delNode(no);
        }

    }

    //编写前序遍历的方法
    public void preOrder() {
        System.out.println(this);//先输出父节点
        //递归向左子树遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);

        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }

        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序遍历查找
    //如果找到就返回当前节点，如果没有找到就返回null
    public HeroNode preOrderSearch(int no) {
        System.out.println("!!!!!!!!!!!");
        if (this.no == no) {
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left;
            resNode = resNode.preOrderSearch(no);
        }
        if (resNode != null) {//说明我们左子树找到
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        HeroNode resNode = null;
        //判断当前节点的左子节点是否为空，如果不为空，则递归中序查找

        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("!!!!!!!!1");
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //后序查找
    public HeroNode postOrderSearch(int no) {
        HeroNode heroNode = null;

        if (this.left != null) {
            heroNode = this.left.postOrderSearch(no);

        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.right != null) {
            heroNode = this.right.postOrderSearch(no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        System.out.println("!!!!!!!!!!!!");
        if (this.no == no) {
            return this;
        }
        return heroNode;
    }
}