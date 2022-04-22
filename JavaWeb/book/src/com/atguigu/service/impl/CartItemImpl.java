package com.atguigu.service.impl;

import com.atguigu.dao.impl.CartDaoImpl;
import com.atguigu.pojo.Cart;


/**
 *@ClassName CartItemImpl
 *@Description  TODO
 *@Author hqb
 *@Date 2022/3/28 18:16
 *@Version 1.0
 */
public class CartItemImpl {

    CartDaoImpl cartDao = new CartDaoImpl();

    public void addCartItem(Cart cart){
        cartDao.addCartItem(cart);
    }

}

