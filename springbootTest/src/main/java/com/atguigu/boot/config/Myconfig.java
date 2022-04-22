package com.atguigu.boot.config;

import com.atguigu.boot.bean.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *@ClassName Myconfig
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/9 15:05
 *@Version 1.0
 */

@Configuration
public class Myconfig{

    @Bean
    @Profile("prod")
    public Color red(){

        return new Color();
    }

    @Bean
    @Profile("test")
    public Color green(){
        return new Color();
    }
}

