package com.threadSafe.Loc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class test02 {
    public static void main(String[] args) {
        test02Example t1 = new test02Example("win1");
        t1.start();
        test02Example t2 = new test02Example("win2");
        t2.start();
        test02Example t3 = new test02Example("win3");
        t3.start();
        test02Example t4 = new test02Example("win4");
        t4.start();
    }
}
class  test02Example extends Thread{
    static Lock lock = new ReentrantLock(); //使用静态锁锁对象防止每个进程都有自己的锁
    static int count=50;
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            shop();
        }
    }

    private void shop() {
        lock.lock();
        try{
            if (count > 0) {
                System.out.println("在" + Thread.currentThread().getName() + "购买火车票,编号"
                        + "车票剩余" + count--);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }

    public test02Example(String name) {
        super(name);
    }
}