package com.atguigu.elastic;

import com.atguigu.elastic.bean.Article;
import io.searchbox.client.JestClient;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot03ElasticApplicationTests {

    @Autowired
    JestClient jestClient;

    @Test
    void contextLoads() {
        //1. 给es索引(保存)一个文档
        Article article = new Article();
        article.setId(1);
        article.setTitle("好消息");
        article.setAuthor("zhangsan");
        article.setContent("hello world");

        //构建一个索引
        Index index = new Index.Builder(article).index("atguigu").type("news").build();
       try {
           jestClient.execute(index);

       }catch (Exception e){
           e.printStackTrace();

       }


    }

}
