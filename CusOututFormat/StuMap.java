package com.CusOututFormat;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class StuMap extends  Mapper<LongWritable,Text,StudentInfo,Text> {
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, StudentInfo, Text>.Context context) throws IOException, InterruptedException {
        //读取数据并切割数据  zhangsan,20
        String[] parts = value.toString().split(",");

        String name = parts[0];
        int score = Integer.parseInt(parts[1]);
        //创建Order对象
        StudentInfo studentInfo = new StudentInfo(name,score);
        //输出键值对
        context.write(studentInfo,value);
    }
}
