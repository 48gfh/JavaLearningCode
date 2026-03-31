package com.learning.chapter07ObjectOrientedSE.example01;

import javax.swing.text.html.parser.TagElement;

/**Person类- 人类-类名:见名知意
 * 发现类的共同部分可以分为：名词、动词
 * */
public class person {
    //名词 共同特性 - 属性 可以有成千上万个，但是我们只写与业务逻辑相关的部分即可
    String name;
    int age;
    double height;

    public void eat(){
        System.out.println("可以吃饭");
    }
    public void sleep(String add){
        System.out.println("睡觉在"+add);
    }
    public String introduce(){
        return "我的名字是"+name+"年龄是"+age+"身高是"+height;
    }

    //构造器：没有任何参数的构造器称为 -> 空构造器
    public person(){

    }
    /*
    * 当形参名字和属性名字重名的时候，会出现就近原则
    * 在要表示对象的属性前面加上this.来修饰，因为this代表的就是你创建的那个对象
    * */
    public person(String name,int age,double height){
        this.name=name;
        this.age= age;
        this.height=height;
    }
    public  person(String a,int b){
        name=a;
        age=b;
    }
}
