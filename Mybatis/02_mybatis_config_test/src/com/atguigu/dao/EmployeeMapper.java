package com.atguigu.dao;

import com.atguigu.mybatis.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    //返回一条记录
    public Map<String,Object> getEmpByIdResultMap(Integer id);

    //模糊查询，查询多条记录
    public List<Employee> getEmpByNameLike(String name);

    public Employee getEmpByIdAndName(@Param("id") Integer id,  @Param("name") String name);

}
