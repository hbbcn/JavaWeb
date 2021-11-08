package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Person02;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 *@ClassName ResponseTestController
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/1 14:54
 *@Version 1.0
 */
@Controller
public class ResponseTestController{

    @ResponseBody
    @GetMapping("/test/person")
    public Person02 getPerson(){

        Person02 person02 = new Person02();
        person02.setAge(28);
        person02.setBirth(new Date());
        person02.setUserName("zhangsan");
        return person02;
    }

}

