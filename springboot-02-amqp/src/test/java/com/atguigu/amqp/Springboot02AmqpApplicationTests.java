package com.atguigu.amqp;

import com.atguigu.amqp.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;

@SpringBootTest
class Springboot02AmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    //点播模式
    @Test
    void putMassage() {
        //message需要自己构建一个, 定义消息体内容和消息头
        //rabbitTemplate.send(exchange, routKey, message);

        //object默认当成消息体, 只需要传入要发送的对象, 自动序列化发送给rabbitMQ;
        //rabbitTemplate.convertAndSend(exchange, routKey, Object);

        HashMap<Object, Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("helloworld", 123, true));
        //对象被默认序列化之后发送出去
        rabbitTemplate.convertAndSend("exchange.direct", "atguigu", new Book("西游记", "吴承恩"));
    }

    @Test
    //接收数据, 如何将数据转为json发送出去?
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }


    //广播模式
    @Test
    public void sendMsg(){
        rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("三国演义", "罗贯中"));

    }

    @Test
    public void createExchange(){
        //创建一个交换器
        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        System.out.println("创建完成");

        //创建一个队列
        amqpAdmin.declareQueue(new Queue("amqpadmin.queue", true));

        //创建绑定规则
        amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqpadmin.routingKey",null ));


    }




}
