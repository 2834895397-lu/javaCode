package com.jacklu.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //    表的id生成方案, 可选, 具体的策略可以查看@Table里面的注解
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    //    乐观锁的字段, 需要注册组件
    @Version
    private Integer version;

    //    逻辑删除, 还需要配置逻辑删除的bean
    @TableLogic
    private Integer deleted;

//    要写处理器处理这些注解

    //    插入的时候自动填充触发操作
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.UPDATE)
//    更新的时候自动填充触发操作
    private Date updateTime;
}
