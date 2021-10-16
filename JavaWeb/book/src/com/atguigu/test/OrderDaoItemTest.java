package com.atguigu.test;

import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 *@ClassName OrderDaoItemTest
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/4 12:01
 *@Version 1.0
 */
public class OrderDaoItemTest{

    @Test
    public void OrderDaoItem(){
        OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();

        orderItemDao.saveOrderItem(new OrderItem(null,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100),"1234"));

    }

}

