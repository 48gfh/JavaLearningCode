package com.CustomeCombine.Demo01;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class TeReduce extends Reducer<Temperature,Temperature,Temperature, NullWritable> {
    int cnt;
    String year;
    String month;
    String day;

    //用来标记某个分区是否处理过相同日期数据， map 中的key为年月 value <day 年月技术>
    HashMap<String,String> floatMap = new HashMap<>();
    //相同的Key为一组，这里需要将分区所有的数据拿在一起最后比较获取日期最大的数据
    ArrayList<Temperature> list = new ArrayList<>();

    @Override
    protected void reduce(Temperature key, Iterable<Temperature> values, Reducer<Temperature, Temperature, Temperature, NullWritable>.Context context) throws IOException, InterruptedException {
        Iterator<Temperature> iterator = values.iterator();
        while (iterator.hasNext()){
            Temperature next = iterator.next();
            list.add(next);
        }
        //最后比较得到温度较高的两条数据 日期不能相同
        for (Temperature temperature : list) {
            year= temperature.getYear();
            month=temperature.getMonth();
            day= temperature.getDay();
            //第一次处理某一个年月日数据
            if(!floatMap.containsValue(year+"-"+month)){
                cnt=1;
                context.write(temperature,NullWritable.get());
                floatMap.put(year+"-"+month,day+","+cnt);
            }
            //如果flagMap中包含年月数据，判断value是不是同一日期，是同一日期不输出，不是同一日期输出数据
            if(floatMap.containsKey(key+"-"+month)&&!day.equals(floatMap.get(year+"-"+month).split(",")[0])){
                //获取当前月记录的条数
                cnt=Integer.valueOf(floatMap.get(year + "-" + month).split(",")[1]);
                cnt +=1;
                //说明当前年月下不够两条数据
                if(cnt==2){
                    context.write(temperature,NullWritable.get());
                }
                floatMap.put(year+"-"+month,day+","+cnt);
            }


        }

    }
}
