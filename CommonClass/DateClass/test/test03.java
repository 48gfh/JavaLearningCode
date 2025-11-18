package com.DateClass.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * String ->java.util.Date类型转换分为：
 * String -> java.sql.Date
 * java.sql.Date -> java.util.Date
 * */
public class test03 {
    public static void main(String[] args) {
        //String -> java.sql.Date
        java.sql.Date date = java.sql.Date.valueOf("2025-6-7");
        //java.sql.Date -> java.util.Date
        java.util.Date date2 = date;
        System.out.println(date2.toString());
        //以上代码知识和标准的年月日拼接形式，换成其他类型可能会出现异常。所以我们引入新类SimpleDateFormat
        DateFormat df = new SimpleDateFormat("YYYY-MM-ddHH:mm:ss");
        //String -> data
        try{
            Date d =df.parse("2014-4-5 12:10:54");
            System.out.println(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Date ->String
        String format = df.format(new Date());
        System.out.println(format);

        Date  dateTest = new Date();
        System.out.println(dateTest.toString());
        System.out.println(dateTest.toGMTString());
        System.out.println(dateTest.toLocaleString());


    }
}
