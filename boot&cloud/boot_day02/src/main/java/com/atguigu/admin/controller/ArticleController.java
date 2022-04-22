package com.atguigu.admin.controller;

import com.atguigu.admin.bean.Pet;
import com.atguigu.admin.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName ArticleController
 *@Description  TODO
 *@Author hqb
 *@Date 2022/1/10 14:00
 *@Version 1.0
 */
@RestController
@RequestMapping("articles")
public class ArticleController{

    @Autowired
    private Pet pet;

    //GET方式无请求体，所以使用@RequestBody接收数据时，前端不能使用GET方式提交数据，而是用POST方式进行提交。
    //在后端的同一个接收方法里，@RequestBody与@RequestParam()可以同时使用，
    // @RequestBody最多只能有一个，而@RequestParam()可以有多个。
    //简言之：
    //一个请求——》只有一个@RequestBody；/
    //一个请求——》可以有多个@RequestParam。

    //@RequestBody主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)
    public Result listArticle(@RequestBody String request ){

        return null;
    }


}

