package com.jacklu.bridge;


//抽象的电脑类型
public abstract class Computer {
    //组合, 品牌   桥
    protected Brand brand;

    public Computer(Brand brand){
        this.brand = brand;
    }

    public void info(){
        brand.info();//自带品牌
    }



    static class DeskTop extends Computer{

            public DeskTop(Brand brand) {
                super(brand);
            }

        @Override
        public void info() {
            super.info();
            System.out.println("台式机");
        }
    }
    static class LapTop extends Computer{

        public LapTop(Brand brand) {
            super(brand);
        }

        @Override
        public void info() {
            super.info();
            System.out.println("笔记本");
        }
    }
}
