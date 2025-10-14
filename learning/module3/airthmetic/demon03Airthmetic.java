package com.learning.module3.airthmetic;

public class demon03Airthmetic {
    public static void main(String[] args) {
        int i = 10;
        i++;
        //++i;
        System.out.println("i的值为："+i);

        System.out.println("======================");

        int j = 100;
        int result01  =  ++j;
        System.out.println("result01 ="+result01);
        System.out.println("j 的值为："+j);
        System.out.println("=================================");

        int k =100;
        int result02 = k++;
        System.out.println("result02 = "+result02);
        System.out.println("k 的值为:" + k);
        System.out.println("===============================");

        int z = 100;
        System.out.println("z++ ="+(z++));
        System.out.println("z的值为："+z);
        System.out.println("==================================");


        int x = 10;
        int y = 20;
        int result03 = x++ +  --y + ++x;
        System.out.println("result03 = " + result03);
        System.out.println("===================================");

        int c = 10;
        c=c++;
        System.out.println("c的值为: " +c);
        System.out.println("c的值为："+c);
    }
}
