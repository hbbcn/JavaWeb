package com.atguigu.dao;

import com.atguigu.mybatis.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface DepartmentMapper {
    public Department getDeptById(Integer id);

    //查询出对应部门的所有的员工信息
    public Department getDeptByIdPlus(Integer id);

    //分步查询部门对应的所有员工信息
    public Department getDeptByIdStep(Integer id);

}
