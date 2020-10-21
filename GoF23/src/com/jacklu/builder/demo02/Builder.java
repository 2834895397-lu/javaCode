package com.jacklu.builder.demo02;

//建造者
public abstract class Builder {
    abstract Builder buildA(String msg);//汉堡
    abstract Builder buildB(String msg);//可乐
    abstract Builder buildC(String msg);//薯条
    abstract Builder buildD(String msg);//甜点

    abstract Product getProduct();
}
