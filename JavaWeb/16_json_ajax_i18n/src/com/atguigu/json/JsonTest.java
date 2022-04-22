package com.atguigu.json;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.rmi.MarshalledObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName JsonTest
 * @Description TODO
 * @Author HuangQingbin
 * @Date 2021/8/5 20:25
 * @Version 1.0
 */
public class JsonTest {

    //1、 javaBean和json的互转
    @Test
    public void test1() {
        Person person = new Person(1, "周星星");

        //创建Gson对象实例
        Gson gson = new Gson();

        //toJson()方法可以把java对象转换成为json字符串
        String s = gson.toJson(person);
        System.out.println(s);

        //fromJson把字符串转换回java对象
        Person person1 = gson.fromJson(s, Person.class);
        System.out.println(person1);
    }

    // 2、List 和 json的互转
    @Test
    public void test2() {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person(1, "国歌"));
        personList.add(new Person(2, "斌哥"));

        Gson gson = new Gson();

        // 把List转换为json字符串
        String s = gson.toJson(personList);
        System.out.println(s);

        List<Person> list = gson.fromJson(s, new PersonListType().getType());
        System.out.println(list);
        Person person = list.get(0);
        System.out.println(list.get(0));
        System.out.println(person);
    }


    //3、map 和 json的互转
    @Test
    public void test3() {

        HashMap<Integer, Person> personMap2 = new HashMap<>();

        personMap2.put(1, new Person(1, "国歌"));
        personMap2.put(2, new Person(2, "周星星"));

        Gson gson = new Gson();
        String s = gson.toJson(personMap2);
        System.out.println(s);

//      Map<Integer, Person> personMap3 = gson.fromJson(s, new PersonMapType().getType());
        Map<Integer, Person> personMap3 = gson.fromJson(s, new TypeToken<HashMap<Integer,Person>>(){}.getType());//匿名内部类的方式

        System.out.println(personMap3);
        Person person = personMap3.get(1);
        System.out.println(person);


    }


}

