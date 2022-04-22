package com.atguigu.springcloud.test;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test01 {


    @GetMapping("/get")
    public String get(){

        return "1211";
    }


}
