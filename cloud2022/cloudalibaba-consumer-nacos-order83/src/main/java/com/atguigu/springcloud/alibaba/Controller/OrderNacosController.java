package com.atguigu.springcloud.alibaba.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 *@ClassName OrderNacosController
 *@Description  TODO
 *@Author hqb
 *@Date 2022/2/21 10:37
 *@Version 1.0
 */
@RestController
@Slf4j
public class OrderNacosController{

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String  paymentInfo(@PathVariable("id") long id){

        return restTemplate.getForObject(serverURL+"/payment/nacos/" + id,String.class);
    }


}

