package com.atguigu.springcloud.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName ConfigClientController
 *@Description  TODO
 *@Author hqb
 *@Date 2022/2/27 22:52
 *@Version 1.0
 */
@RestController
@RefreshScope
public class ConfigClientController{

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo()

    {
        return configInfo;
    }
}

