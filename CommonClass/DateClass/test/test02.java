package com.DateClass.test;

import java.sql.Date;

//java.sql.data
public class test02 {
    public static void main(String[] args) {
        Date d=new Date(32432424242l);
        System.out.println(d);
        /**
         * java.sql.Date与java.util.Date的区别
         * java.util.Date 年 月 日  时分秒
         * java.sql.Date 年月日
         * java.sql.Date 是java.util.Date的子类
         */
        //java.sql.Date与java.util.Date互相转换
        //util -> sql
        java.util.Date date = new Date(32432424242l);
        //向下转型
        Date date2 = (Date)date;

        //sql -> util
        java.util.Date date3=d;

        //String -> sql.Date
        Date date5 = Date.valueOf("");
        System.out.println(date5);

    }
}
