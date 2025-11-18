package com.LoTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;

public class test02 {
    public static void main(String[] args) {
        //方式一 预定义的标准格式
        DateTimeFormatter df1 = DateTimeFormatter.ISO_DATE;
        System.out.println(df1);
        //df1 就可以在LocalDateTime之间互相转换
        //LocalDateTime ->String
        LocalDateTime now =LocalDateTime.now();
        String str = now.toString();
        System.out.println(str);
        //String -> LocalDateTime

        //方式三 自定义格式
        DateTimeFormatter df3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //LocalDate -> String
        LocalDateTime now2 = LocalDateTime.now();
        String format =df3.toString();
        System.out.println(format);

        //String -> LocalDateTime
        TemporalAccessor parese2 = df3.parse("2025-11-18");
        System.out.println(parese2);
    }
}
