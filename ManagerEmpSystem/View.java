package com.ManagerEmpSystem;

import com.ManagerEmpSystem.Imple.DeptDao;
import com.ManagerEmpSystem.Imple.DeptDaoImple;
import com.ManagerEmpSystem.Imple.EmpDao;
import com.ManagerEmpSystem.Imple.EmpDapImple;
import com.ManagerEmpSystem.pojo.Dept;
import com.ManagerEmpSystem.pojo.Emp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class View {
    static Scanner scanner= new Scanner(System.in);
    static EmpDao empDao = new EmpDapImple();
    static DeptDao deptDao = new DeptDaoImple();
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");


    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        while (true){
            System.out.println("请输入登录选项");
            System.out.println("=========================");
            System.out.println("1、查找所有员工信息");
            System.out.println("2、查看所有部门信息");
            System.out.println("3、根据工号删除员工信息");
            System.out.println("4、根据工号修改员工信息");
            System.out.println("5、增加员工信息");
            System.out.println("6、增加部门信息");

            int choice = scanner.nextInt();
            switch (choice){
                default:
                    System.out.println("请在1-7之间选择");
                case 1:
                    System.out.println("1、查找所有员工信息");
                    case1();
                    break;
                case 2:
                    System.out.println("2、查看所有部门信息");
                    case2();
                    break;
                case 3:
                    System.out.println("3、根据工号删除员工信息");
                    case3();
                    break;
                case 4:
                    System.out.println("4、根据工号修改员工信息");
                    case4();
                    break;
                case 5:
                    System.out.println("5、增加员工信息");
                    case5();
                    break;
                case 6:
                    System.out.println("6、增加部门信息");
                    case6();
                    break;
            }
        }
    }



    private static void case6() {
        System.out.println("请输入部门编号");
        int deptno = scanner.nextInt();
        System.out.println("请输入部门名字");
        String dname= scanner.next();
        System.out.println("请输入部门地址");
        String loc = scanner.next();
        Dept dept= new Dept(deptno,dname,loc);
        System.out.println("影响数据"+deptDao.addDept(dept));

    }

    //增加员工信息
    private static void case5() {
        System.out.println("请输入员工编号");
        int empno = scanner.nextInt();
        System.out.println("请输入员工姓名");
        String ename = scanner.next();
        System.out.println("请输入员工职位");
        String job =scanner.next();
        System.out.println("请输入员工上级");
        int mgr = scanner.nextInt();
        System.out.println("请输入员工入职日期,格式为yyyy-MM-dd");
        Date hiredate =null;
        try {
            hiredate=simpleDateFormat.parse(scanner.next());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("请输入员工工资");
        double sal =scanner.nextDouble();
        System.out.println("请输入员工补助");
        double comm=scanner.nextDouble();
        System.out.println("请输入员工部门号");
        int deptno =scanner.nextInt();
        Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm,deptno);
        System.out.println("影响数据"+empDao.addEmp(emp));

        
    }

    private static void case4() {
        System.out.println("请输入员工编号");
        int empno = scanner.nextInt();
        System.out.println("请输入员工姓名");
        String ename = scanner.next();
        System.out.println("请输入员工职位");
        String job =scanner.next();
        System.out.println("请输入员工上级");
        int mgr = scanner.nextInt();
        System.out.println("请输入员工入职日期,格式为yyyy-MM-dd");
        Date hiredate =null;
        try {
            hiredate=simpleDateFormat.parse(scanner.next());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("请输入员工工资");
        double sal =scanner.nextDouble();
        System.out.println("请输入员工补助");
        double comm=scanner.nextDouble();
        System.out.println("请输入员工部门号");
        int deptno =scanner.nextInt();
        Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm,deptno);
        System.out.println(empDao.updateEmp(emp));
    }

    private static void case3() {
        System.out.println("请输入您要删除的员工编号");
        int deleteNumber= scanner.nextInt();
        int flag=empDao.deleteEmp(deleteNumber);
        if (flag>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

    }

    private static void case2() {
        List<Dept> deptList = deptDao.findAll();
        for (Dept dept : deptList) {
            System.out.println(dept);
        }
    }

    private static void case1() {
        List<Emp> empList = empDao.findALL();
        for (Emp emp : empList) {
            System.out.println(emp);
        }

    }
}
