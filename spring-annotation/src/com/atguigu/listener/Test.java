package com.atguigu.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
* 自己发布事件的步骤:
*   1. 写一个监听器来监听某个事件(事件必须是ApplicationEvent及其子类)
*   2. 把监听器加入到容器中;
*   3. 只要容器中有相关事件的发布, 我们就能监听到这个事件
*
*
* 发布事件:
*   通过上下文的publishEvent方法来发布
*
* */


public class Test {
    @org.junit.Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyApplicationListener.class);

        //发布一个事件:
        applicationContext.publishEvent(new ApplicationEvent(new String("我发布的事件")){

        });



        applicationContext.close();

    }
}
