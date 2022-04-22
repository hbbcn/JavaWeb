package com.atguigu.admin.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *@ClassName HelloPeoperties
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/13 14:08
 *@Version 1.0
 */
@ConfigurationProperties("atguigu.hello")
public class HelloProperties {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}

