package com.atguigu.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan(basePackages = "com.atguigu.admin.mapper")
@ServletComponentScan(basePackages = "com.atguigu")
@SpringBootApplication(exclude = RedisAutoConfiguration.class
)
public class BootWebAdminDay03Application {

    public static void main(String[] args) {
        SpringApplication.run(BootWebAdminDay03Application.class, args);
    }

}
