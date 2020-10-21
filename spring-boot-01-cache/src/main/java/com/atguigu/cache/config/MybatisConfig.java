package com.atguigu.cache.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {

    /*
    * 也可以参照MybatisAutoConfiguration的自动配置, 看它的MybatisProperties
    * yml文件配置: mybatis.configuration.mapUnderscoreToCamelCase=true
    * */
   /* @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer(){
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };

    }
*/


}
