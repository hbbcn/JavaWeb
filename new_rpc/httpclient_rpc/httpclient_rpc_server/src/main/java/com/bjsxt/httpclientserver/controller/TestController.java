package com.bjsxt.httpclientserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *@ClassName TestController
 *@Description  TODO
 *@Author hqb
 *@Date 2022/4/7 13:23
 *@Version 1.0
 */
@Controller
public class TestController{

    @RequestMapping(value = "/test",produces = {"application/json;charset=UTF-8"})

    @ResponseBody
    public String test(){
        return "{\"msg\":处理返回\"}";
    }

}

