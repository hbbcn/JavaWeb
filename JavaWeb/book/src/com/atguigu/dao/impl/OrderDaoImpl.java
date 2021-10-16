package com.atguigu.dao.impl;

import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;

/**
 *@ClassName OrderDaoImpl
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/4 11:03
 *@Version 1.0
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public int saveOrder(Order order) {

        String  sql = "insert into t_order values(?,?,?,?,?)";

        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}

