package com.LearningObjectOrientedExercisesCollection.LP10;

public class Dog extends Aniaml{
    //子类重写父类方法

    //重写父类方法- 参数列表必须相同
    @Override
    public void makeSound() {
        System.out.println("汪汪叫");
    }
    //重写父类方法 返回类型可以是子类
    public void eat(String food){
        System.out.println("狗吃"+food);
    }

    public static void main(String[] args) {
        new Dog().eat("bond");
    }
}
