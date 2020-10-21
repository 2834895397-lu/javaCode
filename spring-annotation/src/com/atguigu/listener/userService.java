package com.atguigu.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class userService {
    //使用@EventListener就不用实现ApplicationListener接口了, 从而达到一样的效果
//    监听ApplicationEvent事件
    @EventListener(classes = {ApplicationEvent.class})
    public void listen(ApplicationEvent event) {
        System.out.println("userService.....监听到的事件:" + event);

    }
}
