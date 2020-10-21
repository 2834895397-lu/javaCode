package com.atguigu.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    //配置druid监控
    //1. 配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean statViewServler() {
        //druid的StatViewServlet, 固定...
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        HashMap<Object, Object> map = new HashMap<>();
        //设置后台登录的账号和密码
        map.put("loginUsername", "admin");
        map.put("loginPassword", "123456");
        bean.setInitParameters(map);
        return bean;
    }

    //配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webstratFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        //druid的WebStatFilter
        bean.setFilter(new WebStatFilter());
        HashMap<Object, Object> map = new HashMap<>();
        //排除掉不需要拦截的资源
        map.put("excluesions", "*.js, *.css, /druid/*");
        bean.setInitParameters(map);
        return bean;
    }


}
