package com.stu.DAO.pojo;

import java.io.Serializable;

public class Dept implements Serializable {
    private  Integer deptno;
    private  String ename;
    private  String loc;

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", ename='" + ename + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }

    public Dept() {
    }

    public Dept(String ename, Integer deptno, String loc) {
        this.ename = ename;
        this.deptno = deptno;
        this.loc = loc;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}