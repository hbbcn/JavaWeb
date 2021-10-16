package com.atguigu.niuke;
import java.util.HashSet;


/**
 *@ClassName Solution
 *@Description  TODO
 *@Author hqb
 *@Date 2021/10/15 19:31
 *@Version 1.0
 */
//给出一个数组查找数组中两个数之和最接近并且小于目标数的和值，如果不存在返回-1
public class Solution{
    public static void main(String[] args) {
        int[] array = {1,3,5,7,9};
        int i = closestValue(array, 4);
        System.out.println(i);
    }
    public static HashSet getSet(){
        HashSet set = new HashSet();
        return set;
    }
    public static int closestValue(int[] array, int target) {
        HashSet set = getSet();
        int temp = 0;
        int val = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                Integer value = array[i] + array[j];
                set.add(value);
            }
        }
        System.out.println(set);
        for (Object  set1 : set){
            if (target - (Integer)set1 == 0){
                temp = target;
                break;
            }else if(target - (Integer)set1 >= 1){
                val = target - (Integer)set1;
                temp = (Integer)set1;
               if (target - (Integer)set1 < val){
                   val = target - (Integer)set1;
                   temp = (Integer)set1;
               }
            }else {
                if (val == 0){
                    temp = -1;
                }
            }
            }
        return temp;
        }
    }

