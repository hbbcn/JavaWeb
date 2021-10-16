package com.atguigu.test;

import com.atguigu.dao.EmployeeMapper;
import com.atguigu.dao.EmployeeMapperDynamicSQL;
import com.atguigu.mybatis.Department;
import com.atguigu.mybatis.Employee;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;
import org.junit.Test;

import javax.management.OperationsException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName MybatisTest01
 * @Description TODO
 * @Author HuangQingbin
 * @Date 2021/8/18 15:23
 * @Version 1.0
 */
public class MybatisTest01 {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Test
    public void testDynamicSql() throws IOException {

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
//            Employee employee = new Employee(1, "admin", null, null);
     /*       List<Employee> emps = mapper.getEmpsByConditionIf(employee);
              for (Employee emp : emps){
                System.out.println(emp);
            }*/
            //查询的时候如果某些条件没带可能sql拼装会有问题
            //1、给where 后面加上1=1
            //2、mybatis使用where标签来将所有的查询条件包括在内：
            //mybatis就会将where标签中拼装的sql多出来的and 或者 or 去掉
            //当and放在后面的时候就会出现问题d=#{id} and

      /*      List<Employee> emps = mapper.getEmpsByConditionTrim(employee);
             for (Employee emp : emps){
                System.out.println(emp);
            }*/
            //测试choose
        /*    List<Employee> emps = mapper.getEmpsByConditionChoose(employee);
            for (Employee emp : emps){
                System.out.println(emp);
            }*/

            //测试set
            /*mapper.updateEmp(employee);
            openSession.commit();*/

            List<Employee> emps = mapper.getEmpsConditionForeach(Arrays.asList(1, 2, 6, 8));
            for (Employee emp : emps) {
                System.out.println(emp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testBatchSave() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
            ArrayList<Employee> employees = new ArrayList<>();
            employees.add(new Employee(null, "smith", "男", "smith@atguigu.com", new Department(2)));
            employees.add(new Employee(null, "allen", "女", "allen@atguigu.com", new Department(1)));

            mapper.addEmps(employees);
            openSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }

    }


    @Test
    public void testInnerParam() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        Employee employee = new Employee();
        employee.setName("e");
        EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
        List<Employee> emps = mapper.getEmpsTestInnerParameter(employee);
        for (Employee emp : emps){
            System.out.println(emp);
        }

    }
}

