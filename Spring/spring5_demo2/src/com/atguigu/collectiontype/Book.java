package com.atguigu.collectiontype;

import java.util.List;

/**
 *@ClassName Book
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/7 18:16
 *@Version 1.0
 */
public class Book{

    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void test(){
        System.out.println(list);
    }
}

