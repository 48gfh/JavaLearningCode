package com.methdThrea;
/**
 * setDaemon()方法设置伴随线程
 * 子线程将随着主线的创建而创建 消失而消失 子线程的消失不会对主线程产生影响
 * */
public class test05 {
    public static void main(String[] args) {
        //创建并启动子线程
        test05Thread t1 = new test05Thread();
        t1.setDaemon(true);//设置伴随线程启动
        t1.start();
        for (int i = 20; i < 30; i++) {
            System.out.println("这是主线程"+"\\t"+i);
        }
    }
}

class test05Thread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程"+"\\t"+i);
        }
    }
}
