package com.LearningObjectOrientedExercisesCollection.LP12;

import java.security.spec.RSAOtherPrimeInfo;

/**
 * protect  保护权限 本包 本类 子类 接可调用
 * */
public class Animal {
    protected String special; //保护属性
    protected void protectedMethod(){
        System.out.println("保护方法");
    }
    public void publicMthod(){
        protectedMethod(); //本类中可以调用

    }
}
