package com.atguigu.cache;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMappper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.crypto.MacSpi;

@SpringBootTest
class SpringBoot01CacheApplicationTests {

    @Autowired
    EmployeeMappper employeeMappper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作k-v字符串的

    @Autowired
    RedisTemplate redisTemplate;//k-v都是对象

    @Test
    void contextLoads() {
        Employee emp = employeeMappper.getEmpById(1);
        System.out.println(emp);
    }

    /*
     * Redis常见的五大数据类型
     *   String, List, Set, Hash, ZSet(有序集合)
     *   stringRedisTemplate.opsForValue()//操作String的
     *   stringRedisTemplate.opsForList()//操作List的
     *   stringRedisTemplate.opsForSet()//操作Set的
     *   stringRedisTemplate.opsForHash()//操作Hash散列的
     *   stringRedisTemplate.opsForZSet()//操作ZSet有序集合
     * */


    @Test
    public void test01() {
        //给redis中保存数据
        stringRedisTemplate.opsForValue().append("msg", "jack");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);

        stringRedisTemplate.opsForList().leftPush("mylist", "1");
        stringRedisTemplate.opsForList().leftPush("mylist", "2");
    }

    //测试保存对象
    @Test
    public void test02(){
        //默认如果保存对象, 使用jdk序列化机制, 序列化后的数据保存到redis中
        /*
        *  redisTemplate.opsForValue().set("emp-01", emp);
        * 1. 将数据以json的方式保存的两种方法:
        *       1). 自己将对象转为json
        *       2). RedisTemplate默认的序列化规则, 改变默认的序列化规则即可;
        *
        * */
        Employee emp = employeeMappper.getEmpById(2);
        redisTemplate.opsForValue().set("emp-01", emp);
    }
}
