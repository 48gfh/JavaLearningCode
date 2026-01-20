package com.ManagerEmpSystem.Imple;

import com.ManagerEmpSystem.pojo.Dept;

import java.util.List;

public interface DeptDao {
    //查询全部部门方法
    List<Dept> findAll();
    //增加部门的方法
    int  addDept(Dept dept);
}
