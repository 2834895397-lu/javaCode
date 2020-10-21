package com.jacklu.builder.demo01;

public class Test {
    public static void main(String[] args) {
        //指挥
        Directot directot = new Directot();
        //指挥 具体的工人完成 产品
        Product build = directot.build(new Worker());
        System.out.println(build.toString());

    }
}
