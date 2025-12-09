package com.methdThrea;
/**
 * 使用join()设置优先级 必须先start再join
 * */
public class test02 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 10; i < 30; i++) {
            if(i==16){
                System.out.println("正在运行子线程");
                TestThread t1 = new TestThread("子线程");
                t1.start();
                t1.join();//半路杀出“程咬金”
                System.out.println("主线程将正常运行....");
            }
            System.out.println(i);
        }

    }
}
class TestThread extends Thread{

    public TestThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("这是子线程"+i);
        }
    }
}
