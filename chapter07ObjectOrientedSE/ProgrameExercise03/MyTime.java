package com.learning.chapter07ObjectOrientedSE.ProgrameExercise03;
/**
*类的成员变量与方法、构造方法 在程序中经常要对时间进行操作但是并没有时间类型的数据。
 * 那么我们可以自己实现一个时间类来满足程序中的需要。
 * 定义名为MyTime的类其中应有三个整型成员时hour分minute秒second为了保证数据的安全性这三个成员变量应声明为私有。
 * 为MyTime类定义构造方法以方便创建对象时初始化成员变量。 再定义diaplay方法用于将时间信息打印出来。
 * 为MyTime类添加以下方法 addSecond(int sec) addMinute(int min) addHour(int hou) subSecond(int sec) subMinute(int min) subHour(int hou) 分别对时、分、秒进行加减运算
*
*/
public class MyTime {
    private int hour;
    private int minute;
    private int second;

    //打印时间信息
    public void display(){
        System.out.println("时"+getHour()+"分"+getMinute()+"秒"+getSecond());
    }
    //构建空构造器
    public MyTime(){

    }
    //
    public MyTime(int h,int m,int s){
        this.hour=h;
        this.minute=m;
        this.second=s;
    }
    //对时间进行减法运算


    //对时间进行加法运算
    public void addHour(int hou){
        this.hour+=hou;
    }
    public void addMinuter(int min){
        this.minute+=min;
    }
    public void addSecond(int Sec){
        this.minute+=Sec;
    }

    public int getMinute() {
        return minute;
    }

    public int getHour() {
        return hour;
    }

    public int getSecond() {
        return second;
    }


}
