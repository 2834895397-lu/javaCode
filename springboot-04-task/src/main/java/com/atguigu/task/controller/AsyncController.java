package com.atguigu.task.controller;

import com.atguigu.task.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {
    @Autowired
    AsyncService asyncService;

   @Async//告诉spring这是一个异步方法, 这个注解起作用, 必须开始@EnableAsync
    @GetMapping("/hello")
    public String hello(){
        asyncService.hello();
        return "success";
    }

}
