package com.CustomSerialization;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


import java.io.IOException;
import java.text.DecimalFormat;

public class TCSReduce extends Reducer<Text,CarInfo,Text,CarInfo> {
    //设置输出value
    CarInfo carInfo = new CarInfo();

    @Override
    protected void reduce(Text key, Iterable<CarInfo> values, Reducer<Text, CarInfo, Text, CarInfo>.Context context) throws IOException, InterruptedException {
        //定义当前Key对应的数据条数
        int cnt = 0;
        //定义总速度
        double tptalSpeed =0;
        //定义平均速度
        double avgSpeed = 0;
        //定义总路程
        double totalKm = 0;

        for (CarInfo value : values) {
            cnt+=1;
            tptalSpeed+= value.getAvgSpeed();
            totalKm+= value.getTotalKm();
        }
        //创建DecimalFormat对象 指定格式为保留两位小数
        DecimalFormat df = new DecimalFormat();
        //格式化平均速度
        avgSpeed=Double.valueOf(df.format(tptalSpeed/cnt));

        carInfo.setCar(key.toString());
        carInfo.setAvgSpeed(avgSpeed);
        carInfo.setTotalKm(totalKm);

        context.write(key,carInfo);
    }
}
