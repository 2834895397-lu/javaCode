package com.atguigu.springboot04.config;

import com.atguigu.springboot04.component.LoginHandlerIntercepter;
import com.atguigu.springboot04.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Locale;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/atguigu").setViewName("login");
    }

    //所有的WebMvcConfigAdapter组件都会一起起作用
    @Bean//将组件注册在容器中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                /*
                * 静态资源: *.css   *.js
                * springboot已经做好了静态资源的映射
                * 首页和登录操作都是不需要拦截的
                * */
               registry.addInterceptor(new LoginHandlerIntercepter())
                       .addPathPatterns("/**").excludePathPatterns("/index.html", "/", "/user/login");
            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();

    }

}
