package com.example.userserver.controller;

import com.example.userserver.entities.Users;
import com.example.userserver.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("users")
    public Users addUser(@RequestBody Users users){
        return userService.save(users);
    }

    @GetMapping("users")
    public Iterable<Users> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("users/{id}")
    public Optional<Users> getUser(@PathVariable String id){
        return userService.findUser(id);
    }
}
