package com.stu.DAO.impl;

import com.stu.DAO.pojo.Emp;
//DAO Emp 接口代码
public interface EmpDao  {
    /**
     * 向数据库Emp表中增加一条数据
     * @param emp 要增加的数据封装成Emp类的对象
     * @return 成功则返回大于0 的整数，失败则返回0
     */
    int addEmp(Emp emp);

    /**
     * 依据员工工号删除员工信息方法
     * @param empno
     * @return 删除成功则返回大于0的整数,失败则返回0
     */
    int deleteByEmpno(int empno);
}
