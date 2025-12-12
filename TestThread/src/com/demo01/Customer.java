package com.CommutThread.demo01;
/**
 * 消费者 顾客
 * */
public class Customer implements Runnable {
    private final String name;
    private final BreadShelf shelf;

    public Customer(String name, BreadShelf shelf) {
        this.name = name;
        this.shelf = shelf;
    }

    public String getName() {
        return name;
    }

    public BreadShelf getShelf() {
        return shelf;
    }

    @Override
    public void run() {
        try{
            for (int i = 0; i < 6; i++) { //每个顾客买六个面包
                shelf.takeBread(name);
                Thread.sleep((long) (Math.random() * 800)); // 模拟购物时间
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            Thread.currentThread().interrupt();
        }
        
    }
}
