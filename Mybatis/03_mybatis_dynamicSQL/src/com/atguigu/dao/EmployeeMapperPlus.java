package com.atguigu.dao;

import com.atguigu.mybatis.Employee;

import java.util.List;

public interface EmployeeMapperPlus {

    public Employee getEmpById(Integer id);

    public Employee getEmpAndDept(Integer id);

    public Employee getEmpByIdStep(Integer id);

    //按照部门查出所有员工
    public List<Employee> getEmpByDeptId(Integer deptId);

}
