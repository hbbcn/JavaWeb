package com.atguigu.dao;

import com.atguigu.mybatis.Employee;
import org.apache.ibatis.annotations.Select;

/**
 *@ClassName EmployeeMapperAnnotation
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/16 11:20
 *@Version 1.0
 */
public interface EmployeeMapperAnnotation{

    @Select("select * from tb_employee where id=#{id}")
    public Employee getEmpById(Integer id);
}

