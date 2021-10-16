package com.atguigu.pojo;

import javax.print.DocFlavor;
import javax.xml.catalog.Catalog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 购物车对象
 *@ClassName Cart
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/2 17:16
 *@Version 1.0
 */
public class Cart{

    private BigDecimal totalPrice;

    /**
     * key是商品编号
     * value是商品信息
     */
    private Map<Integer,CartItem> items = new LinkedHashMap<>();


    /**
     * 添加商品
     * @param cartItem
     */
    public void addItem(CartItem cartItem){

        // 先查看购物车中是否已经添加此商品，如果已经添加，则数量累加，总金额更新
        // 如果没有添加直接放到集合即可

        CartItem item = items.get(cartItem.getId());
        if(item == null){
            //之前没有添加过此商品
            items.put(cartItem.getId(),cartItem);
        }else {
            //已经添加过的情况
            item.setCount(item.getCount() + 1);//数量累加
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));//更新总金额
        }

    }


    /**
     * 删除商品项
     * @param id
     */
    public void deleteItem(Integer id){

        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear(){

        items.clear();
    }

    /**
     * 修改商品数量
     * @param id
     * @param count
     */
    public void updateCount(Integer id,Integer count){

        // 先查看购物车中是否有此商品。如果有修改商品数量更新总金额
        CartItem cartItem = items.get(id);
        if (cartItem != null){
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }else{

        }
    }

    public Cart() {
    }


        public Integer getTotalCount() {
            Integer totalCount = 0;
            for(Map.Entry<Integer,CartItem> entry : items.entrySet()){
                totalCount += entry.getValue().getCount();

            }

//            for(CartItem cartItem : items.values()){
//                totalCount += cartItem.getCount();
//            }

        return totalCount;
    }



    public BigDecimal getTotalPrice() {
       BigDecimal totalPrice = new BigDecimal(0);
        for(CartItem  cartItem : items.values() ){
          totalPrice = totalPrice.add(cartItem.getTotalPrice());
        }


        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}

