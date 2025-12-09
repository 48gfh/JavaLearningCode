package com.methdThrea;
/**
 * 设置优先级 使用setPriority()参数1-10 优先级逐级递增
 * */
public class test01 {
    public static void main(String[] args) {
        //创建两个子线程
        t1  t= new t1("子线程1");
        t.setPriority(10);//优先级最高
        t.start();

        t2 t0 = new t2("子线程2");
        t0.setPriority(1);//优先级最低
        t0.start();

        for (int i = 100; i <300 ; i++) {
            System.out.println("这是主线程"+i);
        }

    }
}

class t1 extends Thread{
    public t1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("这是子线程t1"+i);
        }
    }
}


class t2 extends Thread{
    public t2(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 20; i <40 ; i++) {
            System.out.println("这是子线程t2"+i);
        }
    }
}