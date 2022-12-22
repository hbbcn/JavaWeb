package com.atguigu.spring5;
/**
 *@ClassName Orders
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/7 14:47
 *@Version 1.0
 */
public class Orders{

    private String oname;
    private String address;


    public void setOname(String oname) {
        this.oname = oname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Orders() {
    }

    /**
     * 有参构造器注入属性
     * @param oname
     * @param address
     */


    public Orders(String oname,String address){
       this.oname = oname;
        this.address = address;
    }

    public void ordersTest(){
        System.out.println(oname +"::" +address);
    }
}

