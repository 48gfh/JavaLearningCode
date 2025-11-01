package com.LearningObjectOrientedExercisesCollection.LP11;

public class SomePackageClass {
    public void test(){
       PackageClass pc =  new PackageClass();
        System.out.println(pc.packageFileId);
        pc.packageMethod();
    }

    public static void main(String[] args) {
        new SomePackageClass().test();
    }
}
