package com.atguigu.admin.controller;

import com.atguigu.admin.bean.Person02;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@ClassName ParameterTestController
 *@Description  TODO
 *@Author hqb
 *@Date 2021/10/30 17:39
 *@Version 1.0
 */

@RestController
public class ParameterTestController{


    @GetMapping("car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id")Integer id,
                                      @PathVariable("username")String name,
                                      @PathVariable Map<String,String> pv,
                                      @RequestHeader("User-Agent")String userAgent,
                                      @RequestHeader Map<String,String> header,
                                      @RequestParam("age")Integer age,
                                      @RequestParam("inters")List<String> inters,
                                      @RequestParam() Map<String,String> params

                                     ) {

        Map<String, Object> map = new HashMap<>();

//        map.put("id",id);
//        map.put("name",name);
//        map.put("pv",pv);
//
//        map.put("userAgent",userAgent);
//        map.put("headers",header);
        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);
        return map;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){

        HashMap<Object, Object> map = new HashMap<>();
        map.put("content",content);
        return map;

    }

    //1、语法: /cars/sell;low=34;brand=byd,audi,yd
    //2、SpringBoot默认是禁用了矩阵变量的功能
    //      手动开启
    @GetMapping("/cars/{path}")
    public Map careSell(@MatrixVariable Integer low,
                        @MatrixVariable List<String> brand,
                        @PathVariable("path") String path){

        HashMap map = new HashMap();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;

    }

    /**
     * 数据绑定:页面提交的请求数据（get，post）都可以和对象属性进行绑定
     * @param person02
     * @return
     */
    @PostMapping("/saveuser")
    public Person02 saveuser(Person02 person02){

        return person02;
    }
}

