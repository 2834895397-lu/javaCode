package com.atguigu.springboot;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot03LoggingApplicationTests {

    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());



    @Test
    void contextLoads() {
        //日志的级别
        //由高到低: trace < debug < info < warn < error
        //可以调整输出的日志级别; 日志就只会在这个级别及以后的高级别生效
        logger.trace("这是trace日志...");
        logger.debug("这是debug日志...");
        //spring默认给我们使用的是info级别的, 没有指定级别的就用(可以在properties文件中指定使用日志的级别)
        //springboot默认规定的级别(root/info)

        /*
        * logging.level.com.atguigu=trace  (改变com.atguigu包下的日志级别)
        * */
        logger.info("这是info日志...");
        logger.warn("这是warn日志...");
        logger.error("这是error日志...");
    }

}
