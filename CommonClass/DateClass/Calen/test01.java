package com.DateClass.Calen;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class test01 {
    public static void main(String[] args) {
        //Calendar 是一个抽象类，不可以直接创建对象
        //GregorianCalendar()子类继承Calendar
        GregorianCalendar cal1 = new GregorianCalendar();
        GregorianCalendar cal2 = new GregorianCalendar();
        System.out.println(cal1);

        //Calendar 常用方法
        //1、使用get方法 传入参数
        System.out.println(cal1.get(Calendar.YEAR));
        System.out.println(cal1.get(Calendar.MONTH));
        System.out.println(cal1.get(Calendar.DATE));
        //获取当月日期最大天数
        System.out.println(cal1.getActualMaximum(Calendar.MONTH));
        //获取当月日期的最小天数
        System.out.println(cal1.getActualMinimum(Calendar.MONTH));
        //2、使用set方法设置参数
        cal1.set(Calendar.YEAR,2033);
        cal1.set(Calendar.MONTH,5);
        cal1.set(cal1.DATE,32);
        System.out.println(cal1);

    }
}
