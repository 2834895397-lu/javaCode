package com.jacklu.mybatisplus.config;

import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//扫描我们的mapper文件夹
@MapperScan("com.jacklu.mybatisplus.mapper")
@EnableTransactionManagement
@Configuration
public class MybatisConfig {

    //注册乐观锁拦截器  Optimistic: 乐观的
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
       return  new OptimisticLockerInterceptor();
    }

//  给容器配置一个分页插件分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

//    逻辑删除组件
    @Bean
    public ISqlInjector iSqlInjector(){
        return new DefaultSqlInjector();
    }

}
