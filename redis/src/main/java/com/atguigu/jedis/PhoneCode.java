package com.atguigu.jedis;

import redis.clients.jedis.Jedis;

import java.util.Random;


/**
 *@ClassName PhoneCode
 *@Description  TODO
 *@Author hqb
 *@Date 2021/9/18 20:30
 *@Version 1.0
 */
public class PhoneCode{


    static String code;
    public static void main(String[] args) {

        //模拟验证码的发送
        verifyCode("16638493199");

        getRedisCode("16638493199",code);

    }


    //验证校验
    public static void getRedisCode(String phone,String code){
        //从redis获取验证码
        Jedis jedis = new Jedis("192.168.200.130",6379);
        String codeKey = "VerifyCode" + phone + ":code";
        String redisCode = jedis.get(codeKey);
        //判断
        if (code.equals(redisCode)){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
        jedis.close();

    }


    //每个手机每天只能发送三次，验证码放到redis中设置过期时间
    public static void verifyCode(String phone){
        //连接redis
        Jedis jedis = new Jedis("192.168.200.130",6379);
        String countKey = "VerifyCode" + phone + ":count";
        String codeKey = "VerifyCode" + phone + ":code";
        //每台手机每天只能发送三次
        String count = jedis.get(countKey);
        if (count == null){
          //没有发送次数，第一次发送
          //设置发送次数是1
            jedis.setex(countKey,24*60*60,"1");
        }else if (Integer.parseInt(count) <= 2){
            //发送次数+1
            jedis.incr(countKey);
        }else {
            //发送三次，不能再发送
            System.out.println("今天发送的次数已经超过三次");
            jedis.close();
            return;
        }

        code = getCode();
        jedis.setex(codeKey,120,code);
        jedis.close();

    }



    //生成6位验证码
    public static String getCode(){

        Random random = new Random();

        String code = "";
        for (int i = 0; i < 6; i++) {
            int rand = random.nextInt(10);
            code += rand;
        }
        return code;
    }
}

