package com.learning.module5.ArryPractice;

import java.util.Scanner;

public class demo03 {
    public static void main(String[] args) {
        //用一个数组存储学员的姓名，从键盘输入，并遍历显示
        String StudentData[] =new String[3];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < StudentData.length; i++) {
            System.out.println("请输入第"+i+"学员的信息");
            StudentData[i]=sc.next();

        }


    }
}
