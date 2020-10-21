package com.jacklu.builder.demo01;

//指挥: 核心. 负责构建一个工程, 工程如何构建, 由他决定
public class Directot {

    //指挥工人按照顺序建房子
    public Product build(Builder builder){
        builder.buildA();
        builder.buildB();
        builder.buildC();
        builder.buildD();
        return builder.getProduct();
    }

}
