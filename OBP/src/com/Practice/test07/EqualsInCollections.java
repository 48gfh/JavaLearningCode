package com.Practice.test07;

import com.Practice.test06.Employee;

import java.util.*;

//equals()在集合中的使用
public class EqualsInCollections {
    public static void main(String[] args) {
        Employee e1 = new Employee(101,"张三","j技术部");
        Employee e2 = new Employee(102,"李四","销售部");
        Employee e3 = new Employee(103,"王五","人事部");
        Employee e4 = new Employee(1003, "王五", "人事部");

        System.out.println("在List中的运用");
        List<Employee> employeeList =new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        System.out.println("List大小"+employeeList.size());
        System.out.println("List包含e2"+employeeList.contains(e2));
        System.out.println("e2在List中的索引"+employeeList.indexOf(e3));


        System.out.println("在Set中使用");
        Set<Employee> employeeSet= new HashSet<>();
        employeeSet.add(e1);
        employeeSet.add(e2);//不会被添加，因为equals()会返回true
        employeeSet.add(e3);
        employeeSet.add(e4);
        System.out.println("Set大小"+employeeSet.size());
        System.out.println("Set包含e1"+employeeSet.contains(e1));
        System.out.println("Set包含e2"+employeeSet.contains(e2));

        System.out.println("在Map中使用");
        

    }
}
