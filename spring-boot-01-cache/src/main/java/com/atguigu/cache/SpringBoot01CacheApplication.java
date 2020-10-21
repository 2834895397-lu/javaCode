package com.atguigu.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/*
* 一: 搭建基本环境
*  1. 创建数据库(spring_cache; 两张表:department和employee)
*  2. 创建javabean封装数据
*  3. 整合mybatis操作数据库
*       1. 配置数据源信息
*       2.使用注解版的mybatis
*           1). 使用@MapperScan指定扫描mapper接口所在的包
*
* 二: 快速体验缓存
*   步骤:
*       1. 开启基于注解的缓存: @EnableCaching
*       2. 标注缓存注解即可:
*           @Cacheable
*           @CacheEvict
*           @Cacheput
*
* 默认使用的是ConcurrentMapCacheManager==ConcurrenMapCache;
* 将数据保存在ConcurrentMap<Object, Object>
三: 整合Redis作为缓存
*   Redis是一个开源(BSD)的, 内存中的数据结构存储系统, 它可以用作数据库, 缓存和消息中间件
*       1. 安装redis(使用docker)
*       2. 引入redis的starter
*       3. 配置redis(参照RedisProperties)
*       4. 测试缓存:(根据导入的缓存的先后类型个条件来判断那些自动配置的缓存组件是生效的, 具体可以参照CacheAutoConfiguration)
*           原理: CacheManager --> Cache 缓存组件来实际给缓存中实际存储数据
*           1). 引入redis的starter, 容器中保存的是RedisCacheManager;
*           2). RedisCacheManager帮我们创建RedisCache来作为缓存组件; RedisCache来通过操作Redis来存储数据
*           3). 默认保存数据k-v都是Object; 利用序列化保存, 如何保存为json?
*
* */
@EnableCaching
@SpringBootApplication
@MapperScan("com.atguigu.cache.mapper")
public class SpringBoot01CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot01CacheApplication.class, args);
    }

}
