package com.atguigu.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan(basePackages = "com.atguigu.admin.mapper")
@ServletComponentScan(basePackages = "com.atguigu")
@SpringBootApplication
public class BootDay03WebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootDay03WebAdminApplication.class, args);
    }

}
