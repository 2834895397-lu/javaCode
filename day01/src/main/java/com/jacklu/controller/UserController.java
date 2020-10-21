package com.jacklu.controller;

import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
@RestController
public class UserController {
    @RequestMapping("/test")
    public String test() {
        return "hello jacklu";
    }
}
