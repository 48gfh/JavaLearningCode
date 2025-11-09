package com.FinalPractice.test02;

public class Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal(String name) {
        this.name = name;
    }

    //普通方法  可以被子类定义重写
    public void makeSound(){
        System.out.println(name+"发声");
    }
    public final void  breath(){
        System.out.println("动物会呼吸");
    }

}
