package com.MembershipExpirationReminder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * 用户输入会员开通日期（格式 yyyy-MM-dd）；
 * 会员默认 90 天到期；
 * 计算到期日、剩余天数；
 * 如果剩余 ≤7 天，打印“即将到期”，否则打印“还有 x 天”。
 * */
public class demo1 {
    private  static  final DateTimeFormatter dateFormat=DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("请输入开通日期(yyyy-MM-dd)");
        String openStr= sc.nextLine();

        LocalDate OpenDate = LocalDate.parse(openStr,dateFormat);
        LocalDate expireDate = OpenDate.plusDays(90);
        long remain = ChronoUnit.DAYS.between(LocalDate.now(),expireDate);
        System.out.println("会员到期日"+expireDate.format(dateFormat));
        if(remain<7){
            System.out.println("会员即将到期，还剩"+remain+"天");
        }else{
            System.out.println("会员还有"+remain+"天");
        }



    }
}
