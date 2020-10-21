package com.atguigu.ext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.TestConstructor;

public class Test {

    @org.junit.Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);
        applicationContext.close();

    }
}
