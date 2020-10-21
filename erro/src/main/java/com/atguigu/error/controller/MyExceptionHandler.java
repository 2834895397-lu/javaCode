package com.atguigu.error.controller;

import com.atguigu.error.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
/*
* 定制一个专门处理异常的控制器, 根据对应的异常来返回数据
*
* */
@ControllerAdvice
public class MyExceptionHandler {

    /*
    * 浏览器跟客户端返回的都是json数据
    * */
/*    @ResponseBody
    @ExceptionHandler
    public Map<String, Object> handlerException(Exception e){
        Map<String, Object> map = new HashMap<>();
        map.put("code", "user.notexist");
        map.put("massage", e.getMessage());
        return map;
    }*/


    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        //传入我们自己的错误状态码
//
//         Integer statusCode = (Integer)
//         request.getAttribute("javax.servlet.error.status_code")


//        这个属性是固定的
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", "user.notexist");
        map.put("message", "用户出错啦");

        request.setAttribute("ext", map);

        //转发到错误处理器
        return "forward:/error";

    }



}
