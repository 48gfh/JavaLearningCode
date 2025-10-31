package com.LearningObjectOrientedExercisesCollection.LP04;


public class Test {
    //属性
    int a;
    static int sa;

    //方法
    public void  a(){
        {
            //普通块限制局部变量作用范围
            System.out.println("---a");
            System.out.println("这是普通块");
            int num=10;
            System.out.println(num);
        }
    }
    public static void b(){
        System.out.println("-------------b");
    }

    //构造块
    {
        System.out.println("这就是构造块");
    }

    //静态块
    static {
        //静态块中只能调用 静态属性 静态方法
        System.out.println("这就是静态块");
        System.out.println(sa);

    }



    public static void main(String[] args) {
        Test t1 =new Test();
        t1.a();
        Test t2 = new Test();
        t2.a();


    }
}
