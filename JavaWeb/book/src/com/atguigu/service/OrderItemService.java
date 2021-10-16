package com.atguigu.service;

import com.atguigu.pojo.OrderItem;

import java.util.List;

/**
 *@ClassName OrderItemService
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/4 12:14
 *@Version 1.0
 */
public interface OrderItemService{

    public void addOrderItem(OrderItem orderItem);
    public void deleteOrderItem(Integer id);
    public void updateOrderItem(Integer id);
    public OrderItem queryOrderItemById(Integer id);
    public List<OrderItem> queryOrderItemALL();

}

