package com.touch.ayails.controller;

import com.touch.ayails.model.Role;
import com.touch.ayails.repository.RoleRepositoryI;
import com.touch.ayails.service.RoleService;
import org.hibernate.sql.ast.tree.expression.Over;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/role")
@PreAuthorize("denyAll()")
public class RoleController {

    @Autowired
    RoleService roleService;

    private final Logger logger = LoggerFactory.getLogger(RoleController.class);

//    CREATE
    @PreAuthorize("hasRole('DEVELOPER')")
    @PostMapping("/set")
    public Role setRole(@RequestBody Role role){
        logger.debug("RoleCC");
        return this.roleService.setRole(role);
    }

//    READ
    @PreAuthorize("permitAll()")
    @GetMapping("/get")
    public Iterable<Role> getRoles (){
        return roleService.getRoles();
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/get/{id}")
    public Optional<Role> getRole (@PathVariable("id") Long id){
        return roleService.getRole(id);
    }


//    UPDATE
    @PreAuthorize("hasRole('DEVELOPER')")
    @PostMapping("/update")
    public Role updateRole(@RequestBody Role role){
        logger.debug("RoleCU");
        return this.roleService.updateRole(role);
    }



//    DELETE

}
