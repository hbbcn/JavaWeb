package com.atguigu.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import sun.security.krb5.internal.crypto.Des;

import java.sql.JDBCType;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.LongStream;

/**
 *@ClassName JedisDemol
 *@Description  TODO
 *@Author hqb
 *@Date 2021/9/18 16:57
 *@Version 1.0
 */
public class JedisDemol{

    public static void main(String[] args) {
        //创建Jedis对象
        Jedis jedis = new Jedis("192.168.200.130",6379);

        System.out.println("hello word");
        //测试
        String ping = jedis.ping();
        System.out.println(ping);
    }

    @Test
    public void demo1(){
        Jedis jedis = new Jedis("192.168.200.130",6379);

        //添加数据
        jedis.set("name","lucy");
        String name = jedis.get("name");
        System.out.println(name);

        //设置多个key-value
        jedis.mset("k1","v1","k2","v2");
        List<String> mget = jedis.mget("k1", "k2");
        System.out.println(mget);
        Set<String> keys = jedis.keys("*");
        for(String key : keys){
            System.out.println(key);

        }
    }

    //操作list集合
    @Test
    public void demo2(){
        Jedis jedis = new Jedis("192.168.200.130",6379);

        jedis.lpush("key1","lucy","marry","jack");
        List<String> key1 = jedis.lrange("key1", 0, -1);
        System.out.println(key1);
    }


    //操作set集合
    @Test
    public void demo3(){
        Jedis jedis = new Jedis("192.168.200.130",6379);

        Long sadd = jedis.sadd("names", "lucy");
        jedis.sadd("names", "mary");
        Set<String> name = jedis.smembers("names");
        System.out.println(name);

    }

    //操作hash
    @Test
    public void demo4(){
        Jedis jedis = new Jedis("192.168.200.130",6379);

        jedis.hset("users","age","20");
        String hget = jedis.hget("users", "age");
        System.out.println(hget);
    }

    //操作zset
    @Test
    public void demo5(){
        Jedis jedis = new Jedis("192.168.200.130",6379);
        jedis.zadd("china",100,"Beijing");
        Set<String> china = jedis.zrange("china", 0, -1);
        System.out.println(china);



    }

}

