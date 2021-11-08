package com.atguigu.boot.converter;

import com.atguigu.boot.bean.Person;
import com.atguigu.boot.bean.Person02;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 *@ClassName GuiguMessageConverter
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/1 16:53
 *@Version 1.0
 */
public class GuiguMessageConverter implements HttpMessageConverter<Person02> {

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(Person.class);
    }

    /**
     * 服务器要统计所有MessageConverter都能写出哪些内容
     *
     * application/x-guigu
     * @return
     */
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/x-guigu");
    }

    @Override
    public Person02 read(Class<? extends Person02> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(Person02 person02, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

        //自定义协议数据的写出
        String data = person02.getUserName()+ ";" + person02.getAge()+ ";" +person02.getBirth();

        //写出去
        OutputStream body = outputMessage.getBody();
        body.write(data.getBytes());
    }
}

