package com.touch.ayails.repository;

import com.touch.ayails.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryI extends JpaRepository<User, Long> {

    public abstract User findByEmail(String email);

    Optional<User> findUserByUsername(String username);

}
