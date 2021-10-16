package com.atguigu.dao;

import com.atguigu.mybatis.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@ClassName EmployeeMapperDynamicSQL
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/18 15:00
 *@Version 1.0
 */
public interface EmployeeMapperDynamicSQL{

    public List<Employee> getEmpsByConditionIf(Employee employee);

    public List<Employee> getEmpsByConditionTrim(Employee employee);

    public List<Employee> getEmpsByConditionChoose(Employee employee);

    public void updateEmp(Employee employee);

    //查询员工id在给定的集合中
    public List<Employee> getEmpsConditionForeach(@Param("ids") List<Integer> ids);

    //批量进行保存员工信息
    public void addEmps(@Param("emps") List<Employee> emps);

    public List<Employee> getEmpsTestInnerParameter(Employee e);
}

