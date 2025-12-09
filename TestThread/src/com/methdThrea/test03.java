package com.methdThrea;
/**
 * sleep() 设置人为阻塞
 * */
public class test03 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            if (i==2){
                Thread.sleep(4000);
            }
            System.out.println("主线程"+i);
        }
    }
}
class test03Thead extends Thread{
    @Override
    public void run() {
        super.run();
    }
}