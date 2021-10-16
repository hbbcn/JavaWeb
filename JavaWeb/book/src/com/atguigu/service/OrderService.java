package com.atguigu.service;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;

public interface OrderService {

    public String createOrder(Cart cart,Integer userId);


}
