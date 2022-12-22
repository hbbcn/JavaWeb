package com.hbb.interview_arth;
/**
 *@ClassName ShowMeBug
 *@Description  TODO
 *@Author hqb
 *@Date 2022/5/25 17:58
 *@Version 1.0
 */
import java.util.*;
public class ShowMeBug {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 给定一个高度为 2000mm 的柜子空间，以及 n 个层板距离柜子底部高度，满足移动层板位置 使得层板等分衣柜的空间。
        // 计算所有移动层板的顺序。层板号自下向上依次排列，1，2..n。层板需要考虑空间位置，不能跨层板移动。
        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
        int div = 2000 / (n + 1);
        for (int i = 0; i < solve(heights, div).size(); i++) {
            System.out.print(solve(heights,div).get(i) + " ");
        }
    }

    private static ArrayList<Integer> solve(int[] heights, int div) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] canBeSwifted = new int[heights.length];
        Arrays.fill(canBeSwifted, 0);
        for (int i = 0; i < heights.length; i++) {
            if (i != heights.length - 1) {
                if (heights[i + 1] - heights[i] > div) {
                    canBeSwifted[i] = 1;
                }
            } else {
                if (2000 - heights[i] > div) {
                    canBeSwifted[i] = 1;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < canBeSwifted.length; i++) {
            if (canBeSwifted[i] == 1) {
                list.add(Math.abs(((i + 1) * div) - heights[i]));
            }
        }
        ArrayList<Integer> list2 = new ArrayList<>();
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < heights.length; j++) {
                if(list.get(i) == Math.abs(((j + 1) * div) - heights[j])){
                    list2.add(heights[j]);
                }
            }
        }
        for (Integer integer : list2) {
            for (int j = 0; j < heights.length; j++) {
                if (integer == heights[j]) {
                    res.add(j + 1);
                }
            }
        }
        for (int i = heights.length - 1; i >= 0; i--) {
            if (canBeSwifted[i] == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}

