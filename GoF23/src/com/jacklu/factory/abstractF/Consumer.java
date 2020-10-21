package com.jacklu.factory.abstractF;

public class Consumer {
    public static void main(String[] args) {
        System.out.println("==================小米系列产品==================");
        IPhoneProduct phoneProduct = new XiaoMiFactory().phoneProduct();
        IRouterProduct routerProduct = new XiaoMiFactory().routerProduct();

        phoneProduct.start();
        phoneProduct.callup();
        phoneProduct.sendSMS();
        phoneProduct.shutdown();

        routerProduct.start();
        routerProduct.setting();
        routerProduct.openWifi();
        routerProduct.shutdown();


        System.out.println("==================华为系列产品==================");
        phoneProduct = new HuaWeiFactory().phoneProduct();
        routerProduct = new HuaWeiFactory().routerProduct();

        phoneProduct.start();
        phoneProduct.callup();
        phoneProduct.sendSMS();
        phoneProduct.shutdown();

        routerProduct.start();
        routerProduct.setting();
        routerProduct.openWifi();
        routerProduct.shutdown();
    }
}
