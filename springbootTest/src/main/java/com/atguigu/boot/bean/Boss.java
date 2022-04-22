package com.atguigu.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 *@ClassName BOss
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/9 14:59
 *@Version 1.0
 */


@Profile({"test","default"})
@Component
@ConfigurationProperties("person")
@Data
public class Boss implements Person{

    private String name;
    private String age;

}

