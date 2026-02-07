package com.CustomeCombine.Demo01;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
/**
 * 实体温度类  2024-06-02  38
 * */
public class Temperature implements WritableComparable<Temperature> {
    private String Year;
    private String month;
    private String day;
    private Integer temp;

    @Override
    public String toString() {
        return "Temperature{" +
                "Year='" + Year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                ", temp=" + temp +
                '}';
    }
    //两个对象比较数据
    @Override
    public int compareTo(Temperature o) {
       //按照相同的年月、温度降序排序
        int yearCompare= this.getYear().compareTo(o.getYear());
        int monthCompare = this.getMonth().compareTo(o.getMonth());
        if(yearCompare==0){
            if(monthCompare==0){
                //按照温度降序排序
                return this.temp>o.temp?-1:1;
            }
            return  monthCompare;
        }
        return yearCompare;
    }

    //序列化与反序列化
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.Year);
        dataOutput.writeUTF(this.month);
        dataOutput.writeUTF(this.day);
        dataOutput.writeInt(this.temp);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        Year=dataInput.readUTF();
        month=dataInput.readUTF();
        day=dataInput.readUTF();
        temp=dataInput.readInt();
    }


    public Temperature() {
    }

    //有参构造
    public Temperature(String year, String month, String day, Integer temp) {
        Year = year;
        this.month = month;
        this.day = day;
        this.temp = temp;
    }



    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }
}
