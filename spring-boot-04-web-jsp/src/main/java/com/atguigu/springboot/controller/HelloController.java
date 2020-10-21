package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/abc")
    public String hello(Model model){
        model.addAttribute("msg", "你好");

        //在配置文件中配置好解析试图的前缀和后缀, 不然会pringmvc会在静态资源路径下找html页面
        return "success";
    }
}
