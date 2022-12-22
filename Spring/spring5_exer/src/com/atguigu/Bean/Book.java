package com.atguigu.Bean;
/**
 *@ClassName Book
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/16 16:50
 *@Version 1.0
 */

public class Book{

    private Integer userId;
    private String username;
    private String ustatus;



    public Book() {
    }

    public Book(Integer userId, String username, String ustatus) {
        this.userId = userId;
        this.username = username;
        this.ustatus = ustatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUstatus() {
        return ustatus;
    }

    public void setUstatus(String ustatus) {
        this.ustatus = ustatus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", ustatus='" + ustatus + '\'' +
                '}';
    }
}



