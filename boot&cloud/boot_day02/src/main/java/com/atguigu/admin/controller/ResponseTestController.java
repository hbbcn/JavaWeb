package com.atguigu.admin.controller;

import cn.hutool.json.JSONUtil;
import com.atguigu.admin.bean.Person02;
import com.atguigu.admin.bean.Table;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
    public static
    List<Table> tableData = Arrays.asList(
            new Table(1, 0, "根节点"),
            new Table(2, 1, "子节点1"),
            new Table(3, 2, "子节点1.1"),
            new Table(4, 2, "子节点1.2"),
            new Table(5, 2, "子节点1.3"),
            new Table(6, 1, "子节点2"),
            new Table(7, 6, "子节点2.1"),
            new Table(8, 6, "子节点2.2"),
            new Table(9, 1, "子节点3"),
            new Table(10, 9, "子节点3.1"),
            new Table(11, 10, "孙子节点3.1"),
            new Table(12, 11, "子节点3.1"),
            new Table(12, 11, "子节点3.1")
    );

    @ResponseBody
    @GetMapping("/getJson")
    public  List<TreeVo> Bo2TreeTest(){
        List<TreeVo> result = TreeVo.list2Tree(tableData);
//        String json = JSONUtil.toJsonStr(result);
        return result;
    }

}

