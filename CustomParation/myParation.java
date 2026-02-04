package com.CustomParation;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * 自定义分区需要创建类继承Paration并重写getParation方法，在该方法的控制数据分区的策略
 * 然后在Driver代码中通过设置“job.setPartitionerClass(CustomPartitioner.class)”来使用自
 * 定义分区，另外还需要根据自己定义分区的个数在Driver代码中设置对应的ReduceTask个数，否则
 * MapReduce会使用默认Reduce Task为1，导致自定义分区器不起作用或者报错。
 * */
public class myParation extends Partitioner<Text, IntWritable> {

    @Override
    public int getPartition(Text text, IntWritable intWritable, int i) {
        String key = text.toString();
        if(key.equals("hdfs")||key.equals("hadoop")){
            return 0;
        }else if(key.equals("hello")){
            return 1;
        }
        return 2;
    }
}
