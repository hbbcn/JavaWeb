package com.hbb.practice.list;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *@ClassName Main
 *@Description  TODO
 *@Author hqb
 *@Date 2022/5/6 23:30
 *@Version 1.0
 */
public class Main{
    public static void main(String[] args) {
        ObjectExample object1 = new ObjectExample(1, 10678);
        ObjectExample object2 = new ObjectExample(2, 11435);
        ObjectExample object3 = new ObjectExample(3, 1123);
        ObjectExample object4 = new ObjectExample(2, 11230);
        ObjectExample object5 = new ObjectExample(3, 13450);
        ObjectExample object6 = new ObjectExample(4, 1345);
        ObjectExample object7 = new ObjectExample(1, 10768);
        ObjectExample object8 = new ObjectExample(2, 1670);
        ObjectExample object9 = new ObjectExample(4, 10867);
        ObjectExample object10 = new ObjectExample(3, 16780);
        ArrayList<ObjectExample> list = new ArrayList<>();
        list.add(object2);
        list.add(object3);
        list.add(object4);
        list.add(object5);
        list.add(object6);
        list.add(object7);
        list.add(object8);
        list.add(object9);
        list.add(object10);
        ArrayList<Integer> set = new ArrayList<>();
        for (ObjectExample object : list) {
            set.add(object.age);
        }
        System.out.println(set);
        HashSet<Integer> age = new HashSet<>(set);
        System.out.println(age);
        HashMap<Integer, Integer> map = new HashMap<>();
//        for()
        for (Integer ObectAgeDistru : age) {
            int avgAge = 0;
            int count = 0;
            for (ObjectExample objectExample : list) {
                if(ObectAgeDistru == objectExample.age) {
                    avgAge += objectExample.salary;
                    count++;
                }
            }
            avgAge = avgAge / count;
            map.put(ObectAgeDistru, avgAge);
        }
        System.out.println(map);
    }
}

