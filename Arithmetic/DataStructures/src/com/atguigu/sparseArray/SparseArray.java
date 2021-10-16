package com.atguigu.sparseArray;

import java.util.concurrent.ForkJoinPool;

/**
 *@ClassName SparseArray
 *@Description  TODO
 *@Author hqb
 *@Date 2021/10/11 17:03
 *@Version 1.0
 */
public class SparseArray{

    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        //0：表示没有棋子，1表示黑子 2表示蓝子

        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 2;
        chessArr1[2][3] = 5;
        chessArr1[2][6] = 5;
        chessArr1[3][6] = 5;
        for(int[] row : chessArr1){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //将二位数组 转 稀疏数组

        //1、先遍历二维数组，得到非0数据的个数
        int sum = 0;

        for (int i = 0; i < chessArr1.length; i++) {
            for(int j = 0; j< chessArr1[i].length; j++){
                if (chessArr1[i][j] != 0){
                    sum++;
                }

            }
        }
        System.out.println("sum=" + sum);


        //创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for(int j = 0; j< chessArr1[i].length; j++){
                if (chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];

                }

            }
        }
        System.out.print(sparseArr[0][0]);
        System.out.print(sparseArr[0][1]);
        System.out.println(sparseArr[0][2]);
        System.out.print(sparseArr[1][0]);
        System.out.print(sparseArr[1][1]);
        System.out.println(sparseArr[1][2]);
        System.out.print(sparseArr[2][0]);
        System.out.print(sparseArr[2][1]);
        System.out.println(sparseArr[2][2]);
        System.out.print(sparseArr[3][0]);
        System.out.print(sparseArr[3][1]);
        System.out.println(sparseArr[3][2]);

        //输出稀疏数组的形式
        System.out.println();
        System.out.println("得到稀疏数组为");

        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[i].length;j++){
                System.out.print(sparseArr[i][j] + "\t");
            }
            System.out.println();
        }

        //将稀疏数组恢复成 原始的二维数组
        System.out.println();
        System.out.println("原始的二维数组是：");


        int m = 0;
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 0; i < sparseArr[0][0]; i++) {
            for(int j = 0; j < sparseArr[0][1]; j++){
               if (i == sparseArr[m][0] && j == sparseArr[m][1] && m < sparseArr.length) {
                   m++;
                   chessArr2[i][j] = sparseArr[1][2];
               }
                System.out.print(chessArr1[i][j] + "\t");
            }
            System.out.println();

        }
    }
}

