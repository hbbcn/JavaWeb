package com.atguigu.dao.impl;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;

import java.util.Map;

/**
 *@ClassName CartDaoImpl
 *@Description  TODO
 *@Author hqb
 *@Date 2022/4/10 11:19
 *@Version 1.0
 */
public class CartDaoImpl extends BaseDao{
    public void addCartItem(Cart cart) {
        //将购物车商品添加到数据库中
        String userName = cart.getUserName();
        for (Map.Entry cartItem : cart.getItems().entrySet()) {
            String sql = "insert into t_cart_item values(?,?,?,?,?,?)";
            System.out.println(cartItem);
            System.out.println("value=" + cartItem.getValue());
            CartItem value = (CartItem) cartItem.getValue();
            update(sql, userName, value.getId(), value.getName(), value.getCount(), value.getPrice(), value.getTotalPrice());
        }
        System.out.println("在数据库中插入数据成功");
    }
}

