package com.atguigu.springboot04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
//    @RequestMapping(value="/user/login", method = RequestMethod.POST)
//    @GetMapping
//    @PutMapping
//    @DeleteMapping
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session){

        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登录成功, 为了防止表单的重复提交, 我们可以重定向到页面
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        }else{

            map.put("msg", "用户名密码错误!");
            return "login";
        }
    }
}
