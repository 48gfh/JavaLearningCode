package com.pratice.test01;

import java.util.Scanner;

/**
 * 写一个简答的计算器，用户输出两个整数，输出商
 * 预期异常 除0时会抛出 ArithmeticException
 * */
public class DivideDemo {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("请输入被除数");
        int data1=sc.nextInt();
        System.out.println("请输入除数");
        int data2=sc.nextInt();

        try{
            int result=data1/data2;
            System.out.println("计算结果为："+result);
        } catch (ArithmeticException e) {
            System.out.println("捕获到算数异常：除数不能为0");
        }finally {
            //关闭输入流 无论如何finally都会执行
            sc.close();
        }

    }
}
