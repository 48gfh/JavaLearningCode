package com.CustomSerialization;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class TCSMap extends Mapper<LongWritable, Text,Text,CarInfo> {
    //设置输出Key
    Text outputkey = new Text();
    //设置输出的value
    CarInfo carInfo=new CarInfo();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, CarInfo>.Context context) throws IOException, InterruptedException {
        //切割数据
        String line =value.toString();
        String[] split = line.split(",");

        carInfo.setCar(split[1]);
        carInfo.setAvgSpeed(Double.valueOf(split[2]));
        carInfo.setTotalKm(Double.valueOf(split[3]));

        outputkey.set(split[1]);
        context.write(outputkey,carInfo);
    }
}
