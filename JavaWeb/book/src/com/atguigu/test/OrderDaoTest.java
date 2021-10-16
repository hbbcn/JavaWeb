package com.atguigu.test;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 *@ClassName OrderDaoTest
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/4 11:49
 *@Version 1.0
 */
public class OrderDaoTest{

  OrderDao order =  new OrderDaoImpl();
    @Test
    public void saveOrder(){
        order.saveOrder(new Order("1234", new Date(), new BigDecimal(123.22), 0, 1));

    }

}

