package com.FinalPractice.test02;

public class Test {
    public static void main(String[] args) {
        //final方法演示
        Dog dog=new Dog("小黑");
        dog.makeSound();
        //调用继承fianl方法
        dog.breath();

        //多态演示
        Animal a1 = new Animal("小白");
        a1.makeSound();
        a1.breath();
    }
}
