package com.atguigu.Exer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *@ClassName Student
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/11 19:46
 *@Version 1.0
 */
public class Student{

    private String[] course;
    private List<String > list;
    private Map<String,String> map;
    private Set<String> set;
    private List<Course1> course1List;

    public String[] getCourse() {
        return course;
    }

    public void setCourse(String[] course) {
        this.course = course;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public List<Course1> getCourse1List() {
        return course1List;
    }

    public void setCourse1List(List<Course1> course1List) {
        this.course1List = course1List;
    }

    @Override
    public String toString() {
        return "Student{" +
                "course=" + Arrays.toString(course) +
                ", list=" + list +
                ", map=" + map +
                ", set=" + set +
                ", course1List=" + course1List +
                '}';
    }

    public void test(){
        System.out.println(Arrays.toString(course));
        System.out.println(list);
        System.out.println(set);
        System.out.println(map);
        System.out.println(course1List);
    }
}

