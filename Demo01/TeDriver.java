package com.CustomeCombine.Demo01;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class TeDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        //获取配置信息以及job对象
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);
        //设置Driver程序对应的jar/类
        job.setJarByClass(TeDriver.class);

        //设置mapper和reduce
        job.setMapperClass(TeMap.class);
        job.setReducerClass(TeReduce.class);

        job.setMapOutputKeyClass(Temperature.class);
        job.setMapOutputValueClass(Temperature.class);

        job.setOutputKeyClass(Temperature.class);
        job.setOutputValueClass(NullWritable.class);

        //设置数据输入与数据路径
        FileInputFormat.setInputPaths(job,new Path("E:\\Code_Repositories\\BigDataLea\\HADuntitled\\Data\\weather.txt"));
        FileOutputFormat.setOutputPath(job,new Path("E:\\Code_Repositories\\BigDataLea\\HADuntitled\\Output\\OPtemCustRESULT"));
        //设置自定义分区器
        job.setPartitionerClass(TemperatureParation.class);
        //设置Task任务为3
        job.setNumReduceTasks(3);
        boolean flag = job.waitForCompletion(true);
        if (flag) {
            System.out.println("运行成功");
        }else {
            System.out.println("运行失败");
        }
    }
}
