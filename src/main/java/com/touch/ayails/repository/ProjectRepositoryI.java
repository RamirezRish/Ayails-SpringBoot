package com.touch.ayails.repository;

import com.touch.ayails.model.Project;
import com.touch.ayails.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepositoryI extends JpaRepository<Project, Long> {
}
