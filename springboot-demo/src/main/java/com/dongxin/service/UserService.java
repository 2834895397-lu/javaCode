package com.dongxin.service;

import com.dongxin.dao.UserRepository;
import com.dongxin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huanggc on 2020/9/15.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public List<User> findByUsernameAndPassword(User u) {
        if(u.getUsername() == null){
            return findAllUsers();
        }
        return userRepository.findByUsernameAndPassword(u.getUsername());
    }

    public void save(User u) {
        userRepository.save(u);
    }

    public boolean hasUser(User user) {
        return userRepository.hasUser(user);
    }
}
