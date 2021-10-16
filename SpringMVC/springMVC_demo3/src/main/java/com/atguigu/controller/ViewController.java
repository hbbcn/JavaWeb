package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@ClassName ViewController
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/27 11:49
 *@Version 1.0
 */

@Controller
public class ViewController{

   @RequestMapping("/testThymeleafView")
   public String  testThymeleafView(){
       System.out.println("hello");
       return "success";
   }

   @RequestMapping("/testForward")
    public String testForward(){
       return "forward:/testThymeleafView";
   }

   @RequestMapping("/testRedirect")
    public String testRedirect(){
       return "redirect:/testThymeleafView";
   }
}

