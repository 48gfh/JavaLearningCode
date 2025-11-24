package com.Genericity;

import java.util.ArrayList;

/**
 * test02 只是一个普通的类
 * test02<E> 就是一个泛型类
 * <> 里面就是一个参数类型，但是这个类型现在不确定只是相当于一个占位 需要在实列化中指出
 * 但是这个类类型必须是引用数据类型，而不是基本数据类型
 * */
public class test02 <E> {
    E age;
    String name;
    String sex;

    public void a(E n){
        System.out.println("方法a的描述");
    }
    public void b(E[] m){
        System.out.println("方法b的描述");
    }

    public test02() {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    class Te {
        public static void main(String[] args) {
            //对test02进行实列化 实例化的时候不指定泛型：如果实列化的实列化的时候不明确的指定类的泛型，那么认为此泛型是Object
            test02 t1 = new test02();
            t1.a("test");
            t1.a(34);
            t1.a("gfyhusfgedyusiaodfgyuoafed");
            t1.b(new String[]{"a","b","c"});

            //实列化的时候指定泛型 ---> 推荐方式
            test02<Integer> t2 = new test02<Integer>();
            t2.a(7878);
            t2.a(6767);


        }
    }
}

