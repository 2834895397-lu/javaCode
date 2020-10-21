package com.jacklu.factory.method;

public class TesLaFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new TesLa();
    }
}
