package com.CustomSerialization;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 *自定义类 实现writable 接口
 * */
public class CarInfo implements Writable {
    //定义构造器属性
    private String car="";
    private Double avgSpeed=0.0;
    private Double totalKm=0.0;
    //实现序列化 反序列化方法
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(car);
        dataOutput.writeDouble(avgSpeed);

        dataOutput.writeDouble(totalKm);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.car=dataInput.readUTF();
        this.avgSpeed= dataInput.readDouble();
        this.totalKm= dataInput.readDouble();
    }




    @Override
    public String toString() {
        return "CarInfo{" +
                "car='" + car + '\'' +
                ", avgSpeed=" + avgSpeed +
                ", totalKm=" + totalKm +
                '}';
    }

    //定义空构造
    public CarInfo() {
    }


    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public Double getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(Double avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public Double getTotalKm() {
        return totalKm;
    }

    public void setTotalKm(Double totalKm) {
        this.totalKm = totalKm;
    }
}
