package com.LoTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class test01 {
    public static void main(String[] args) {
        //完成实列化
        //方法1 、 now() 获取当前日期
        LocalDate localdate = LocalDate.now();
        System.out.println(localdate);
        LocalTime localtime = LocalTime.now();
        System.out.println(localtime);
        LocalDateTime localdatetime = LocalDateTime.now();
        System.out.println(localdatetime);

        //方法2 of设置指定时间
        LocalDate of =LocalDate.of(2015,5,6);
        System.out.println(of);

        //在开发过程中使用偏多的是LocalDateTime
        //常用的是get
        System.out.println(localdatetime.getYear());
        System.out.println(localdatetime.getDayOfMonth());
        System.out.println(localdatetime.getMonth());
        System.out.println(localdatetime.getDayOfMonth());
        System.out.println(localdatetime.getHour());
        System.out.println(localdatetime.getMinute());
        //LocalDateTime不是set方法是with方法 体会不可变性
        LocalDateTime localDateTime2  = localdatetime.withMonth(6);
        System.out.println(localDateTime2);

        //提供加减 操作
        LocalDateTime localdatetime2=localdatetime.plusMonths(4);
        System.out.println(localdatetime);
        System.out.println(localdatetime2);

        System.out.println("时间减操作");
        LocalDateTime localdatetime3 =localdatetime.minusMonths(1);
        System.out.println(localdatetime);
        System.out.println(localdatetime3);


    }
}
