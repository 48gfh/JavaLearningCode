package com.CustomeCombine.Demo01;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class TeMap extends Mapper<LongWritable, Text,Temperature,Temperature> {
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Temperature, Temperature>.Context context) throws IOException, InterruptedException {
        //2024-05-21  33
        String[] split = value.toString().split("    ");

        Integer temp = Integer.valueOf(split[1]);

        String year = split[0].split("-")[0];
        String month = split[0].split("-")[1];
        String day = split[0].split("-")[2];


        Temperature temperature = new Temperature(year,month,day,temp);
        context.write(temperature,temperature);
    }
}
