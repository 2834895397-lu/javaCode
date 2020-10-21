package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }

}
