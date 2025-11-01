package com.LearningObjectOrientedExercisesCollection.LP09;

 class Aniaml {
    String name = "动物";

}
class Dog extends Aniaml{
     String name = "狗";
     public void printName(){
         System.out.println("子类name"+this.name);
         System.out.println("父类name"+super.name);
         System.out.println("直接name"+name);
     }

    public static void main(String[] args) {
        new Dog().printName();
    }
}
