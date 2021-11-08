package com.atguigu.admin.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 *@ClassName City
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/6 12:16
 *@Version 1.0
 */
@Component
@Data
public class City{

    private Long id;
    private String name;
    private String state;
    private String country;
}

