package com.atguigu.admin.controller;
/**
 *@ClassName FormTestController
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/13 17:28
 *@Version 1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.sampled.Line;

/**
 * 文件上传测试
 */
@Slf4j
@Controller
public class FormTestController{

    @GetMapping("/form_layouts")
    public String form_layouts(){

        return "form/form_layouts";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos){


        System.out.println("!!!!!!!!!!!!!");
        log.info("上传的信息 email:{}" + email);
        log.info("username={},headerImg={},photos={}", username, headerImg.getSize(),photos.length);
        return "main";
    }

}

