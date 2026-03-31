package com.learning.chapter07ObjectOrientedSE.example03;
//定义一个女孩类
public class Girl {
    private int age;
    //读取年龄
    public int getAge() {
        return age;
    }
    //设置年龄
    public void setAge(int age) {
        if(age >=18 ){
            this.age=18;
        }else {
            this.age=age;
        }
    }

    //创建一个main方法，是程序入口
    public static void main(String[] args) {
        Girl  g1 = new Girl();
        //设置年龄
        g1.setAge(45);
        System.out.println(g1.getAge());
    }
}
