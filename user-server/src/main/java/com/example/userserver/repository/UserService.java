package com.example.userserver.repository;


import com.example.userserver.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Users save(Users user){
        return userRepository.save(user);
    }

    public Optional<Users> findUser(String id){
        return userRepository.findById(id);
    }

    public Iterable<Users> getUsers(){
        return userRepository.findAll();
    }
}
