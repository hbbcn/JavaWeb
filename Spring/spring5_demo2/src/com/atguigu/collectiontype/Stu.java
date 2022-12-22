package com.atguigu.collectiontype;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *@ClassName Stu
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/7 17:37
 *@Version 1.0
 */
public class Stu{

    //1、数组类型的属性
    private String[] courses;

    // 2、list集合类型的属性

    private List<String> list;

    //3、map集合类型的属性

    private Map<String,String> maps;

    //4、set集合类型属性
    private Set<String> set;

    // 5、学生所学的多门课程
    private List<Course> courseList;

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void test(){
        System.out.println(Arrays.toString(courses));
        System.out.println(list);
        System.out.println(maps);
        System.out.println(set);
        System.out.println(courseList);
    }
}

