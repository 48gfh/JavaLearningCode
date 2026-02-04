package com.CustomParation;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class myMap extends Mapper<LongWritable, Text,Text, IntWritable> {
    //设置map task 返回的key
    Text returnkey = new Text();
    //设置map task返回value的值
    IntWritable returnValue = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        //获取一行数据
        String line = value.toString();
        String[] split=line.split(" ");
        //遍历切分结果，写出
        for (String s : split) {
            returnkey.set(s);
            context.write(returnkey,returnValue);
        }

    }
}
