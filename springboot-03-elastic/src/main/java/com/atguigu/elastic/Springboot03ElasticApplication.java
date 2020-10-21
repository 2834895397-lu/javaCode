package com.atguigu.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* springboot默认支持两种技术和es交互
*   1. jest(默认不生效)
*        需要导入的工具包(io.searchbox.client.JestClient)
*   2. SpringData Elasticsearch操作es[es版本有可能不合适]
*           如果版本不适配, 可以升级springboot版本或者安装对应版本的es
*           1). Client节点信息clusternodes; clusterName
*           2).ElasticsearchTemplate操作es
*           3). 编写一个ElasticsearchRepository的子接口来操作es
*
* */
@SpringBootApplication
public class Springboot03ElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03ElasticApplication.class, args);
    }

}
