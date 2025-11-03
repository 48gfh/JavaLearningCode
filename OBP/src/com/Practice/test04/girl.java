package com.Practice.test04;

public class girl {
    String name;
    double weight;
    Mom m = new Mom(); //如果不进行调用对象的话默认初始值是 NULL 出现空指针异常

    public void add (int  a){
        System.out.println(a);
        System.out.println(a+100);
    }
    //谈恋爱的方法
    public  void love(boy b){
        System.out.println("男朋友名字"+b.name+"男朋友年龄是"+b.age);
    }

    public void wechat(){
        m.say();
    }

    public girl(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
}
