package com.atguigu.mvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@ClassName RequestMappingController
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/25 21:13
 *@Version 1.0
 */
@Controller
//@RequestMapping("/hello")
public class RequestMappingController{

    @RequestMapping(value = {
        "/testRequestMapping",
            "/test"
    },
     method = {}
    )
    public String testRequestMapping(){
        return "success";
    }

    @GetMapping("/testGetMapping")
    public String testGetMapping(){
        return "success";
    }

    @RequestMapping(value = "/testPut")
    public String testPut(){

        return "success";
    }

    @RequestMapping(
            value = "/testParamsAndHeaders",
            params = {"username","password!=123"}
    )
    public String testParamsAndHeaders(){
        return "success";
    }

//    @RequestMapping("/a?a/testAnt") //?表示任意单个字符 不能是一些特殊字符如：?
//    @RequestMapping("/a*a/testAnt") //*表示任意0个或者多个字符不能是一些特殊字符
    @RequestMapping("/**/testAnt") // **表示任意0个或多个目录
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/testPath/{id}/{user_name}")
    public String testPath(@PathVariable("id")Integer id,@PathVariable("user_name")String username){
        System.out.println("id = " + id + ",username:" + username);
        return "success";
    }
}

