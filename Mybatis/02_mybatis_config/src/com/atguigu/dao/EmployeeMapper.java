package com.atguigu.dao;

import com.atguigu.mybatis.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.nio.charset.IllegalCharsetNameException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * POJO:
 *      如果多个参数正好是我们的业务逻辑的数据模型，我们就可以直接传入Pojo
 *       #{key}:取出map中对应的值
 * Map:
 *      如果多个参数不是业务逻辑中的数据，没有对应的pojo，不经常使用，为了方便，我们也可以传入map
 *       #{key}:取出map中对应的值
 * To:
 *      如果多个参数不是业务逻辑中的数据，但是经常使用，推荐编写一个To(Transfer Object)数据传输对象
 * Page{
 *     int index;
 *     int size;
 * }
 *
 * 特别注意 如果是Collection类型或者是数组
 *          也会特殊处理，也是把传入的list或者数组封装在map中
 *           取出第一个id值：#{list[0]}
 *
 *
 * jdbcType通常需要在某种特点的条件下被设置：
 *          在我们数据为Null的时候，有些数据库可能不能识别mybatis对Null的默认处理：比如oracle(报错)
 *          JdbcType OTHER: 无效类型，因为mybatis对所有的Null都映射的是原生jdbc的OTHER类型，oracle不能正确的处理
 *
 *          由于全局配置中，jdbcTypeForNUll=OTHER oracle 两种方法
 *          1、#{email,jdbcType=null};
 *          2、全局配置：
 *              <setting  name = "jdbcTypeForNull" value = "NULL"
 *
 *
 *
 */

public interface EmployeeMapper {

    //多条记录封装一个map
    //告诉mybatis封装这个map的时候使用哪个属性作为主键
    @MapKey("name")
    public Map<Integer,Employee> getEmpByNameLikeResultMap(String name);
    //返回的一条记录的map: key就是列名，值就是对应的值
    public Map<String,Object> getEmpByIdResultMap(Integer id);

    public List<Employee> getEmpByNameLike(String name);

    public Employee getEmpByMap(HashMap<String, Object> map);

    //通过注解指定要传入的属性
    public Employee getEmpByIdAndName(@Param("id") Integer id, @Param("name") String name);

    public Employee getEmpById(Integer id);

    public void addEmp(Employee employee);

    public void updateEmp(Employee employee);

    public void deleteEmpById(Integer id);
}
