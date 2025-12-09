package com.RunableThrea;
/**
 * 通过实现Runnable抽象方法
 * */
public class TrainTicket {
    public static void main(String[] args) {
        //定义一个线程对象
        tick t1 = new tick();
        //窗口1买票
        Thread win1 =new Thread(t1,"窗口1");
        win1.start();
        //窗口2买票
        Thread win2 = new Thread(t1,"窗口2");
        win2.start();
        //窗口3买票
        Thread win3 = new Thread(t1,"窗口3");
        win3.start();

    }
}
class tick implements Runnable{
    int count=10;

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            if (count>0){
                System.out.println(Thread.currentThread().getName()+"已经买了"+i+"还剩"+count--);
            }

        }

    }
}
