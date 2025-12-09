package com.ExtenThrea;
/**
 * 通过继承Thread实现创建线程
 * */
public class testT extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("创建线程遍历"+i);
        }
    }
}
