package com.atguigu.dao.impl;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.pojo.OrderItem;

/**
 *@ClassName OrderItemDaoImpl
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/4 11:26
 *@Version 1.0
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

    @Override
    public int saveOrderItem(OrderItem orderitem) {

        String sql = "insert into t_order_item values(?,?,?,?,?,?)";
        return update(sql,orderitem.getId(),orderitem.getName(),orderitem.getCount(),orderitem.getPrice(),orderitem.getTotalPrices(),orderitem.getOrderId());
    }
}

