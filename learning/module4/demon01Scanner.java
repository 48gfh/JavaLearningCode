package com.learning.module4;

import java.util.Scanner;

public class demon01Scanner {
    public static void main(String[] args) {
/*        //创建对象
        Scanner sc = new Scanner(System.in);
        //录入int类整数
        int  data1 = sc.nextInt();
        System.out.println("data1 = "+data1);

        //录入String型字符串
        String data2 = sc.next();
        System.out.println("data2 = "+data2);*/

        Scanner sc = new Scanner(System.in);
        String data1 = sc.next();
        String data2 = sc.nextLine();
        System.out.println("data1 = " + data1);
        System.out.println("data2 = "+data2);





/*           //创建对象
       Scanner sc =new Scanner(System.in);
       System.out.println("请分别输入三个老人的年龄");
       int old1=sc.nextInt();
       int old2=sc.nextInt();
       int old3=sc.nextInt();

       int temp1 = old1>old2?old1:old2;
       int temp2 = temp1>old3?old1:old3;
       System.out.println("最大的年龄是： "+temp2);*/
    }
}
