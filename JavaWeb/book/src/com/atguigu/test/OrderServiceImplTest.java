package com.atguigu.test;

import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.pojo.OrderItem;
import com.atguigu.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 *@ClassName OrderServiceImplTest
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/4 14:58
 *@Version 1.0
 */
public class OrderServiceImplTest{

    @Test
    public void createOrder() {

        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"数据结构域算法",1,new BigDecimal(100),new BigDecimal(100)));

        OrderServiceImpl orderService = new OrderServiceImpl();

        System.out.println("订单号是："+ orderService.createOrder(cart, 1));

    }

}

