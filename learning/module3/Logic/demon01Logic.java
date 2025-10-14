package com.learning.module3.Logic;

public class demon01Logic {
    public static void main(String[] args) {
        int i = 10;
        int j = 20;
        int k = 30;
        boolean result01 = (i>j)  && (i==j);
        System.out.println("result01 = "+ result01);

        boolean result02 = (i>j) || (i==k);
        System.out.println("result02 = "+result02);

        boolean result03  = (i>j)  ^ (i==k);
        System.out.println("result03 = "+ result03);

        boolean result04 = !(i>j);
        System.out.println("result04 ="+result04);

        //运算符短路
        int a = 10;
        int b = 20;
        boolean result05 = (++a<100) ||(++b>10);
        System.out.println("result05 = "+result05);
        System.out.println("a = "+a);
        System.out.println("b = "+b);





    }
}
