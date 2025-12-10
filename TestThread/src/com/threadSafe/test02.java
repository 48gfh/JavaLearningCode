package com.threadSafe;

public class test02 {
    public static void main(String[] args) {
        test02Tickexample t1 =new test02Tickexample("win1");
        t1.start();
        test02Tickexample t2 =new test02Tickexample("win2");
        t2.start();
        test02Tickexample t3 =new test02Tickexample("win3");
        t3.start();


    }
}
class  test02Tickexample extends Thread {
    static int count = 10000;

    public test02Tickexample(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (test02Tickexample.class) {
                if (count > 0) {
                    System.out.println("在" + Thread.currentThread().getName() + "购买火车票,编号"
                            + i + "车票剩余" + count--);
                }

            }
        }
    }
}
