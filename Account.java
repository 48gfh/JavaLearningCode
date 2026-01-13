package com.chapter02;

import java.io.Serializable;

public class Account  implements Serializable {
    private int aid;
    private String username;
    private String password;
    private int money;




    public Account() {
    }
    public Account(int aid, String username, String password, int money) {
        this.aid = aid;
        this.username = username;
        this.password = password;
        this.money = money;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
