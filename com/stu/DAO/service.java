package com.stu.DAO;

import com.stu.DAO.impl.EmpDaoImpl;

public class service {
    public static void main(String[] args) {
        System.out.println(new EmpDaoImpl().deleteByEmpno(7934));
    }
}
