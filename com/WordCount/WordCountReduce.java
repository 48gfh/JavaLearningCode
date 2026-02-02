package com.WordCount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;


public class WordCountReduce extends Reducer<Text, IntWritable,Text,IntWritable> {
    //创建写出value
    IntWritable total = new IntWritable();

    //每组key会调用一次
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        int sum=0;
        //累加计算   hadoop (1,1)
        for (IntWritable value : values) {
            sum+= value.get();
        }
        //设置当前key对应的value结果值
        total.set(sum);
        //结果写出
        context.write(key,total);
    }
}
