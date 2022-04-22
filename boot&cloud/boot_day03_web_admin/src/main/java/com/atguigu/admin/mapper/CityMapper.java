package com.atguigu.admin.mapper;
import com.atguigu.admin.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * 实战步骤：
 * 引入mybatis-starter
 * 配置application.yaml中，指定mapper-location位置即可
 * 编写Mapper接口并标注@Mapper注解
 * 简单方法直接注解方式
 * 复杂方法编写mapper.xml进行绑定映射
 * @MapperScan("com.atguigu.admin.mapper")简化，其他接口就可以不用标注@Mapper注解
 *
 */

@Mapper
public interface CityMapper {

    @Select("select * from city where id=#{id}")
    public City getById(Long id);

    @Insert("insert into city(name,state,country) values(#{name},#{state},#{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insert(City city);

}
