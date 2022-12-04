package com.example.userserver.repository;

import com.example.userserver.entities.Users;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<Users,String>{
}
