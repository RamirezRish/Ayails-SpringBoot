package com.touch.ayails.service;

import com.touch.ayails.controller.dto.AuthCreateUserRequest;
import com.touch.ayails.controller.dto.AuthResponse;
import com.touch.ayails.model.User;
import com.touch.ayails.repository.UserRepositoryI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepositoryI userRepositoryI;

    private final Logger logger = LoggerFactory.getLogger(UserService.class);


//    CREATE
    public ResponseEntity<User> createUser(User user){
//        return userRepositoryI.save(user);
        return ResponseEntity.ok(userRepositoryI.save(user));
    }


//    READ
    public List<User> getUsers(){
        return userRepositoryI.findAll();
    }


//    UPDATE


//    DELETE
}
