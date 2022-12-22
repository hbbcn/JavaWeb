package com.bjsxt.httpclient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @ClassName TestHttpClient
 * @Description 使用main方法，测试HttpClient技术
 * @Author hqb
 * @Date 2022/4/7 13:35
 * @Version 1.0
 */

public class TestHttpClient {
    public static void main(String[] args) throws IOException {
        testGetNoParams();
    }

    /**
     * 无参数Get请求
     * 使用浏览器，访问网站过程是：
     * 1、 打开浏览器
     * 2、 输入地址
     * 3、 访问
     * 4、 看结果
     * 使用HttpClient，访问WEB服务的过程
     * 1、 创建客户端，相当于打开浏览器
     */
    public static void testGetNoParams() throws IOException {

        //创建客户端对象
        HttpClient client = HttpClients.createDefault();
        //创建请求地址
        HttpGet get = new HttpGet("http://localhost:80/test");
        //发起请求，接收响应对象
        HttpResponse response = client.execute(get);

        //获取响应体。响应数据是一个基于HTTP协议标准字符串封装的对象
        //所以，响应体和响应头，都是封装的HTTP协议数据，直接使用可能有乱码，或解析错误
        HttpEntity entity = response.getEntity();

        String s = EntityUtils.toString(entity, "UTF-8");
        System.out.println("服务器响应数据是- [" + s + "]");

        //回收资源
        client = null;

    }
}

