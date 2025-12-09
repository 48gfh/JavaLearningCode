package com.ExtenThrea;
/**
 *
 * */
public class test01 {
    public static void main(String[] args) {
        //调用子线程
        testT t1 = new testT();
        t1.start();//start()是Thread类中的方法


        for (int i = 0; i < 10; i++) {
            System.out.println("主线程遍历"+i);
        }



    }
}
