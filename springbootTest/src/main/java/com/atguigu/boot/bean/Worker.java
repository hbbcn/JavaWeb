package com.atguigu.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 *@ClassName Worker
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/9 14:59
 *@Version 1.0
 */

@Profile("prod")
@Component
@ConfigurationProperties("person")
@Data
public class Worker implements Person{

    private String name;
    private String age;
}

