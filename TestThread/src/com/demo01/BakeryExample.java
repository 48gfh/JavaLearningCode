package com.CommutThread.demo01;

public class BakeryExample {
    public static void main(String[] args) {
        // 1. 创建共享资源（货架）
        BreadShelf shelf = new BreadShelf(5);

        // 2. 创建生产者和消费者
        Thread baker1 = new Thread(new Baker(" baker-张师傅", shelf), " baker-张师傅");
        Thread baker2 = new Thread(new Baker(" baker-李师傅", shelf), " baker-李师傅");
        Thread customer1 = new Thread(new Customer(" customer-小明", shelf), " customer-小明");
        Thread customer2 = new Thread(new Customer(" customer-小红", shelf), " customer-小红");

        // 3. 启动所有线程
        baker1.start();
        baker2.start();
        customer1.start();
        customer2.start();
    }
}
