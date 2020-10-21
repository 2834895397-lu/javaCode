package com.jacklu.builder.demo01;

//抽象的建造者: 方法
public abstract class Builder {
    abstract void buildA();//基地
    abstract void buildB();//钢筋工程
    abstract void buildC();//铺电线
    abstract void buildD();//粉刷

    //完工: 得到产品
    abstract Product getProduct();


}
