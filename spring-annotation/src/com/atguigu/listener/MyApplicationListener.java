package com.atguigu.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/*
        ApplicationEvent是我们要监听的事件, 当容器启动的时候会发布两个事件:
        ContextRefreshedEvent,  ContextClosedEvent; 我们也可以自己定义一些事件

     如果我们想监听容器的事件, 又不想实现ApplicationListener, 则可以通过在方法上使用@EvenListener来实现这个功能
* */
//这个事件要工作必须添加到容器中
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {
    //    当容器中发布此事件以后, 方法会触发
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("收到的事件:" + event);

    }
}
