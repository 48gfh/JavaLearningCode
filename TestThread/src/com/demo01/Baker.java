package com.CommutThread.demo01;
/**
 * 生产者 面包师
 * */
public class Baker implements Runnable {
    private final String name;
    private final BreadShelf shelf;

    public Baker(String name, BreadShelf shelf) {
        this.name = name;
        this.shelf = shelf;
    }

    @Override
    public void run() {
        try{
            for (int i = 0; i < 8; i++) {
                shelf.putBread(name);
                Thread.sleep((long) (Math.random() * 500)); // 模拟制作时间
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }finally {

        }
    }
}
