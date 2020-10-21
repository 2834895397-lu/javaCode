package com.atguigu.springboot.repository;

import com.atguigu.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
*   继承JpaReposirtory接口来对数据库进行操作
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
