package com.Practice.test06;

public class TestEmployee {
    public static void main(String[] args) {
        Employee e1 = new Employee(001,"zhangsan","销售");
        Employee e2 = new Employee(1002,"zhangsan","技术");
        Employee e3 =new Employee(1002,"李四","技术部");
        System.out.println("====================equals()====================");
        System.out.println(e1.equals(e2));
        System.out.println(e1.equals(e3));

        System.out.println("====================运算符比较====================");
        System.out.println(e1==e2);
        //与null比较
        System.out.println(e1.equals(null));

    }
}
