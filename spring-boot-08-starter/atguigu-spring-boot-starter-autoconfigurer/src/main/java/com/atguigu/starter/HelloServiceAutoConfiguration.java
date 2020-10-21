package com.atguigu.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(HelloProperties.class)
/*
* 要使这个自动配置类生效, 必须在类路径下建立一个META-INF文件夹, 然后新建一个spring.factories文件
* 然后写上  org.springframework.boot.autoconfigure.EnableAutoConfiguration=\该自动配置类的类名
* 然后把这个自动配置包和启动包安装到仓库中(注意安装顺序, 应该先安装被引用的依赖)
* (点击maven --> atguigu-spring-boot-starter(和atguigu-spring-boot-starter-autoconfigurer) --> Lifecycle --> install)
*
* */
public class HelloServiceAutoConfiguration {

    @Autowired
    HelloProperties helloProperties;

    @Bean
    public HelloService helloService(){
        HelloService service = new HelloService();
        service.setHelloProperties(helloProperties);
        return service;
        

    }
}
