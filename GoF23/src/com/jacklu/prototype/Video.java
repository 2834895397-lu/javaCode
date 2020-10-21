package com.jacklu.prototype;

import java.util.Date;

//要使一个类能够被克隆, 必须实现Cloneable接口
public class Video implements Cloneable{
    //重写clone方法, 也可以不写, 因为Object类默认就是调用native本地方法(c++的)
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //实现深度克隆 ( 或者也可以进行序列化和反序列化来实现深度克隆 ), 把属性也单独的克隆一份
        Video clone = (Video) super.clone();
        clone.setCreateTime((Date) this.createTime.clone());
        return clone;
    }

    private String name;
    private Date createTime;

    public Video() {
    }

    @Override
    public String toString() {
        return "Vidio{" +
                "name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Video(String name, Date createTime) {
        this.name = name;
        this.createTime = createTime;
    }
}
