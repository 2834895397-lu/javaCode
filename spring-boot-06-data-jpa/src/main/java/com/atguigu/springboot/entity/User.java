package com.atguigu.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

//使用jpa注解配置映射关系
@Entity//告诉jpa这是一个实体类(和数据表映射的类)
@Table(name = "tbl_user")//@table用来指定和哪个数据表对应, 如果是缺省默认表名就是user
//当查出来的时候, 发现有null字段的时候, 在转化为json的时候会报错, 所以加上
//@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler")注解防止这类情况的报错
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class User {
    @Id//这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;
    @Column(name = "last_name", length = 50)//这是和数据表对应的一个列
    private String lastName;
    @Column//缺省默认列名就是属性名
    private String email;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public User(Integer id, String lastName, String email) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
