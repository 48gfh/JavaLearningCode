package com.Practice.test05;

import java.util.Date;

/**
 * 此案例是toString()方法在调试中的实际运用
 * */
public class Product {
    //商品属性
    String id;
    String name;
    double price;
    int stock;
    java.util.Date createDate;



   //业务方法
    public void reduceStock(int quantity){
        if (quantity>stock){
            System.out.println("库存不足"+this.toString());
            throw new IllegalArgumentException("库存不足："+stock);
        }else{
            stock-=quantity;
            System.out.println("库存更新"+stock);
        }
    }



   //对toString()方法进行重写
    @Override
    public String toString() {
        return String.format("Product{id='%s', name='%s', price=%.2f, stock=%d, created=%s}",
                id, name, price, stock,
                new java.text.SimpleDateFormat("yyyy-MM-dd").format(createDate));
    }

    //构造器

    public Product() {
    }

    public Product(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.createDate = new java.util.Date();
    }



}
