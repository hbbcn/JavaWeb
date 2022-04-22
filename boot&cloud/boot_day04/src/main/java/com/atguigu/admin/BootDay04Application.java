package com.atguigu.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@EnableAdminServer
@SpringBootApplication
public class BootDay04Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(BootDay04Application.class, args);
//
//        ConfigurableEnvironment environment = run.getEnvironment();
//
//        Map<String, Object> systemEnvironment =
//                environment.getSystemEnvironment();
//
//        Map<String, Object> systemProperties = environment.getSystemProperties();
//
//        System.out.println(systemEnvironment);
//        System.out.println(systemProperties);

    }

}
