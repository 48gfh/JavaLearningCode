package com.ObjectOrientedExercisesCollection.title04;
/**
 * 定义一个银行账户类（BankAccount），
 * 包含账户余额（balance）属性，实现存款（deposit）和取款（withdraw）方法。
 * */
public class BankAccount {
    private double balance;





    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }




    public BankAccount() {
    }

    public BankAccount(double balance) {
        this.balance = balance;
    }
}
