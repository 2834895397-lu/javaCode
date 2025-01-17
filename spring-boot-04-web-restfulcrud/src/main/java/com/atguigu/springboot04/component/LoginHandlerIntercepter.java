package com.atguigu.springboot04.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ResourceBundle;

/*检查登录*/
public class LoginHandlerIntercepter implements HandlerInterceptor {
    /*目标方法执行之前*/

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if (user == null) {
            //未登录, 返回登录页面
            request.setAttribute("msg", "没有权限请先登录!");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        }else{
            //已登录, 放行
            return true;

        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
