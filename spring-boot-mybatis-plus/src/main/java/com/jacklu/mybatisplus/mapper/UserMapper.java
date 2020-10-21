package com.jacklu.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jacklu.mybatisplus.pojo.User;
import org.springframework.stereotype.Repository;

//在对应的Mapper上继承基本的类 BaseMapper
//也可以加
//也可以加@Mapper注解来表示是dao层的
@Repository
public interface UserMapper extends BaseMapper<User> {
    //所有的curd操作已经编写完成了
}
