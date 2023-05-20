package com.atguigu.springcloud.Controller;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RibbonRestTemplateTest {

    @Autowired
   static RestTemplate restTemplate;

    public static void main(String[] args) {
        ResponseEntity<CommonResult> test = test();
        System.out.println(test);
    }

    public static ResponseEntity<CommonResult> test(){

        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity("https://www.baidu.com/baidu?tn=monline_7_dg&ie=utf-8&wd=%E7%99%BE%E5%BA%A6", CommonResult.class);

        return forEntity;

    }
}
