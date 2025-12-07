package com.Practices;

import java.io.*;

/**
 * 定义一个User类（包含name 和 age字段），使用ObjectOutputStream将一个User对象写入文件(user.dat)
 * 再用ObjectputStream读取并打印
 * */
public class test04 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user1 = new User("李四",18);
        User user2 = new User("王二",34);
        User user3 = new User("张三",34);
        //写入
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("D:\\Desktop\\testD\\User.txt")));
        objectOutputStream.writeObject(user1);
        objectOutputStream.writeObject(user2);
        objectOutputStream.writeObject(user3);
        System.out.println("写入完毕");
        objectOutputStream.flush();
        objectOutputStream.close();
        //读取
        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(new File("D:\\Desktop\\testD\\User.txt")));
        User user=(User) objectInputStream.readObject();
        System.out.println(user1.getName()+"\t"+user1.getAge());
        System.out.println(user2.getName()+"\t"+user2.getAge());
        System.out.println(user3.getName()+"\t"+user3.getAge());
        System.out.println("读取完毕");
        objectInputStream.close();

    }
}
class User implements Serializable {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}