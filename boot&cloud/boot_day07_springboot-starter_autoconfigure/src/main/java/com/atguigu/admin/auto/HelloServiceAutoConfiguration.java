package com.atguigu.admin.auto;

import com.atguigu.admin.bean.HelloProperties;
import com.atguigu.admin.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@ClassName HelloServiceAutoConfigure
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/13 14:13
 *@Version 1.0
 */

@Configuration
@ConditionalOnMissingBean(HelloService.class)
@EnableConfigurationProperties(HelloProperties.class)//默认HelloProperties放在容器中
public class HelloServiceAutoConfiguration {

    @Bean
    public HelloService helloService(){

        HelloService helloService = new HelloService();
        return helloService;
    }
}

