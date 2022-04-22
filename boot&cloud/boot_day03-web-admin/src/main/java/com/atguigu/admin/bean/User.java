package com.atguigu.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@ClassName User
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/2 14:55
 *@Version 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User{

    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;

    //以下是数据库字段
    private Long id;
    private String name;
    private Integer age;
    private String email;

}

