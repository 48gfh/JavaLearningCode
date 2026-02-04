package com.SortingCase;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SCMap extends Mapper<LongWritable, Text,Order,Text> {

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Order, Text>.Context context) throws IOException, InterruptedException {
        //读取每行数据
        //1001        2024-03-10        商品A        2        100
        String line =value.toString();

        //解析数据
        String[] parts =line.split("    ");
        String orderID = parts[0];
        String dt = parts[1];
        String productName= parts[2];
        int amount = Integer.parseInt(parts[3]);
        double totalCost = Double.parseDouble(parts[4]);

        //创建Order对象
        Order order=new Order(orderID,dt,productName,amount,totalCost);

        //输出键值对
        context.write(order,value);
    }
}
