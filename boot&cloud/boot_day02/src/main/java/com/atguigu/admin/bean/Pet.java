package com.atguigu.admin.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 *@ClassName Pet
 *@Description  TODO
 *@Author hqb
 *@Date 2021/10/29 17:22
 *@Version 1.0
 */

@Data
@ToString
@Component
public class Pet{

    private String name;
    private Double weight;
    private String age;
}

