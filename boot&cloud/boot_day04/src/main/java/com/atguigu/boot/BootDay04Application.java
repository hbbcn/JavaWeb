package com.atguigu.boot;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class BootDay04Application {

    public static void main(String[] args) {
        SpringApplication.run(BootDay04Application.class, args);
    }

}
