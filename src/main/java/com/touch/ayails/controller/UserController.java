package com.touch.ayails.controller;

import com.touch.ayails.controller.dto.AuthCreateUserRequest;
import com.touch.ayails.controller.dto.AuthResponse;
import com.touch.ayails.controller.dto.UpdateUserRequest;
import com.touch.ayails.model.User;
import com.touch.ayails.repository.UserRepositoryI;
import com.touch.ayails.service.UserDetailsServiceImpl;
import com.touch.ayails.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@PreAuthorize("denyAll()")
public class UserController {

//    @Autowired
//    UserRepositoryI userRepositoryI;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    UserService userService;

//    CREATE
    @PreAuthorize("dennyAll()")
    @PostMapping("/set")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return userService.createUser(user);
    }

//    READ
    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/get")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PreAuthorize("hasRole('DEVELOPER')")
    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        return this.userService.getUserById(id);
//        return userService.getUsers();
    }

//    UPDATE
    @PreAuthorize("permitAll()")
    @PostMapping("/update")
    public ResponseEntity<User> user(@RequestBody UpdateUserRequest userReq){
        return new ResponseEntity<>(this.userService.updateUser(userReq), HttpStatus.ACCEPTED);
    }


//    DELETE

}
