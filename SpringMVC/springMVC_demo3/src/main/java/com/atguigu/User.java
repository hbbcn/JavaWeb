package com.atguigu;
/**
 *@ClassName User
 *@Description  TODO
 *@Author hqb
 *@Date 2022/1/2 22:55
 *@Version 1.0
 */
public class User{

    private String userName;
    private String passWord;

    public User() {
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

}

