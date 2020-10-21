package com.jacklu.prototype;


import java.util.Date;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {

        //原型对象 v1
        Date date = new Date();
        Video v1 = new Video("柳钢集团", date);

        //通过v1克隆出来 v2(浅克隆, 导致时间指向同一个对象, 当改变其中的一个Date对象时, 两个都会受影响)
        //要实现深克隆可以在Clone方法内再进行属性的克隆
        Video v2 = (Video) v1.clone();
        date.setTime(2132423);
        System.out.println("v1=>" + v1);
        System.out.println("v1=>hashCode:" + v1.hashCode());

        System.out.println("v2=>" + v2);
        System.out.println("v2=>hashCode:" + v2.hashCode());






    }
}
