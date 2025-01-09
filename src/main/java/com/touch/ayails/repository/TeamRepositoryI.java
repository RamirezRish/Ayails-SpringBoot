package com.touch.ayails.repository;

import com.touch.ayails.model.Team;
import com.touch.ayails.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepositoryI extends JpaRepository<Team, Long> {
}
