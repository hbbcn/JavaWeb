package com.atguigu.boot.bean;

import lombok.Data;
import lombok.ToString;

/**
 *@ClassName Pet
 *@Description  TODO
 *@Author hqb
 *@Date 2021/10/29 17:22
 *@Version 1.0
 */

@Data
@ToString
public class Pet{

    private String name;
    private Double weight;
    private String age;
}

