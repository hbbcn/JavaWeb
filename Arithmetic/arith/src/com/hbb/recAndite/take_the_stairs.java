package com.hbb.recAndite;
import java.util.Scanner;
import static java.lang.Math.pow;

/**
 *@ClassName take_the_stairs
 *@Description  TODO
 *@Author hqb
 *@Date 2022/5/2 0:40
 *@Version 1.0
 */
public class take_the_stairs{

    public static void main(String[] args) {

        int sum = fun(1);
        System.out.println(sum);
    }
    /*
        一个台阶总共有n级，如果一次可以跳1级，也可以跳2级。
        求总共有多少总跳法。I第一行输入T，表示有多少个测试数据。
        接下来T行，每行输入一个数n，表示台阶的阶数。
        首先，我们的第一步有两种可能，可以选择爬1个或2个台阶：

    ①：如果我们第一步爬1个台阶，那还剩下n-1个台阶，剩下的n-1个台阶的爬法是f(n - 1)
    ②：如果我们第一步爬2个台阶，那还剩下n-2个台阶，剩下的n-2个台阶的爬法是f(n - 2)
        所以总的爬法 f(n) = f(n - 1) + f(n - 2)，其实就是一个裴波那契数列，解法和裴波那契的解法完全一致！
    */
    public static int fun(int n){
        if (n <= 2){
            return n;
        }else {
            return fun(n-1) + fun(n-2);
        }
    }

    /*


    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    每次你可以爬 2的n次幂个台阶。即每次可以爬1、2、4、8、16…你有多少种不同的方法可以爬到楼顶呢？
    还是同样的分析，我们先分析第一步有多少种可能

    ①：如果我们第一步爬1个台阶，那还剩下n-1个台阶，剩下的n-1个台阶的爬法是f(n - 1)
    ②：如果我们第一步爬2个台阶，那还剩下n-2个台阶，剩下的n-2个台阶的爬法是f(n - 2)
    ③：如果我们第一步爬4个台阶，那还剩下n-4个台阶，剩下的n-4个台阶的爬法是f(n - 4)
    ④：如果我们第一步爬8个台阶，那还剩下n-8个台阶，剩下的n-8个台阶的爬法是f(n - 8)
    ④：如果我们第一步爬16个台阶，那还剩下n-16个台阶，剩下的n-16个台阶的爬法是f(n - 16)

    究竟要分析到哪里结束呢？假如我要求9阶时的爬法，那第一步总不能爬16个台阶吧，因为我本身只有9个台阶，
    怎么能一步就爬16个台阶呢，但是我第一步可以爬8个台阶，所以第一步的步数step不能大于总的阶数n。
    这就是传说中的动态规划思想呀
     */

    public static void  Main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;  //当台阶只有1的时候，走法只有1种
        dp[2] = 2;  //当台阶只有2的时候，走法只有2种
        for (int i = 3; i <= n; i++) {
            int tmp = 0;
            //pow(2, tmp)为第一步的步数，第一步的步数不能大于总的台阶数i
            while (pow(2, tmp) <= i) {
                //第一步的步数小于总的台阶数i
                if (pow(2, tmp) < i) {
                    //假如第一步爬的阶数是pow(2, 0) = 1，那么还剩i - 1个台阶，走法为dp[i-1]
                    dp[i] += dp[i - (int) pow(2, tmp)];
                }
                //第一步的步数等于总的台阶数i，那么一步就走完了，所以只有一种走法
                else if (pow(2, tmp) == i) {
                    dp[i] += 1;
                }
                tmp++;
            }
        }
        System.out.println(dp[n]);
    }
}



