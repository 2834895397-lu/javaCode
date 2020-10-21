package com.jacklu.bridge;

public class Test {
    public static void main(String[] args) {
        //苹果笔记本
        Computer computer = new Computer.LapTop(new Apple());
        computer.info();

        //联想台式机
        Computer computer2 = new Computer.DeskTop(new Lenovo());
        computer2.info();

    }
}
