package com.threadSafe;

public class test04 {
    public static void main(String[] args) {
        test04Example t1 = new test04Example("win1");
        t1.start();
        test04Example t2 = new test04Example("win2");
        t2.start();
        test04Example t3 = new test04Example("win3");
        t3.start();
        test04Example t4 = new test04Example("win4");
        t4.start();

    }
}
class test04Example extends Thread{
    static int count=400;
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            shop();
        }

    }

    private static synchronized void shop() {
        if (count > 0) {
            System.out.println("在" + Thread.currentThread().getName() + "购买火车票,编号"
                    + "车票剩余" + count--);
        }
    }

    public test04Example(String name) {
        super(name);
    }
}
