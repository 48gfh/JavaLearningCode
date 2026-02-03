package com.CustomSerialization;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class TCSDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        //获取配置信息及job对象
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        //设置Driver程序对应的jar/类
        job.setMapperClass(TCSMap.class);
        job.setReducerClass(TCSReduce.class);

        //设置Mapper输出的key和 valuel类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(CarInfo.class);

        //设置输出输入与输出路径
        FileInputFormat.setInputPaths(job,new Path("E:\\Code_Repositories\\BigDataLea\\HADuntitled\\Data\\car.txt"));
        FileOutputFormat.setOutputPath(job,new Path("E:\\Code_Repositories\\BigDataLea\\HADuntitled\\Output\\output01"));

        //运行任务 运行成功返回true
        boolean flag = job.waitForCompletion(true);
        if (flag) {
            System.out.println("任务运行成功");
        }else {
            System.out.println("任务运行失败");
        }
    }
}
