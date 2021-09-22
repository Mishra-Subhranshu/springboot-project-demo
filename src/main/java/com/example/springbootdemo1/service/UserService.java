package com.example.springbootdemo1.service;

import com.example.springbootdemo1.entity.User;
import com.example.springbootdemo1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        List<User> userList=new ArrayList<>();
        userRepository.findAll().forEach(user ->userList.add(user));
        return userList;
    }

    public void postUsers(User user) {
         userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user, long id) {
        return userRepository.findById(id)
                .map(user1 -> {
                    user1.setUserName(user.getUserName());
                    user1.setEmail(user.getEmail());
                    return userRepository.save(user1);
                })
                .orElseGet(() ->{
                    user.setId(id);
                    return userRepository.save(user);
                });
    }
}
