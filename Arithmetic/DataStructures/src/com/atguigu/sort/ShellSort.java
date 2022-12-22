package com.atguigu.sort;


import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * @ClassName ShellSort
 * @Description TODO
 * @Author hqb
 * @Date 2022/5/18 13:56
 * @Version 1.0
 */
public class ShellSort {

    //希尔排序
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        System.out.println("排序前 = " + Arrays.toString(arr));
        shellSort(arr); //交换式
        shellSort2(arr); //移位式
//        System.out.println(Arrays.toString(arr));


    }

    //使用逐步推导的方式来编写希尔排序
    //希尔排序时，对有序序列在插入时采用交换法，
    //思路（算法） ===》 代码
    public static void shellSort(int[] arr) {


        //方法一使用JDK提供Arrays类中的sort方法进行排序（是对归并排序的优化）
//        Arrays.sort(arr);
        //希尔排序第一轮排序 希尔排序目的为了加快速度改进了插入排序，交换不相邻的元素对数组的局部进行排序，并最终用插入排序将局部有序的数组排序。
        //
        //在此我们选择增量 gap=length/2，缩小增量以 gap = gap/2 的方式，用序列 {n/2,(n/2)/2...1} 来表示。
        //因为是第一轮排序，是将是个数据分成5组

        //根据前面的逐步分析，使用循环处理
        int temp1 = 0;
        int count1 = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2){
            for (int i = gap; i < arr.length; i++){
                //遍历各组中所有元素(共gap组)，步长gap
                for (int j = i - gap; j >= 0; j -=gap){
                    if (arr[j] > arr[j + gap]){
                        //如果当前元素大于加上步长后的那个元素，说明交换
                        temp1 = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp1;
                    }
                }
            }
            System.out.println("希尔排序" + (++count1) + "轮 = " + Arrays.toString(arr));
        }
     /*   int temp = 0;
        int sum = 0;
        for (int i = 5; i < arr.length; i++) {
            //遍历各组中所有的元素（共五组 每组2个元素）
            for (int j = i - 5; j >= 0; j -= 5) {
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                    sum++;
                }
            }
        }
        System.out.println("希尔排序1轮后 = " + Arrays.toString(arr));
        System.out.println(sum);

        int count = 0;
        //第二轮排序，是将10个数据分成5/2 = 2组
        for (int i = 2; i < arr.length; i++) {
            //遍历各组中所有的元素(共2组 每组5个元素),步长5
            for (int j = i - 2; j >= 0; j -= 2) {
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                    count ++;
                }

            }
        }
        System.out.println("希尔排序2轮后 = " + Arrays.toString(arr));
        System.out.println("count = " + count);

        //第3轮排序，是将10个数据分成2/2 = 1组
        for (int i = 1; i < arr.length; i++) {
            //遍历各组中所有的元素(共2组 每组5个元素),步长5
            for (int j = i - 1; j >= 0; j -= 1) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }

            }
        }
        System.out.println("希尔排序3轮后 = " + Arrays.toString(arr));*/
    }

    //对交换式的希尔排序进行优化 —》移位法
    public static void shellSort2(int[] arr){
        //增量gap 并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2){
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++){
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]){
                    while (j - gap >= 0 && temp < arr[j - gap]){
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }
            }
        }
    }


}

