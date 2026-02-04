package com.SortingCase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class SCDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        //设置Driver对应的jar/类
        job.setJarByClass(SCDriver.class);

        //设置Map和Reduce对应的类
        job.setMapperClass(SCMap.class);
        job.setReducerClass(SCReduce.class);

        //设置map输出的k v 类型、

        job.setMapOutputKeyClass(Order.class);
        job.setMapOutputValueClass(Text.class);



        //设置最终输出key value 类型
        job.setOutputKeyClass(Order.class);
        job.setOutputValueClass(NullWritable.class);

        //设置文件输入输出路径
        FileInputFormat.setInputPaths(job, new Path("E:\\Code_Repositories\\BigDataLea\\HADuntitled\\Data\\order.txt"));
        FileOutputFormat.setOutputPath(job,new Path("E:\\Code_Repositories\\BigDataLea\\HADuntitled\\Output\\SCputTEST"));

        boolean flag = job.waitForCompletion(true);
        if (flag) {
            System.out.println("任务成功");
        }else {
            System.out.println("任务失败");
        }
    }
}
