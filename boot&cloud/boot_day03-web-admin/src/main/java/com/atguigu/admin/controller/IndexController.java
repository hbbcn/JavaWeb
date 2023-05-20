package com.atguigu.admin.controller;

import com.atguigu.admin.bean.City;
import com.atguigu.admin.bean.User;
import com.atguigu.admin.bean.User01;
import com.atguigu.admin.service.CityService;
import com.atguigu.admin.service.User01Service;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @ClassName indexController
 * @Description TODO
 * @Author hqb
 * @Date 2021/11/2 11:47
 * @Version 1.0
 */
// http://localhost:8080/basic_table和http://localhost:8080/basic_table.html的区别你知道吗 庆斌
//  前者是请求,后者是资源
//后端:处理请求 返回相应
//如果是资源的话,后端是不需要处理的
//资源可以是html,css,js，照片等等
//这些是不会走你写的业务代码的,所以不会对服务器造成很大的压力

//    //举个例子 https://item.jd.com/10037097059507.html,它就是一个资源,而不是请求,是不会走后台业务代码的,对服务器压力较小
@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    User01Service userService;

    @Autowired
    CityService cityService;

    @Autowired
    City city;

//    @Autowired
//    private RedisTemplate redisTemplate;

/*
    @ResponseBody
    @GetMapping("/redisTest")
    public String testRedis(){

        System.out.println("连接到redis");
        //设置值到redis
        redisTemplate.opsForValue().set("name","lucy");
        //从redis获取值
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println("连接完成");
        return name;
    }
*/

    @ResponseBody
    @GetMapping("city/{name}/{state}/{country}")
    public City saveCity(@PathVariable String name, @PathVariable String state, @PathVariable String country) {
        city.setName(name);
        city.setState(state);
        city.setCountry(country);
        cityService.saveCity(city);
        return city;
    }



    @ResponseBody
    @GetMapping("city/{id}")
    public City getCityById(@PathVariable() Long id) {

        return cityService.getById(id);
    }

    @ResponseBody
    @RequestMapping("user")
    public User01 getById(@RequestParam("id") Long id) {

        return userService.getUserById(id);
    }

    @ResponseBody
    @GetMapping("sql")
    public List queryFromDb() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from user");
        return maps;
    }

    /**
     * 来登录页
     *
     * @return
     */
    @GetMapping(value = {"/", "login"})
    public String loginPage() {

        return "login";
    }

    @PostMapping("login")
    public String main(User user, HttpSession session, Model model) {

        if ("wzg168".equals(user.getUserName()) && "123456".equals(user.getPassword())) {
            //把登录成功的用户保存起来
            session.setAttribute("loginUser", user);
            //登录成功重定向到main.html,重定向防止表单重复提交 解决转发出现重复提交的问题
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "账号密码错误");
            //回到登录页
            return "login";
        }
    }

    /**
     * 去main页面
     *
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {

        //是否登录。     拦截器，过滤器

        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            return "main";
        } else {
            model.addAttribute("msg", "请重新登录");
            return "login";
        }


    }
}

