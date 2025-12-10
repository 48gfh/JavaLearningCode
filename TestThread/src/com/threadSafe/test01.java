package com.threadSafe;
/**
 *在之前的火车票的代码示例中出现多个线程争抢资源
 * 为了解决这个问题我们需要在程序中加入锁，保证同步
 * */
public class test01 {
    public static void main(String[] args) {
        test01BuyTicket t1 = new test01BuyTicket();
        Thread t2 = new Thread(t1,"win1");
        t2.start();
        Thread t3 = new Thread(t1,"win2");
        t3.start();
        Thread t4 = new Thread(t1,"win3");
        t4.start();

    }
}

class test01BuyTicket implements Runnable{
    int count=10;
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            synchronized (this){//使用synchronized 把具有安全隐患的代码锁住，如果锁多了会导致效率变低
                if(count>0){
                    System.out.println("在"+Thread.currentThread().getName()+"购买火车票,编号"
                            +i+"车票剩余"+count--);
                }
            }

        }
    }
}
