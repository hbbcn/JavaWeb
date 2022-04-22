package com.atguigu.dao;

import com.atguigu.mybatis.Employee;


import java.util.List;

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public List<Employee> getEmps();

    public Long addEmp(Employee employee);

//    public void getPageByProcedure(Page page);

}
