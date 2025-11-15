package com.pratice.test01;

import java.util.Scanner;

/**
 * 数字格式转换
 * 从命令行参数或者控制台输入一个字符串，将其转为int后平方输出
 * */
public class NumberTransFormat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数");
        String line = sc.nextLine();
        try{
            int data=Integer.parseInt(line);
            System.out.println("平方为+ "+(data*data));
        }catch (NumberFormatException e ){
            System.out.println("当前输入不合法，请输入一个整数");

        }finally {
            //无论是否是异常都会关闭
            sc.close();
        }
    }
}
