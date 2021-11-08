package com.atguigu.admin.acutuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 *@ClassName AppInfoInfoContributor
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/8 20:35
 *@Version 1.0
 */
@Component
public class AppInfoInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {

        builder.withDetail("msg","你好")
        .withDetail("hello","atguigu")
        .withDetails(Collections.singletonMap("world","6666"));

    }
}

