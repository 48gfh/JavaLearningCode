package com.FinalPractice.test02;

public class Dog extends  Animal{

    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName()+"汪汪");
    }
}
