package com.atguigu.admin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class BootDay02ApplicationTests {

    @Test
    void contextLoads() {
        String str = "1,3,4,6,1,6,8,2";
        String[] split = str.split(",");
        int[] ints = Arrays.asList(split).stream().mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(ints));
        List<String> strings = Arrays.asList(split);
        System.out.println(strings);
        System.out.println(Arrays.toString(split));


    }


}
