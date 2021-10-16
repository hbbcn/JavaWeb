package com.atguigu.test;

import com.atguigu.dao.EmployeeMapper;
import com.atguigu.mybatis.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;

/**
 *@ClassName MybatisTest
 *@Description
 * 1、接口时编程
 *      原生：     Dao         ===>    DaoImpl
 *      mybatis    Mapper      ===>    xxMapper.xml
 *
 *  2、SqlSession代表和数据库的一次会话，用完必须关闭
 *  3、SqlSession和Connection一样它都是非线程安全，每次使用都应该去获取新的对象
 *  4、mapper接口实现类，但是mybatis会为这个接口生成一个代理对象：EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
 *          |—— 将接口和xml进行绑定
 *  5、两个重要的配置文件：
 *          |—— mybatis的全局配置文件，包含数据库连接池信息，事务管理器信息...系统运行时环境
 *          |—— sql映射文件，保存每一个sql语句的映射信息，
 *                      |—— 将sql抽取出来
 *
 *@Author HuangQingbin
 *@Date 2021/8/15 13:55
 *@Version 1.0
 */
public class MybatisTest{


    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    /**
     * 1、根据xml配置文件(全局配置文件)创建一个SqlSessionFactory对象
     *          有数据源一些其他环境信息
     * 2、sql映射文件，配置了每一个sql,以及sql的封装规则等
     * 3、将sql映射文件注册到全局配置文件中
     * 4、写代码：
     *      |-- 根据配置文件得到SqlSessionFactory
     *      |-- 使用sqlSession工厂，获取到sqlSession对象使用他来执行增删改操作
     *      |-- 一个sqlSession就是代表数据库的一次会话，用完需要关闭
     *      |-- 使用sql的唯一标识来告诉Mybatis执行哪个sql.sql都保存在sql映射文件中
     * @throws IOException
     */


    @Test
    public void test() throws IOException {
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取sqlSession实例，能直接执行已经映射的sql语句
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            Employee employee =  openSession.selectOne("com.atguigu.dao.EmployeeMapper.selectEmp",1);
            System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }
    }

    @Test
    public void test1() throws IOException {
        //1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        //2、获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            //3、获取接口的实现类对象
            // 会为接口自动创建一个代理对象，代理对象去执行增删改查方法
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmpById(1);
            System.out.println(mapper.getClass());
            System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }

}

