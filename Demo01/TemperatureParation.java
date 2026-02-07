package com.CustomeCombine.Demo01;

import org.apache.hadoop.mapreduce.Partitioner;

public class TemperatureParation extends Partitioner<Temperature,Temperature> {
    @Override
    public int getPartition(Temperature temperature, Temperature temperature2, int i) {
        String ym = temperature.getYear()+"-"+temperature.getMonth();
        return (ym.hashCode()&Integer.MAX_VALUE)%i;
    }
}
