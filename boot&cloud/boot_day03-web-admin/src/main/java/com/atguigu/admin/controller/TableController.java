package com.atguigu.admin.controller;

;
import com.atguigu.admin.bean.User;

import com.atguigu.admin.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

/**
 * @ClassName TableController
 * @Description TODO
 * @Author hqb
 * @Date 2021/11/2 17:30
 * @Version 1.0
 */
@Controller
public class TableController {

    @Autowired
    UserService userService;
    /**
     *
     * @param a 不带请求参数或者参数类型不敌 400：bad request 一般都是浏览器的参数没有正确传递
     * @return
     */
    @GetMapping("/basic_table")
    public String basic_table() {

        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model) {
        //表格内容的遍历
        //response.sendError
//        List<User> users = Arrays.asList(
//                new User("zhangsan", "12324"),
//                new User("lisi", "43243"),
//                new User("haha", "aaaaa"),
//                new User("dada", "ddddd"));
//
//        model.addAttribute("users", users);
//
//        if (users.size()>3){
//          throw new UserTooManyException();
//        }

        //从数据库中查出user表中的用户进行展示

//        List<User> list = userService.list();

        Page<User> userPage = new Page<>(pn, 2);

        //分页查询的结果
        Page<User> page = userService.page(userPage, null);

        List<User> records = page.getRecords();

        model.addAttribute("page",page);
        return "table/dynamic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                             RedirectAttributes ra){

        userService.removeById(id);

        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table() {

        return "table/responsive_table";

    }

    @GetMapping("/editable_table")
    public String editable_table() {
        return "table/editable_table";
    }
}

