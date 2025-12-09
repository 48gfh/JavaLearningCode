package com.RunableThrea;
/**
 * 通过实现Runnable抽象类创建线程
 * */
public class test01 {
    public static void main(String[] args) {
        //创建子线程对象
        runab t1 = new runab();
        Thread t2 =new Thread(t1);
        t2.start();
        for (int i = 100; i < 200; i++) {
            System.out.println("这是主线程调用"+i);
        }

    }
}

class runab implements Runnable {


    @Override
    public void run() {
        //输出1-10数字
        for (int i = 0; i < 100; i++) {
            System.out.println("这是子线程"+i);
        }
    }
}