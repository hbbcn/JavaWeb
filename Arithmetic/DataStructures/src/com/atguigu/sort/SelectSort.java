package com.atguigu.sort;
import java.util.Arrays;

/**
 *@ClassName SelectSort
 *@Description  TODO
 *@Author hqb
 *@Date 2022/5/6 14:22
 *@Version 1.0
 */
public class SelectSort{
    public static void main(String[] args) {
        int[] arr = new int[]{101,34,119,1};
        selectSort(arr);
    }

    //选择排序 原始数组： 101，34，119，1
    //算法思想：先简单=>再复杂，就是可以把一个复杂的算法，拆分成简单的问题=》逐步解决
    public static void selectSort(int[] arr){
        int minIndex = 0;
        int min = arr[0];
        for(int j = 0; j < arr.length - 1; j++){
            minIndex = j;
            min = arr[j];
            for (int i = 1 + j; i < arr.length ; i++) {
                if (min > arr[i]){
                    min = arr[i];
                    minIndex = i;
                }
            }
            //将最小值，放在arr[0],即交换
            if (minIndex != j){
                arr[minIndex] = arr[j];
                arr[j] = min;
            }
            System.out.println(Arrays.toString(arr));
        }
        }

}

