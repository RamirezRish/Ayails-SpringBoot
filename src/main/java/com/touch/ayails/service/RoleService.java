package com.touch.ayails.service;

import com.touch.ayails.model.Role;
import com.touch.ayails.repository.RoleRepositoryI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepositoryI roleRepositoryI;

    private final Logger logger = LoggerFactory.getLogger(RoleService.class);


    //    CREATE
    public Role setRole(Role role){
        return roleRepositoryI.save(role);
    }

//    READ
    public Iterable<Role> getRoles(){
        Iterable<Role> roles = roleRepositoryI.findAll();
        return roles;
    }
    public Optional<Role> getRole(Long id){
        return roleRepositoryI.findById(id);
    }

//    UPDATE
    public Role updateRole(Role role){
        try{
            logger.debug("RoleSU");
            return this.roleRepositoryI.save(role);
        } catch (Error error){
            logger.debug("Error update");
            return null;
        }
    }


//    DELETE


}
