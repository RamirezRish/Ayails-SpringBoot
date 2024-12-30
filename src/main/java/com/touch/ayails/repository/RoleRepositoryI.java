package com.touch.ayails.repository;

import com.touch.ayails.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepositoryI extends CrudRepository<Role,Long> {

    List<Role> findRolesByRoleEnumIn(List<String> roleNames);

}
