package com.touch.ayails.service;

import com.touch.ayails.model.Project;
import com.touch.ayails.repository.ProjectRepositoryI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {


    @Autowired
    ProjectRepositoryI projectRepositoryI;

    private final Logger logger = LoggerFactory.getLogger(ProjectService.class);


//    CREATE
    public ResponseEntity<Project> setProject(Project project){
        return ResponseEntity.ok(projectRepositoryI.save(project));
    }

//    READ
    public ResponseEntity<Project> getProject(Long id){
        return ResponseEntity.ok(projectRepositoryI.findById(id).orElseThrow());
    }

    public ResponseEntity<List<Project>> getProjects(){
        return ResponseEntity.ok(projectRepositoryI.findAll());
    }

//    UPDATE


//    DELETE



}
