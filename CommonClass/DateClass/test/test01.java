package com.DateClass.test;

import java.util.Date;

public class test01 {
    public static void main(String[] args) {
        //java.util.Date
        Date date=new Date();
        System.out.println(date);
        System.out.println(date.toString());
        System.out.println(date.toGMTString());//过期方法
        System.out.println(date.toLocaleString());
        System.out.println(date.getYear());
        System.out.println(date.getMonth()); //返回值在0-11之间，0表示1月

        // //返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数
        System.out.println(date.getTime());
        System.out.println(System.currentTimeMillis());

        //Q 以后获取时差用getTime()还是currentTimeMillis()  A： currentTimeMillis()方法 此方法是静态可直接调用
        // public static native long currentTimeMillis()  本地方法 为什么没有方法体？ 以为这个方法的具体实现不是通过java实现

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
        long endTime = System.currentTimeMillis();
    }
}
