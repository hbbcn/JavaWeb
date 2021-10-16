package com.atguigu.test;
import com.atguigu.dao.EmployeeMapper;
import com.atguigu.mybatis.Employee;
import com.atguigu.mybatis.EmployeeExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName MybatisTest
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/19 9:42
 *@Version 1.0
*/
public class MybatisTest{

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource ="mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        return build;
    }

    @Test
    public void testMbg() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    @Test
    public void testSimple() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
//        List<Employee> employees = mapper.selectAll();
            Employee employee = mapper.selectByPrimaryKey(1);
            System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }

    }


    @Test
    public void testMybatis3() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession= sqlSessionFactory.openSession();

        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

            //xxxExample就是封装查询条件

            //1.查询所有信息
            List<Employee> employees = mapper.selectByExample(null);
           //2.查询员工名字中有e字母的，和员工性别是1的
            EmployeeExample example = new EmployeeExample();
            EmployeeExample.Criteria criteria = example.createCriteria();
            //创建一个Criteria,这个Criteria就是拼装查询条件
            criteria.andNameLike("%e%");
            criteria.andGenderEqualTo("男");

            EmployeeExample.Criteria criteria1 = example.createCriteria();
            criteria1.andEmailLike("c");
            example.or(criteria1);
            List<Employee> employees1 = mapper.selectByExample(example);
            for (Employee employee : employees1){
                System.out.println(employee);
            }
        } finally {
            openSession.close();
        }
    }

    /**
    * Mybatis运行原理：
     *      ① 获取sqlSessionFactory对象
     *          |——解析文件的每一个信息保存到Configuration中，返回包含Configuration的DefaultSqlSession
     *          注意：MapperStatement:代表一个增删改查的详细信息
     *      ② 获取sqlSession对象
     *          |——返回一个DefaultSqlSession对象，包含Executor和Configuration
     *               这一步会创建Executor
     *      ③ 获取接口的代理对象(MapperProxy)
     *          |——调用getMapper,使用MapperProxyFactory创建一个MapperProxy的代理对象
     *               代理对象里面包含了：DefaultSqlSession（Executor）
     *      ④ 执行增删改方法
     *
     *      总结：
     *          1、根据配置文件(全局，sql映射)初始化出Configuration
     *          2、创建一个DefaultSqlSession对象
     *                 他里面包含Configuration以及
     *                 Executor(根据全局配置文件中的DefaultExecutorType创建对应的Executor)
     *          3、DefaultSqlSession.getMapper():拿到Mapper接口对应的MapperProxy,
     *          4、MapperProxy里面有(DefaultSqlSession):
     *          5、执行增删改查方法：
     *                      1)、调用DefaultSqlSession的增删改查(Executor)
     *                      2)、会创建一个statementHandler对象
     *                          (同时也会创建出ParameterHandler和ResultHandler)
     *                      3)、调用StatementHandler预编译参数以及设置参数值
     *                      4)、调用StatementHandler的增删改查方法
     *                      5)、ResultSetHandler封装结果
     *
     *       注意：四大对象每个创建的时候都有一个流程
     *                  interceptorChain.pluginAll(parameterHandler);
     *
     */
    @Test
    public void testSrc(){

    }





}

