package com.CusOututFormat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class StuDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);
        //设置Driver对应的类
        job.setJarByClass(StuDriver.class);
        //设置Map Reduce 对应的类
        job.setMapperClass(StuMap.class);
        job.setReducerClass(StuReduce.class);
        //设置Map K,V
        job.setMapOutputKeyClass(StudentInfo.class);
        job.setMapOutputValueClass(Text.class);

        //设置最终输出kv类型
        job.setOutputKeyClass(StudentInfo.class);
        job.setOutputValueClass(NullWritable.class);

        //设置自定义OutputFormat
        job.setOutputFormatClass(StuCusOutPutFormat.class);

        //设置输入与输出路径
        FileInputFormat.setInputPaths(job,new Path("E:\\Code_Repositories\\BigDataLea\\HADuntitled\\Data\\scorce.txt"));
        //使用了自定义输出类，结果数据会写入自定义输出类中指定的路径，这里设置的目录只是最后写出的_success标
        FileOutputFormat.setOutputPath(job,new Path("E:\\Code_Repositories\\BigDataLea\\HADuntitled\\Output\\reCusSCORE"));

        boolean flag = job.waitForCompletion(true);
        if (flag) {
            System.out.println("任务成功");
        }else {
            System.out.println("任务失败");
        }
    }
}
