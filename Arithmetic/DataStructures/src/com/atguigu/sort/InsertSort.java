package com.atguigu.sort;

import java.util.Arrays;

/**
 *@ClassName InsertSort
 *@Description  TODO
 *@Author hqb
 *@Date 2022/5/7 23:48
 *@Version 1.0
 */
public class InsertSort{
    public static void main(String[] args) {
            int[] arr = {101,34,119,1};
            insertSort(arr);
    }

    //插入排序
    public static void insertSort(int[] arr){

        //使用for循环来把代码简化
 /*       for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[]
        }*/


        //定义待插入的数
        //第一轮排序
        int insertVal = arr[1];
        int insertIndex = 1 - 1; //即arr[1]的前面这个数的下标

        //给insertVal 找到插入的位置
        while (insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println("第一轮插入");
        System.out.println(Arrays.toString(arr));

        //第二轮排序
         insertVal = arr[2];
         insertIndex = 2 - 1; //即arr[1]的前面这个数的下标

        //给insertVal 找到插入的位置
        while (insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println("第二轮插入");
        System.out.println(Arrays.toString(arr));

        insertVal = arr[3];
        insertIndex = 3 - 1;//即arr[1]的前面这个数的下标

        //给insertVal 找到插入的位置
        while (insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println("第三轮插入");
        System.out.println(Arrays.toString(arr));
    }

}

