package com.atguigu.niuke;

import java.nio.charset.IllegalCharsetNameException;
import java.util.HashMap;

/**
 *@ClassName AA
 *@Description  TODO
 *@Author hqb
 *@Date 2022/5/5 19:29
 *@Version 1.0
 */
public class B {
    public int lengthOfLongestSubstring (String s) {
        // write code here
        int n = s.length();
        if(n == 0){
            return 0;
        }
        int start = 0;
        int max_len = 1;
        int[] arr = new int[2];
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hashMap.containsKey(s.charAt(i))){
               start = Math.max(start,hashMap.get(s.charAt(i)) + 1);
            }
            hashMap.put(s.charAt(i), i);
            if ((i - start + 1) > max_len){
                max_len = i - start + 1;
                arr[0] = start;
                arr[1] = i + 1;
            }
        }
        return max_len;
    }
}

