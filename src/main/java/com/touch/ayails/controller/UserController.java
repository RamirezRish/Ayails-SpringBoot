package com.touch.ayails.controller;

import com.touch.ayails.repository.UserRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@PreAuthorize("denyAll()")
public class UserController {

    @Autowired
    UserRepositoryI userRepositoryI;

//    CREATE
//    READ
//    UPDATE
//    DELETE

}
