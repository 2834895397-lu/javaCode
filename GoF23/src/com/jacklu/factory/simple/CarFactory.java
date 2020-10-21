package com.jacklu.factory.simple;

//静态工厂, 增加一个新产品, 如果不修改代码是做不到的
public class CarFactory {
    //方法一
    public static Car getCar(String carName) {
        if (carName.equals("五菱宏光")) {
            return new WuLing();
        } else if (carName.equals("特斯拉")) {
            return new TesLa();
        } else {
            return null;
        }

    }

    //方法二
    public static Car getWuling() {
        return new WuLing();
    }

    public static Car getTesLa() {
        return new TesLa();
    }
}
