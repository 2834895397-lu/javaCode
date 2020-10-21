package com.atguigu.starter;

public class HelloService {
    //这个类要用到HelloProperties, 所以要设置getter和setter方法
    HelloProperties helloProperties;
    public String sayHelloAtguigu(String name){
        return helloProperties.getPrefix() + "-" + name + helloProperties.getSuffix();
    }

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }
}
