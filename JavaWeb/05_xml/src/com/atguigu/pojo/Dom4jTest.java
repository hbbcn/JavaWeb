package com.atguigu.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName Dom4jTest
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/7/18 12:59
 *@Version 1.0
 */
public class Dom4jTest{

    @Test
    public void test1() {
        //创建一个SaxReader输入流 去读取xml配置文件，生成Document对象
        SAXReader saxReader = new SAXReader();
        Document doc = null;
        try {
            doc = saxReader.read("src/books.xml");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        System.out.println(doc);

    }

    /**
     *读取books.xml文件生成Book类
     *
     */

    @Test
    public void test2() throws Exception {
        //1. 读取books.xml文件
        SAXReader reader = new SAXReader();
        // 在junit测试中，相对路径是从当前模块名开始算
        Document document = reader.read("src/books.xml");
        //2. 通过文档对象Document对象获取根元素
        Element rootElement = document.getRootElement();
        System.out.println(rootElement);
        //3. 通过根元素获取book标签对象

        List<Element> books = rootElement.elements("book");
        //4.遍历，处理每个book标签转换为Book类
        for (Element book : books){

            //element()和elements()都是通过标签名查找子元素
            Element nameElement = book.element("name");
            //asXML()是把标签对象，转换为标签字符串
//            System.out.println(nameElement.asXML());
            //getText():可以获取标签中的文本内容
            String nameText = nameElement.getText();
//            System.out.println(nameText);

            //直接 获取指定标签名里面的文本内容
            String priceText = book.elementText("price");
//            System.out.println(priceText);
            String authorText = book.elementText("author");
//            System.out.println(authorText);
            String snValue = book.attributeValue("sn");
//            System.out.println(snValue);
            System.out.println(new Book(nameText,snValue, Double.parseDouble(priceText),authorText));

        }
    }


    @Test
    public void test01() throws Exception {
        //1. 读取books.xml文件
        SAXReader reader = new SAXReader();
        // 在junit测试中，相对路径是从当前模块名开始算
        Document document = reader.read("src/books.xml");
        //2. 通过文档对象Document对象获取根元素
        Element rootElement = document.getRootElement();
        System.out.println(rootElement);
        //3. 通过根元素获取book标签对象
        //element()和elements()都是通过标签名查找子元素
        List<Element> books = rootElement.elements("book");
        //4.遍历，处理每个book标签转换为Book类
        for (Element book : books) {
            //asXML()是把标签对象，转换为标签字符串
            Element nameElement = book.element("name");
//            System.out.println(nameElement.asXML());
            //getText():可以获取标签中的文本内容
            String nameText = nameElement.getText();
//            System.out.println(nameText);

            //直接 获取指定标签名里面的文本内容
            String priceText = book.elementText("price");
//            System.out.println(priceText);

            String authorText = book.elementText("author");
//            System.out.println(authorText);

            String snValue = book.attributeValue("sn");
//            System.out.println(snValue);

            System.out.println(new Book(nameText, snValue, Double.parseDouble(priceText), authorText));
            System.out.println(priceText);

        }
    }
}

