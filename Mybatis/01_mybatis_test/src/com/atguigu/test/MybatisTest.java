package com.atguigu.test;

import com.atguigu.Dao.EmployeeMapper;
import com.atguigu.mybatis.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName MybatisTest
 * @Description TODO
 * @Author hqb
 * @Date 2021/9/7 12:39
 * @Version 1.0
 */
public class MybatisTest {

    @Test
    public void test01() throws IOException {
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession openSession = sqlSessionFactory.openSession();

        Employee selectOne = openSession.selectOne("com.atguigu.Dao.EmployeeMapper.selectEmp", 1);
        System.out.println(selectOne);

    }

    @Test
    public void test02() throws IOException {
        String resource = "mybatis_config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession openSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getEmpById(1);
        System.out.println(employee);
        openSession.close();
    }


}

