package com.ObjectOrientedExercisesCollection.title04;

import java.util.Scanner;

public class TestBankAcount {

    public static void main(String[] args) {
        BankAccount bk=new BankAccount();
        //调用存款方法
        double money1=deposit();
        bk.setBalance(money1);
        //调用取钱方法
        double money2=withDraw();
        bk.setBalance(bk.getBalance()-money2);
        System.out.println("已取"+money2+"余额"+bk.getBalance());


    }

    //实现存款方法
    public static  double deposit(){
        Scanner sc =new Scanner(System.in);
        System.out.println("输入存款额度");
        double inputMoney = sc.nextDouble();
        return inputMoney;
    }
    //实现取钱方法
    public static  double withDraw(){
        Scanner sc =new Scanner(System.in);
        System.out.println("输入取款额度");
        double outputMoney = sc.nextDouble();
        return outputMoney;
    }
}
