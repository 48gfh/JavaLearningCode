package com.DateClass.Calen;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class test02 {
    //日期格式化工具
   private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {
        System.out.println("Calendar 日期类常用方法");
        getCalendarInstance();
        getDateTimeInfo();
        setDateTime();
        getTimeManager();
        calendarDateConversion();

    }
    //获取Calendar实列的几种方式
    public static void getCalendarInstance(){
        System.out.println("1、获取Calendar实列");
         Calendar calendar1=Calendar.getInstance(); //
        System.out.println("当前时间为"+sdf.format(calendar1.getTime()));
    }


    //获取当前时间的各个字段
    public static void getDateTimeInfo(){
        System.out.println("获取日期信息");
        Calendar cal = Calendar.getInstance();
        //获取年份
        int year =cal.get(Calendar.YEAR);
        System.out.println("年份"+year);
        //获取月份（月份从0开始 0月相当于1月）
        int month=cal.get(Calendar.MONTH);
        System.out.println("月份（0-11）"+month+"实际月份"+(month+1));
        //获取日期 一个月中的第几天
        int dayMonth =cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        System.out.println("一个月中的第几天"+dayMonth);
        //获取小时
        int hour = cal.get(Calendar.HOUR); //12小时制
        int hour24=cal.get(Calendar.HOUR_OF_DAY);//24小时制
        System.out.println("12小时制"+hour+"24小时制"+hour24);
        //获取分钟
        int min = cal.get(Calendar.MINUTE);
        System.out.println("获取分钟"+min);
        //获取秒
        int second = cal.get(Calendar.SECOND);
        System.out.println("秒"+second);
        //获取星期  注意 外国是 1=星期日 2=星期一 以此类推
        int dayWeel= cal.get(Calendar.DAY_OF_WEEK);
        String[] weekdays={"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        System.out.println("星期"+ Arrays.toString(weekdays) +"-> "+weekdays[dayWeel]);
    }

    //设置时间日期
    public static void setDateTime(){
        System.out.println("3、设置时间日期");
        Calendar cal = Calendar.getInstance();
        //设置具体的时间日期
        cal.set(Calendar.YEAR,2025);
        cal.set(Calendar.MONTH,5);
        cal.set(Calendar.DAY_OF_MONTH, 15);
        cal.set(Calendar.HOUR_OF_DAY, 14);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        System.out.println("设置后的时间"+sdf.format(cal.getTime()));
    }

    //获取时间范围
    public static void getTimeManager(){
        System.out.println("获取时间范围");
        Calendar cal = Calendar.getInstance();
        //获取本月的第一天
        Calendar firstDay =(Calendar)cal.clone();
        firstDay.set(Calendar.DAY_OF_MONTH,1);
        System.out.println("本月的第一天"+sdf.format(firstDay.getTime()));

        //获取本月的最后一天
        Calendar lastDay = (Calendar)cal.clone();
        lastDay.set(Calendar.DAY_OF_MONTH, lastDay.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println("本月最后一天: " + sdf.format(lastDay.getTime()));
    }

    //Calendae与Date 互相转换
    public static void calendarDateConversion(){
        System.out.println("Calendar与Date互相转换");
        //Calendar -> Date
        Calendar cal = Calendar.getInstance();
        Date dateFromCal = cal.getTime();
        System.out.println("Canlendar ->Date"+sdf.format(dateFromCal));

        //Date ->Calendar
        Date now = new Date();
        Calendar calFromDate = Calendar.getInstance();
        calFromDate.setTime(now);
        System.out.println("Date转Calendar: " + sdf.format(calFromDate.getTime()));

    }
}
