package com.atguigu.error.controller;

import com.atguigu.error.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("aaa") String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "hello world";

    }

}
