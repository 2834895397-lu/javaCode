package com.jacklu.adapter;

/**
 * 1. 继承: (类适配器, 单继承, 具有一定的局限性)
 * 2. 组合: (对象适配器, 常用)
 */


//真正的适配器, 需要连接电脑, 连接网线
public class Adapter extends Adaptee implements NetToUsb {
    @Override
    public void handleRequest() {
            super.request();//可以上网了
    }
}
