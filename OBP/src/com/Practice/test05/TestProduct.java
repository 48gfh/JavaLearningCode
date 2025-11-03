package com.Practice.test05;

public class TestProduct {
    public static void main(String[] args) {
        Product product = new Product("P001", "笔记本电脑", 5999.99, 10);
        System.out.println("==========调试信息==========");
        System.out.println("当前产品"+product);
        System.out.println("==========业务操作==========");
        product.reduceStock(3);
        System.out.println("异常情况");
        try{
            product.reduceStock(10);
        } catch (Exception e) {
            System.out.println("错误"+e.getMessage());
        }
    }
}
