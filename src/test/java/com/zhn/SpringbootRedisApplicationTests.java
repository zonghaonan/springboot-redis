package com.zhn;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zhn.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringbootRedisApplicationTests {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private RedisUtil redisUtil;
    @Test
    void contextLoads() {

        //opsForValue：操作字符串
        //opsForList：操作列表
        //opsForGeo：操作地图
//        redisTemplate.opsForValue();

        //除了基本的操作，我们常用的方法都可以直接通过redisTemplate操作，比如事务和基本的CRUD

        //获取redis的连接对象
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushDb();
//        redisTemplate.
        redisTemplate.opsForValue().set("k1","你好啊");
        System.out.println(redisTemplate.opsForValue().get("k1"));
    }

    @Test
    void test() throws JsonProcessingException {
        User user = new User("张三", 10);
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

    @Test
    void test2(){
//        redisUtil.set("k1","张三");
//        redisUtil.set("k2","李四");
//        redisUtil.set("k3","王五");
        redisUtil.set("k4",new User("张三", 10));
        System.out.println(redisUtil.get("k4"));
//        redisUtil.del("k1","k3");
    }
}
