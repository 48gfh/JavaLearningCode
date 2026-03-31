package com.learning.chapter07ObjectOrientedSE.example01;



public class TestPerson {
    //测试类：一般我们在测试类中去编写业务逻辑代码
    public static void main(String[] args) {
        //创建一个具体的对象:Person类的对象
        person p1 = new person();
        //参照类的模板，给对象进行赋值
        p1.name="zhangsan";
        p1.age=18;
        p1.height=85;

        //对属性进行访问
        System.out.println(p1.name);
        System.out.println(p1.age);
        System.out.println(p1.height);

        //对类的方法进行调用
        p1.eat();
        p1.sleep("huaibei");
        String s1=p1.introduce();
        System.out.println(s1);

        //调用构造器
        person p2 = new person("lili",19,183);
        System.out.println(p2.height);


        //匿名对象 没有名字的对象
        new person().age=18;
        new person().name="ergou";


    }
}
