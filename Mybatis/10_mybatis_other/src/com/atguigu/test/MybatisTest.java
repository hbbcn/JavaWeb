package com.atguigu.test;

import com.atguigu.dao.EmployeeMapper;
import com.atguigu.mybatis.Employee;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.javassist.bytecode.analysis.Executor;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

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

    /**
     * 分页测试
     * @throws IOException
     */
    @Test
    public void test02() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            Page<Object> page = PageHelper.startPage(3, 2);

            List<Employee> emps = mapper.getEmps();
            //参数navigatePages传入连续显示多少页
            PageInfo<Employee> info = new PageInfo(emps,3);
            for (Employee employee : emps){
                System.out.println(employee);
            }
//            System.out.println("当前页码：" + page.getPageNum());
//            System.out.println("总页码：" + page.getPages());
//            System.out.println("总记录数" + page.getTotal());
            System.out.println("当前页码：" + info.getPageNum());
            System.out.println("总页码：" + info.getPages());
            System.out.println("每页记录数：" + info.getPageSize());
            System.out.println("是否第一页" + info.isIsFirstPage());
            System.out.println("连续显示的页码：");
            int[] nums = info.getNavigatepageNums();
            for (int i = 0; i < nums.length; i++) {
                System.out.println(nums[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }
    }

    /**
     * 批量添加数据测试
     * @throws IOException
     */
    @Test
    public void testBatch() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        long start = System.currentTimeMillis();
        SqlSession openSession = null;
        try {
//            ExecutorType.BATCH:设置为批量操作
            openSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            for (int i = 0; i < 10000; i++) {
                mapper.addEmp(new Employee(null, UUID.randomUUID().toString().substring(0,5),"男","12345@qq.com"));
            }
           long end =  System.currentTimeMillis();
            //批量操作：(预编译sql一次 —> 设置参数一万次 —> 执行（一次）) Parameters: 51d31(String), 男(String), 12345@qq.com(String) 执行的时间：-2770
            //非批量：(预编译sql -> 设置参数 —>执行)==》10000次 执行的时间：8050

            System.out.println("执行的时间：" + (end - start));
            openSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }
    }

    /**
     * 存储过程测试
     *
     */
    @Test
    public void testProducer(){

    }

}
