package com.jacklu.factory.method;

public class MobaiFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Mobai();
    }
}
