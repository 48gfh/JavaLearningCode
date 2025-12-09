package com.ExtenThrea;

public class TrainTicketexample {
    public static void main(String[] args) {
        picket num1=new picket("win1");
        num1.start();
        picket num2=new picket("win2");
        num2.start();
        picket num3=new picket("win3");
        num3.start();

    }
}
class  picket extends Thread{
    static int picket=10;
    public picket(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (picket>0){
                System.out.println(this.getName()+"已经成功购票，还剩余"+picket--);
            }
        }
    }
}
