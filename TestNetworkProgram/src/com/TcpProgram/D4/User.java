package com.TcpProgram.D4;

import java.io.Serializable;
/**
 * 封装User类
 * */
public class User implements Serializable {
    private static final long serialVersionID = 74382943424324L;
    private String name;
    private String password;



    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
