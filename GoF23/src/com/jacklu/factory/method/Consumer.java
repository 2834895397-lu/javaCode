package com.jacklu.factory.method;

public class Consumer {
    public static void main(String[] args) {
        Car car = new WuLingFactory().getCar();
        Car car1 = new TesLaFactory().getCar();
        Car car2 = new MobaiFactory().getCar();

        car.name();
        car1.name();
        car2.name();


        //根据设计原则: 工厂方法模式
        //根据实际业务: 简单工厂模式
    }
}
