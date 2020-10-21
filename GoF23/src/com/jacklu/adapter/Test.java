package com.jacklu.adapter;

public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();//电脑
        Adapter adapter = new Adapter();//适配器
        computer.net(adapter);//电脑上网


        //test2
        Computer computer1 = new Computer();//电脑
        Adaptee adaptee = new Adaptee();//网线
        Adapter2 adapter2 = new Adapter2(adaptee);//适配器
        computer1.net(adapter2);

    }
}
