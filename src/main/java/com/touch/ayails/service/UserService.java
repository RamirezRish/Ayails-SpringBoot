package com.touch.ayails.service;

import com.touch.ayails.controller.dto.AuthCreateUserRequest;
import com.touch.ayails.controller.dto.AuthResponse;
import com.touch.ayails.controller.dto.UpdateUserRequest;
import com.touch.ayails.model.Role;
import com.touch.ayails.model.User;
import com.touch.ayails.repository.UserRepositoryI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    public ResponseEntity<User> getUserById(Long id){
//        return this.userRepositoryI.findById(id);
        return ResponseEntity.ok(this.userRepositoryI.findById(id).orElse(null));
    }

//    UPDATE
    public User updateUser(UpdateUserRequest userReq){
        Optional<User> user = this.userRepositoryI.findById(userReq.id());
        if(user.isPresent()){
            Set<Role> roles;
            User u = user.get();
            u.setUsername(userReq.username());
            u.setEmail(userReq.email());
            u.setPassword(userReq.password());

            return userRepositoryI.save(u);
        } else {
            logger.debug("User not found.");
        }

        return null;
    }

//    DELETE
}
