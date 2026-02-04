package com.CustomParation;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class myDriver  {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        //获取配置信息及job对象
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);
        //设置Driver程序对应的类
        job.setJarByClass(myDriver.class);

        //设置map reducer对应的类
        job.setMapperClass(myMap.class);
        job.setReducerClass(myReduce.class);

        //使用自定义分区器
        job.setPartitionerClass(myParation.class);

        //设置Reduce Task个数为3
        job.setNumReduceTasks(3);

        //设置Mapper输出Key  valuer 类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        //这只最终输出的K V
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //设置数据输入与输出路径路径
        FileInputFormat.setInputPaths(job,new Path("E:\\Code_Repositories\\BigDataLea\\HADuntitled\\Data\\data.txt"));
        FileOutputFormat.setOutputPath(job,new Path("E:\\Code_Repositories\\BigDataLea\\HADuntitled\\Output\\OutpuTest"));

        boolean flag = job.waitForCompletion(true);
        if (flag) {
            System.out.println("运行成功");
        }else {
            System.out.println("运行失败");
        }
    }
}
