package com.atguigu.sort;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


/**
 * @ClassName BubbleSort
 * @Description TODO
 * @Author hqb
 * @Date 2022/4/22 17:47
 * @Version 1.0
 */
//冒泡排序 n个元素需要比较n-1次才会找到最大元素或者最小元素
public class BubbleSort {
    public static void main(String[] args) {
  /*      int arr[] = {3, 9, -1, 10, -2};
        int temp;
        boolean flag = false;
        for(int j = 0 ; j < arr.length - 1; j++){
            for (int i = 0; i < arr.length -1-j; i++) {
                if (arr[i] > arr[i+1]){
                    flag = true;
                    temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                }
            }
            System.out.println("第" + (j + 1) + "趟排序后的数组");
            System.out.println(Arrays.toString(arr));
            //一趟排序中，一次交换都没有发生过
            if (!flag){
                break;
            }else {
                flag = false;
            }
        }*/
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = (int) (Math.random() * 80);
        }
        System.out.print("排序前");
        System.out.println(Arrays.toString(arr));
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = simpleDateFormat.format(date);
        System.out.println("排序前的时间是=" + dateStr);
        //测试冒泡排序
        bubbleSort(arr);
        System.out.print("排序后");
        System.out.println(Arrays.toString(arr));
        Date date1 = new Date();
        String dateStr1 = simpleDateFormat.format(date1);
        System.out.println("排序前的时间后=" + dateStr1);
    }

    //方式一
    public static void bubbleSort(int[] arr) {
        int temp;
        boolean flag = false;
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    flag = true;
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }

    //方式二
    public static int[] bubbleSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        //无序数列的边界，每次比较只需要比到这里为止
        int sortBorder = arr.length - 1;

        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted  = true;//有序标记，每一轮的初始是true
            for (int j = 0; j < sortBorder; j++) {
                if (arr[j + 1] < arr[j]) {
                    isSorted  = false;//有元素交换，所以不是有序，标记变为false
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            //一趟下来是否发生位置交换，如果没有交换直接跳出大循环
            if(isSorted )
                break;
        }
        return arr;
    }
}

