package com.DateFor;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class test01 {
    public static void main(String[] args) {
        System.out.println("======DateFormatter常用类方法练习======");
        //基本格式化
        basicFromatting();
        //自定义模式格式化
        customePatternFormat();
    }

    //  基本格式化
    private static void basicFromatting() {
        System.out.println("基本格式化");

        LocalDate date = LocalDate.of(2025,11,21);
        LocalTime time = LocalTime.of(13,30,45);
        LocalDateTime dateTime=LocalDateTime.of(date,time);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of("Asia/Shanghai"));

        //使用默认格式化
        System.out.println("使用默认日期格式"+date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("默认时间格式: " + time.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println("默认日期格式"+dateTime.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println("带时区的日期格式"+zonedDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
    }

    //  自定义模式示例
    public static  void customePatternFormat(){
        System.out.println("自定义模式格式化");
        LocalDateTime now = LocalDateTime.now();
        //常用模式示例
        DateTimeFormatter[] formatters = {
                DateTimeFormatter.ofPattern("yyyy-MM-dd"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"),
                DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒"),
                DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy"),  // 星期, 月份 日, 年
                DateTimeFormatter.ofPattern("hh:mm a"),             // 12小时制带AM/PM
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"), // 带毫秒
                DateTimeFormatter.ofPattern("yyyy年第q季度"),        // 季度
                DateTimeFormatter.ofPattern("'日期:' yyyy-MM-dd '时间:' HH:mm:ss") // 包含文字
        };
        String[] descriptions = {
                "年月日(短横线分隔)",
                "日月年(斜杠分隔)",
                "标准日期时间",
                "中文日期时间",
                "完整英文格式",
                "12小时制时间",
                "带毫秒的ISO格式",
                "季度显示",
                "包含自定义文字"
        };

        for (int i = 0; i < formatters.length; i++) {
            System.out.println(descriptions[i] + ": " + now.format(formatters[i]));
        }

        System.out.println();
    }
}
