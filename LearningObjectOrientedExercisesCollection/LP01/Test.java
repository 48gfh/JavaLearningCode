package com.LearningObjectOrientedExercisesCollection.LP01;
//static 修饰属性
public class Test {
    int id;
    static int Sid;

    public static void main(String[] args) {
        //创建一个Test类的具体的对象
        Test t1=new Test();
        t1.id=10;
        t1.Sid=10;

        Test t2 = new Test();
        t2.id=20;
        t2.Sid=20;

        Test t3 = new Test();
        t3.id=30;
        t3.Sid=30;


        //读取属性的值
        System.out.println(t1.id);
        System.out.println(t2.id);
        System.out.println(t3.id);
        System.out.println("---------------------------------");
        System.out.println(t1.Sid);
        System.out.println(t2.Sid);
        System.out.println(t3.Sid);
    }

}
