package com.jacklu.builder.demo02;

public class Test {
    public static void main(String[] args) {
        //服务员
        Worker worker = new Worker();
        //链式编程: 在原来的基础上, 就可以自由组合了, 如果不组合, 也有默认的套餐
        Product product = worker.buildA("全家桶").buildB("雪碧").getProduct();
        System.out.println(product);
    }
}
