package com.atguigu.test;

import com.atguigu.dao.DepartmentMapper;
import com.atguigu.dao.EmployeeMapper;
import com.atguigu.dao.EmployeeMapperAnnotation;
import com.atguigu.dao.EmployeeMapperPlus;
import com.atguigu.mybatis.Department;
import com.atguigu.mybatis.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.WrongMethodTypeException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

        Random random = new Random();
        
        //2、获取sqlSession实例，能直接执行已经映射的sql语句
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            Employee employee =  openSession.selectOne("com.atguigu.mybatis.EmployeeMapper.selectEmp",1);
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
     * 1、mybatis允许增删改直接定义一些类型放回值
     *  Integer long boolean void
     *  2、我们需要手动提交数据
     *      sqlSessionFactory.openSession()     ===>手动提交
     *      sqlSessionFactory.openSession(true) ===>自动提交
     *
     *
     * @throws IOException
     */
    @Test
    public void test02() throws IOException {
        //1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        //2、获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            //3、获取接口的实现类对象
            // 会为接口自动创建一个代理对象，代理对象去执行增删改查方法
            EmployeeMapperAnnotation mapper = sqlSession.getMapper(EmployeeMapperAnnotation.class);
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
     * 测试增删改
     */
    @Test
    public void test03() throws IOException {
        //1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        //2、获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            //测试添加
            Employee employee = new Employee(null,"jerry","男","@jerry.com");
            mapper.addEmp(employee);
            //测试修改时
//            mapper.updateEmp(new Employee(1,"jerry","女","@jerry.com"));
            //测试删除
//            mapper.deleteEmpById(4);
            System.out.println(employee.getId());
            sqlSession.commit();//注意要提交
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }

    /**
     * 单个参数：mybatis不会做特殊的处理
     *          #{参数名}：取出参数值
     *
     * 多个参数：mybatis会做特殊处理
     *          多个参数会被封装成为一个Map
     *          key:param1...paramN,或者参数的索引也可以
     *          value:传入的参数值
     *
     *       #{}就是从map中获取指定的Key值
     * 命名参数：明确指定封装参数时map的key:@param("id")
     *          多个参数会被封装成一个map
     *          key：使用@param注解指定的值
     *          value：参数值
     *       #{指定的key}取出相应的的参数的值
     *
     *
     * 区别：
     *      #{}:是以预编译的形式，将参数设置到sql语句中：和PrepareStatement一样:防止sql注入
     *      ${}:取出的值直接拼装在sql语句中会有安全问题 类似于Statement
     *      大多情况下：我们参数的值都应该去使用#{}
     *
     *      原生jdbc不支持占位符的地方我们就可以使用${}进行取值
     *      比如分表：按照年份分表拆分
     * @throws IOException
     */
    @Test
    public void test04() throws IOException {

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            //当传入多个值的时候可以将值封装为Map类型
   /*   HashMap<String, Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","jerry");
        map.put("tableName","tb_employee");
        Employee employee = mapper.getEmpByMap(map);
*/
//        Employee employee = mapper.getEmpByIdAndName(1, "jerry");
     /*       List<Employee> employees = mapper.getEmpByNameLike("%e%");
            for (Employee employee : employees){
                System.out.println(employee);
            }*/

            Map<String, Object> map = mapper.getEmpByIdResultMap(1);
            for (Map.Entry employeeMap : map.entrySet()){
                System.out.println(employeeMap);
            }

            Map<Integer, Employee> empMap = mapper.getEmpByNameLikeResultMap("%adm%");
            for (Map.Entry emp : empMap.entrySet()){
                System.out.println(emp);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test05() throws IOException {

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
//            Employee empById = mapper.getEmpById(1);
//            System.out.println(empById);
            //多表查询
//            Employee empAndDept = mapper.getEmpAndDept(1);
//            System.out.println(empAndDept);
//            System.out.println(empAndDept.getDept());
            //分步查询
            Employee employee = mapper.getEmpByIdStep(5);
            System.out.println(employee.getName());
            System.out.println(employee.getDept());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test06() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Department deptById = mapper.getDeptById(1);
        System.out.println(deptById);
    }

    @Test
    public void test07() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //通过1号部门查询所有员工信息
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

       /* Department deptByIdPlus = mapper.getDeptByIdPlus(1);
        System.out.println(deptByIdPlus);
        System.out.println(deptByIdPlus.getEmps());*/


        Department deptByIdStep = mapper.getDeptByIdStep(1);
        System.out.println(deptByIdStep.getDepartmentName());
        System.out.println(deptByIdStep.getEmps());


    }


    //通过部门号查询员工信息
    @Test
    public void test08() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
        List<Employee> empByDeptId = mapper.getEmpByDeptId(1);
        System.out.println(empByDeptId);
    }



}


