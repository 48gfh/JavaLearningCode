package com.threadSafe.Loc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class test01 {
    public static void main(String[] args) {
        test01Example t = new test01Example();
        Thread t1 = new Thread(t,"win1");
        t1.start();
        Thread t2 = new Thread(t,"win2");
        t2.start();
        Thread t3 = new Thread(t,"win3");
        t3.start();
    }
}

class test01Example implements Runnable{
    static int count=200;
    //拿锁 使用多态调用锁
    Lock lock=new ReentrantLock();
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();//上锁
            try{
                if (count > 0) {
                    System.out.println("在" + Thread.currentThread().getName() + "购买火车票,编号"
                            + "车票剩余" + count--);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();//解锁
            }

        }
    }
}
