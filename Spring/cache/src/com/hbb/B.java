package com.hbb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *@ClassName B
 *@Description  TODO
 *@Author hqb
 *@Date 2022/4/28 12:57
 *@Version 1.0
 */
@Component
public class B{
    @Autowired
    A a;
}

