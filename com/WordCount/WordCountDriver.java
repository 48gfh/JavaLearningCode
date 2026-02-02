package com.WordCount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class WordCountDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        if(args.length!=2){
            System.out.println("输入输入路径和输出路劲参数");
            System.exit(1);
        }
        //1 获取配置信息以及job对象
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        //2 设置Driver程序对应的jar/类
        job.setJarByClass(WordCountDriver.class);

        //3 设置Mapper和Reduce对应的类
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReduce.class);

        //4 设置Mapper输出Key value 类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputKeyClass(IntWritable.class);

        //5 设置最终输出的Key Value类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //6 设置数据输入与结果输出
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        //7 运行任务成功返回true
        boolean success = job.waitForCompletion(true);
        if (success) {
            // 任务执行成功的逻辑
            System.out.println("任务执行成功");
        } else {
            // 任务执行失败的逻辑
            System.out.println("任务执行失败");
        }

    }
}
