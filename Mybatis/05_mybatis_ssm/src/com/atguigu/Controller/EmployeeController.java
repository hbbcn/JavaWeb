package com.atguigu.Controller;

import com.atguigu.mybatis.Employee;
import com.atguigu.mybatis.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 *@ClassName EmployeeController
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/20 17:55
 *@Version 1.0
 */
@Controller
public class EmployeeController{

    @Autowired
    EmployeeService employeeService;
    @RequestMapping("/getemps")
    public String emps(Map<String,Object> map){

        List<Employee> emps = employeeService.getEmps();
        map.put("allEmps",emps);
        return "list";
    }

}

