package com.atguigu.rest.controller;

import com.atguigu.rest.bean.Employee;
import com.atguigu.rest.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Collection;

/**
 *@ClassName EmployeeController
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/27 17:46
 *@Version 1.0
 */
@Controller
public class EmployeeController{

    @Autowired
   private EmployeeDao employeeDao;

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        Collection<Employee> employeeList = employeeDao.getAll();
        model.addAttribute("employeeList",employeeList);
        return "employee_list";
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){

        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String getEmployeeById(Model model,@PathVariable("id") Integer id){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        return "employee_update";
    }

    @RequestMapping(value = "/employee" ,method = RequestMethod.PUT)
    public String update(Employee employee){

        employeeDao.save(employee);
        return "redirect:/employee";
    }
}

