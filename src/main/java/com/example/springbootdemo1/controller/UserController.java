package com.example.springbootdemo1.controller;

import com.example.springbootdemo1.entity.User;
import com.example.springbootdemo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
   private UserService userService;

    @PostMapping("/post")
    public long postAll(@Valid @RequestBody User user) {
        userService.postUsers(user);
        return user.getId();
    }

    @GetMapping("/get")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return "Deleted Successfully id "+id;
    }

    @PutMapping("/put/{id}")
    public String updateUser(@RequestBody User user, @PathVariable long id) {
        userService.updateUser(user, id);
        return "updated successfully "+id;
    }
}
