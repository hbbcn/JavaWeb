package com.hbb.leetcode.binarytree.scanner;

import org.junit.Test;

import java.util.Scanner;

/**
 *@ClassName HashNextTest
 *@Description  TODO
 *@Author hqb
 *@Date 2022/4/13 16:30
 *@Version 1.0
 */

/**
 * next()方法与hasnext()方法的相同与不同之处：
 * 相同：
 *
 * 如果当前scanner对象的迭代器(iterator)指针指向的下一个字符串值为空时都会阻塞此方法并等待用户输入。
 * 不同：
 *
 * 返回值不同：
 * next()返回的是当前指针指向的字符串,
 * hasnext()返回的是true(不会返回false,如果指针指向的下一个值为空则阻塞等待用户输入）。
 * 指针是否下移：
 * next()方法每调用一次都会将指针下移，
 * hasnext()方法不会移动指针。
 */
public class HashNextTest{

    /**
     * 第一个next()方法阻塞等待用户输入，输入“Java C操”后按回车，第一个next()方法返回第一个字符串Java，
     * 第二个next()方法由于指针指向不为空所以不会等待用户输入，而是直接返回指向的字符串C操。
     * 如果输入java回车，第二个next()方法会阻塞等待用户输入 再输入C操才会结束
     *
     * 结果解释
     *
     * 调用next()方法时如果当前scanner对象的迭代器(iterator)指针指向的下一个字符串值为空
     * (不是判断当前指针指向的值，而是判断下一个值是否为空）
     * 则将指针下移并且阻塞此方法等待用户输入，用户输入完则返回用户输入的第一个字符串(以空格为分隔符)。
     * (scanner对象使用char[]数组保存用户输入的字符串，以空格作为分隔符)。
     * 如果当前scanner对象的迭代器(iterator)指针指向的下一个字符串值不为空则将指针下移，
     * 然后返回当前指针指向的字符串，不会等待用户输入。
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(sc.next());
        System.out.println(sc.next());
    }
}

class hashTest{
    /**
     * 首先hashnext()方法阻塞等待用户输入，输入“马云 强东 化腾”后按回车，
     * hashnext()方法返回true进入循环，next()方法指针不断下移读取完后光标仍在闪烁，
     * 等待用户再次输入，无法跳出循环运行 System.out.println(“输入完成”)。
     * @param args
     *
     * 结果解释
     *
     * 调用hasnext()方法时如果当前scanner对象的迭代器(iterator)指针指向的下一个字符串值为空
     * （不是判断当前指针指向的值，而是判断下一个值是否为空）则阻塞此方法等待用户输入，
     * 用户输入完后返回true，指针不会下移。如果当前scanner对象的迭代器(iterator)指针指向的
     * 下一个字符串值不为空则立即返回true，不会等待用户输入。
     * hasnext()方法永远不会返回false,因为如果scanner对象的迭代器(iterator)
     * 指针的下一个字符串值为空时会阻塞此方法继续等待用户输入。
     *
     * 解决方法
     *
     * 如果想要通过hasnext()方法结束输入需要用到hasnext带参数的一个重载方法。
     * hashNext(Pattern pattern) 如果下一个完整标记与指定模式匹配，则返回true
     * hashNext(String pattern) 如果下一个标记与从指针字符串构造的模式匹配 则返回true
     */
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int i=1;
            while(sc.hasNext()){
                System.out.println("第"+i+"个字符串"+sc.next());
                i++;
            }
            System.out.println("输入完成");
    }
}

/**
 * 用“#”号当结束条件
 */
class HashTest01{
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int i=1;
        while(!sc.hasNext("#")){
            System.out.println("第"+i+"个字符串："+sc.next());
            i++;
        }
        System.out.println("输入完成");

    }

}

