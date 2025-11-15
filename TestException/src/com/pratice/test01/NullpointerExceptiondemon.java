package com.pratice.test01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student{
    String name;

    public String getName() {
        return name;
    }

    Student(String name){
        this.name=name;

    }
}


public class NullpointerExceptiondemon {
    //Map为泛型接口类型键为String 值为Student 并创建一个HashMap给repo
    private static final Map<String,Student> repo= new HashMap<>();
    static {
        repo.put("1001",new Student("Alice"));
        repo.put("1002",new Student("Bob"));
    }


    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        System.out.println("请输入学号");
        String id = sc.nextLine();
        try{
            Student st = repo.get(id);  //获取id可能为Null
            System.out.println("姓名="+st.getName());
        }catch (NumberFormatException e){ //把异常处理改为"提前判空的方式"，预防胜于捕获
            System.out.println("该学号不存在，捕获到空指针异常");
        }finally {
            sc.close();
        }

    }
}
