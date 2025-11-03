package com.Practice.test02;

public class TestPhone {
    public static void main(String[] args) {
        Phone p1 = new Phone("huawei",56.6,9999);
        Phone p2 = new Phone("huawei",56.6,9999);
        System.out.println(p1.equals(p2));
    }
}
