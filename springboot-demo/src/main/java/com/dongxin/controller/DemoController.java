package com.dongxin.controller;

import com.dongxin.entity.User;
import com.dongxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by huanggc on 2020/9/15.
 */
@Controller
public class DemoController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/list")
    public List<User> findAllUsers(User u) {
        return userService.findByUsernameAndPassword(u);
    }

    @PostMapping("/user/save")
    public void save(User u) {
        userService.save(u);
    }

    @RequestMapping("/login")
    public String userLogin(User user) {
        System.out.println(userService.hasUser(user));

        return "redirect:/login";
    }


    @RequestMapping("/toLoginPage")
    public String toLogin() {
        return "login.html";
    }


}
