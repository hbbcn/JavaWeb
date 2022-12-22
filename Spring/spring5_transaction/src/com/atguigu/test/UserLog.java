package com.atguigu.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;

/**
 *@ClassName UserLog
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/15 10:22
 *@Version 1.0
 */
public class UserLog{

    @Nullable
    private String name;
    private static final Logger log = LoggerFactory.getLogger(UserLog.class);

    public static void main(String[] args) {

        log.info("hello log4j2");
        log.warn("hello log4j2");
    }
}

