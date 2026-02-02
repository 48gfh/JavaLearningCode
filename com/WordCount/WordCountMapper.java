package com.WordCount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
/**
 * LongWritable Map任务输入 Key 类型
 * Text Map任务输入值 value 类型
 * Text Map任务输出键 Key 类型
 * IntWritable Mao任务输出值 value 类型
 * */
public class WordCountMapper extends Mapper<LongWritable,Text,Text,IntWritable> {

    //设置map task 返回的key
    Text returnKey = new Text();
    //设置map task 返回的value
    IntWritable returnValue = new IntWritable(1);
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        //获取一行数据
        String line = value.toString();
        //切分单词
        String[] words = line.split(" ");
        //遍历切分结果
        for (String word : words) {
            returnKey.set(word);
            context.write(returnKey,returnValue);
        }

    }
}
