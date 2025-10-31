package com.LearningObjectOrientedExercisesCollection.LP03;
/**
 * static 修饰方法
 * */
public class Demo {
    int id;
    static int Sid;

    public void a(){
        System.out.println(id);
        System.out.println(Sid);
        System.out.println("--------------a");
    }
    //static与public都是修饰符，没有先后顺序
    static public void b(){
        //静态方法中无法使用this关键字
        //System.out.println(this.id);
        System.out.println(Sid);
        System.out.println("------------b");

    }

    public static void main(String[] args) {
        Demo d = new Demo();
        //非静态方法可以用对象名和方法名去调用
        d.a();
        //静态方法可以用 对象名.方法名调用 也可以 类名.方法名（推荐）
        Demo.b();
        d.b();

    }

}
