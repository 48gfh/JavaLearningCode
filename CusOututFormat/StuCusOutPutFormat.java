package com.CusOututFormat;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
/**
 *自定OutPutFormat以及使用自定义输出格式步骤
 * 1、自定义类继承FileOutPutFormar并实现getRecordWriter方法
 * 2、在getRecordWriter方法中自定义RecordWriter类，该类需要继承RecordWriter对象实现对应数据写出逻辑h
 * 3、在Driver中设置“job.setOutputFormatClass(YourOutputFormat.class)”使用自定义outputFormat。
 * */
public class StuCusOutPutFormat extends FileOutputFormat<StudentInfo, NullWritable> {
    //获取RecordWritrer对象
    @Override
    public RecordWriter<StudentInfo, NullWritable> getRecordWriter(TaskAttemptContext job) throws IOException, InterruptedException {
        //根据job创建文件输出流，需要传入job
        myRecord myRecord = new myRecord(job);
        return  myRecord;
    }

}
class myRecord extends RecordWriter<StudentInfo,NullWritable>{
    private FSDataOutputStream passOutputStream;
    private FSDataOutputStream failPutputStream;

    //根据job来创建文件输出流
    public myRecord(TaskAttemptContext job) throws IOException {
        FileSystem fileSystem = FileSystem.get(job.getConfiguration());
        //创建及格成绩输出流
        passOutputStream = fileSystem.create(new Path("E:\\Code_Repositories\\BigDataLea\\HADuntitled\\Output\\result\\resultPASS.txt"));
        //创建不及格成绩输出流
        failPutputStream=fileSystem.create(new Path("E:\\Code_Repositories\\BigDataLea\\HADuntitled\\Output\\result\\resultFAILL.txt"));

    }

    @Override
    public void write(StudentInfo studentInfo, NullWritable nullWritable) throws IOException, InterruptedException {
        int score = studentInfo.getScore();
        String name=studentInfo.getName();
        // 构建输出字符串：姓名,分数
        String output = name + "," + score + "\n";
        if(score>80){
            passOutputStream.write(output.getBytes());
        }else {
            // 将字符串转换为字节数组写入
            failPutputStream.write(output.getBytes());
        }
    }

    @Override
    public void close(TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        IOUtils.closeStreams(passOutputStream,failPutputStream);

    }
}
