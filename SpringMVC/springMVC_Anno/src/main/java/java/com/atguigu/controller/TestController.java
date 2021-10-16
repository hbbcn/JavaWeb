package java.com.atguigu.controller;
/**
 *@ClassName TestController
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/29 16:47
 *@Version 1.0
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController{

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}

