package com.ManagerEmpSystem.Imple;

import com.ManagerEmpSystem.pojo.Emp;

import java.util.List;

public interface EmpDao {
    //向Emp表中增加数据
    int addEmp(Emp emp);
    //向Emp表中删除员工信息
    int deleteEmp(int empnp);
    //查看Emp表中所有员工的信息
    List<Emp> findALL();
    //修改Emp表员工信息，依据员工编号
    int updateEmp(Emp emp);
}
