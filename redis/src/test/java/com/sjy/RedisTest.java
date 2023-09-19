package com.sjy;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/**
 * @author dogZ
 * @version 1.0
 * @data 2023/9/15 19:09
 *
 */
public class RedisTest {
    Jedis jedis = new Jedis("192.168.200.119",6379);

    @Test
    public void test(){
        System.out.println("jedis.ping() = " + jedis.ping());
        jedis.close();
    }
    @Test
    public void testKey(){
        jedis.set("key1", "value1");
        jedis.set("key1", "value2");
        jedis.set("key1", "value3");
        jedis.set("key1", "value4");// 后面的会覆盖前面的
        System.out.println("jedis.keys(\"*\")获取所有key = " + jedis.keys("*"));
        System.out.println("jedis.exists(\"key1\")是否存在 = " + jedis.exists("key1"));
        System.out.println("jedis.type(\"key1\") key类型= " + jedis.type("key1"));
        System.out.println("jedis.get(\"key1\") = " + jedis.get("key1"));
        System.out.println("jedis.del(\"key1\")删除 = " + jedis.del("key1"));
        System.out.println("jedis.ttl(\"key1\") 查看过期时间= " + jedis.ttl("key1"));
        System.out.println("jedis.dbSize()当前的数据库的key数量 = " + jedis.dbSize());
    }
    @Test
    public void testString(){
//        Long array = jedis.lpush("array", "1", "23", "4", "56", "67");
//        System.out.println(array);
//        System.out.println("jedis.lpop(\"array\") = " + jedis.lpop("array"));
        System.out.println("jedis.llen(\"list\") = " + jedis.llen("list"));
        jedis.lset("array",0, "100");
        jedis.rpoplpush("list", "array");
        jedis.lrem("list", 2, "a");
        System.out.println(jedis.lrange("array", 0, -1));
        System.out.println(jedis.lrange("list", 0, -1));
    }
    @Test
    public void testList(){
        System.out.println(jedis.keys("*"));
    }
}
