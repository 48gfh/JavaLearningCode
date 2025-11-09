package com.Practice.test06;

import java.util.Objects;

/**
 * 重写equals()后的使用
 * */
public class Employee {
    private int id;
    private String name;
    private String department;


    //重写toString()方法
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    //重写equals()方法
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name) && Objects.equals(department, employee.department);
    }


    //重写hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id, name, department);
    }

    // 构造器
    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
}
