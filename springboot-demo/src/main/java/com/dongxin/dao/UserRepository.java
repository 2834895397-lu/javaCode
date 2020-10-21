package com.dongxin.dao;

import com.dongxin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by huanggc on 2020/9/15.
 */
public interface UserRepository extends JpaRepository<User, String> {

    @Query("select u from User u where u.username = ?1")
    List<User> findByUsernameAndPassword(String username);

    @Query("select u from User u where u.username = ?1 and u.password = ?1")
    Boolean hasUser(User user);
}
