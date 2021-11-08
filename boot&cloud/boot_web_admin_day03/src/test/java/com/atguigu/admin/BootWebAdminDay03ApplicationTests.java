package com.atguigu.admin;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
class BootWebAdminDay03ApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserMapper userMapper;

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {

//        jdbcTemplate.queryForObject("select * from user")

        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from user");

        System.out.println(maps);
        log.info("数据源类型：{}",dataSource.getClass());

    }

    @Transactional //标注测试方法，测试完成后自动回滚
    @Test
    void testUserMapper(){

        User user = userMapper.selectById(1L);
        log.info("用户信息：{}",user);

    }

}
