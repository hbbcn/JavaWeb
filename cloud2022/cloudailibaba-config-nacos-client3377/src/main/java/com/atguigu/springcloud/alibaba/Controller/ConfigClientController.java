package com.atguigu.springcloud.alibaba.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName ConfigClientController
 *@Description  TODO
 *@Author hqb
 *@Date 2022/2/21 13:00
 *@Version 1.0
 */

@RestController
@RefreshScope //支持nacos动态刷新功能
public class ConfigClientController{


//    @Value("${config.info}")
    public String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo(){
        return configInfo;
    }
}

