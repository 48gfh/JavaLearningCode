package com.SortingCase;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
/**
 *自定义排序
 * Order中通过实现WritableComparable接口，重写序列化和反序列化方法 以及compareTO方法
 * 实现对消费价格排序，然后MapReduce输出数据的Key为Order对象，输出Value为数据本身即可。
 * */
public class Order implements WritableComparable<Order> {
    private String orderID;
    private  String dt;
    private  String productName;
    private  int amount;
    private  double totalCost;

    //实现序列化
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(orderID);
        dataOutput.writeUTF(dt);
        dataOutput.writeUTF(productName);
        dataOutput.writeInt(amount);
        dataOutput.writeDouble(totalCost);
    }

    //实现反序列化
    @Override
    public void readFields(DataInput dataInput) throws IOException {
        orderID=dataInput.readUTF();
        dt= dataInput.readUTF();
        productName= dataInput.readUTF();
        amount= dataInput.readInt();
        totalCost=dataInput.readDouble();
    }


    @Override
    public int compareTo(Order o) {
        //按照总价格倒叙排序
        if (this.totalCost > o.totalCost) {
            return -1;
        } else if (this.totalCost < o.totalCost) {
            return 1;
        } else {
            //二次排序 按照销售数量进行二次进行排序
            if(this.amount>o.amount){

            } else if (this.amount > o.amount) {
                return  -1;
            } else if (this.amount<o.amount) {
                return 1;
            }
                return 0;


        }
    }



    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", dt='" + dt + '\'' +
                ", productName='" + productName + '\'' +
                ", amount=" + amount +
                ", totalCost=" + totalCost +
                '}';
    }

    //无参构造方法
    public Order() {
    }

    //有参构造方法
    public Order(String orderID, String dt, String productName, int amount, double totalCost) {
        this.orderID = orderID;
        this.dt = dt;
        this.productName = productName;
        this.amount = amount;
        this.totalCost = totalCost;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
