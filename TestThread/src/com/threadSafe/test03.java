package com.threadSafe;
/**
 * synchronized () 修饰方法
 * */
public class test03 {
    public static void main(String[] args) {
        test03example t =new test03example();
        Thread t1 = new Thread(t,"win1");
        t1.start();
        Thread t2 = new Thread(t,"win2");
        t2.start();
        Thread t3 = new Thread(t,"win3");
        t3.start();


    }
}
class test03example implements Runnable{
    static int count=300;
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            but();
        }
    }

    private static synchronized void but() {
        if (count > 0) {
            System.out.println("在" + Thread.currentThread().getName() + "购买火车票,编号"
                    + "车票剩余" + count--);
        }
    }
}
