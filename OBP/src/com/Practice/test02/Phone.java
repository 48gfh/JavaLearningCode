package com.Practice.test02;

import java.util.Objects;

/**
 * equals()方法 以手机品牌为列
 * */
public class Phone {

    private String band;
    private double price;
    private int year;

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //构造器

    public Phone() {
    }

    public Phone(String band, double price, int year) {
        this.band = band;
        this.price = price;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Double.compare(price, phone.price) == 0 && year == phone.year && Objects.equals(band, phone.band);
    }


}
