package com.atguigu.spring5;
/**
 *@ClassName Book
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/7 13:51
 *@Version 1.0
 */
public class Book{

    private String bname;
    private String bauthor;
    private String address;

    //使用set方法进行属性的注入

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void testBook(){
        System.out.println(bname + "::" + bauthor + ":: " + address);
    }
}

