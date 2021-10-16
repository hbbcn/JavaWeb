package com.atguigu.pojo;

import java.math.BigDecimal;

/**
 *@ClassName Book
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/7/18 11:56
 *@Version 1.0
 */
public class Book{

    private  String sn;
    private  String name;
    private  Double price;
    private  String author;
    private BigDecimal price2;

    public BigDecimal getPrice2() {
        return price2;
    }

    public void setPrice2(BigDecimal price2) {
        this.price2 = price2;
    }

    public Book() {
    }

    public Book(String sn, String name, Double price, String author) {
        this.sn = sn;
        this.name = name;
        this.price = price;
        this.author = author;
    }





    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;









}

    @Override
    public String toString() {
        return "Book{" +
                "sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", price2=" + price2 +
                '}';
    }
}
