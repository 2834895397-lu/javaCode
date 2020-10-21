package com.atguigu.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* 自动配置:
*       1. RabbitAutoConfiguration
*       2. 有自动配置了连接工厂ConnectionFactory
*       3. RabbitProperties封装了RabbtiMQ的配置
*       4. RabbitTemplate: 给rabbitMQ发送和接收消息的
*       5. AmqpAdmin: RabbitMQ系统管理组件, 可以创建和销毁交换器或者队列
*       6. @EnableRabbit + @RabbitListener
* */
@SpringBootApplication
@EnableRabbit//开启基于注解RabbitMQ模式
public class Springboot02AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot02AmqpApplication.class, args);
    }

}
