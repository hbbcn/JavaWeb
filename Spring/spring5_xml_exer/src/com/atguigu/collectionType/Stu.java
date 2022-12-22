package com.atguigu.collectionType;

import com.atguigu.bean.Book;
import com.sun.org.apache.xml.internal.security.keys.keyresolver.implementations.PrivateKeyResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *@ClassName Stu
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/30 14:46
 *@Version 1.0
 */
public class Stu{

    private String [] courses;

    private List<String> list;

    private List<Book> books;

    private Set<String> set;

    private Map<String,Object> map;


    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "courses=" + Arrays.toString(courses) +
                ", list=" + list +
                ", books=" + books +
                ", set=" + set +
                ", map=" + map +
                '}';
    }
}

