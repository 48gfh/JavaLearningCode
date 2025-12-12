package com.CommutThread.demo01;
/**
 * 共享货架（核心同步区）
 * */
public class BreadShelf {
    private final int capacity;
    private int breadCount;

    public BreadShelf(int capacity) {
        this.capacity = capacity;
        this.breadCount = breadCount;
    }
    //生产者方法 放入面包
    public synchronized void putBread(String bakerName) throws InterruptedException{
        while (breadCount>=capacity){
            System.out.println(bakerName+"发现货架已满，等待顾客购买");
            wait(); //释放锁并等待
        }
        breadCount++;//制作面包师
        System.out.println(bakerName+"制作了1个面包，当前货架"+breadCount+capacity);
        notifyAll();//通知所有等待的消费者
    }
    //消费者方法 取走面包
    public synchronized void takeBread(String customerName) throws InterruptedException {
        while (breadCount<=0){
            System.out.println(customerName+"发现货架为空，等待面包制作");
            wait();
        }
        breadCount--;//购买面包
        System.out.println(customerName+"购买1个面包，当前货架"+breadCount+"/"+capacity);
        notifyAll();//通知所有等待的生产者
    }

}
