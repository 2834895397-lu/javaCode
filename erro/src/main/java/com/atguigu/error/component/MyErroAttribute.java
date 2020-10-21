
package com.atguigu.error.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;



/*
*
* 如果发生错误, 先来到MyExceptionHandler, 然后再来到本处理器, 然后再将数据丢给页面进行显示
* 所以, 如果想扩展自定义错误属性, 必须得继承DefaultErrorAttributes, 获取map之后给map添加内容即可
*
*
* */

@Component
public class MyErroAttribute extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);

        map.put("company", "atguigu");

        //我们的异常处理器携带过来的数据
        Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
         map.put("ext", ext);

         return map;



    }
}

