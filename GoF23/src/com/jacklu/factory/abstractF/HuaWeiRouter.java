package com.jacklu.factory.abstractF;

public class HuaWeiRouter implements IRouterProduct {
    @Override
    public void start() {
        System.out.println("启动华为路由器");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭华为路由器");
    }

    @Override
    public void openWifi() {
        System.out.println("打开华为路wifi");
    }

    @Override
    public void setting() {
        System.out.println("华为设置");
    }
}
