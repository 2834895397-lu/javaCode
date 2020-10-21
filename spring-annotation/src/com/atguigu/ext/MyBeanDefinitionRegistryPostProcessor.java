package com.atguigu.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/*
 * 工作的优先顺序:
 *      首先是BeanDefinitionRegistryPostProcessor
 *      然后是eanFactoryPostProcessor
 *      然后才是bean的实例化(执行bean的构造方法)
 *
 *
 * */


@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    /*
    * BeanDefinitionRegistry: bean定义信息的保存中心(bean是单例的还是多例的, bean的类型, bean的id等等都是存储在BeanDefinitionRegistry里面),
    * 以后BeanFactory就是按照BeanDefinitionRegistry里面保存的每一个bean定义信息创建bean实例的
    * */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor....bean的数量:" + registry.getBeanDefinitionCount());
        RootBeanDefinition beanDefinition = new RootBeanDefinition(Blue.class);
        registry.registerBeanDefinition("hello", beanDefinition);

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor....bean的数量:" + beanFactory.getBeanDefinitionCount());

    }
}
