package com.jacklu.factory.simple;

public class Consumer {
    public static void main(String[] args) {

        //使用工厂创建
        Car car = CarFactory.getCar("五菱宏光");
        Car car1 = CarFactory.getCar("特斯拉");
        car.name();
        car1.name();
    }
}
