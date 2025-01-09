package com.touch.ayails.controller;


import com.touch.ayails.controller.dto.TeamResponse;
import com.touch.ayails.model.Project;
import com.touch.ayails.model.Team;
import com.touch.ayails.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/project")
@PreAuthorize("denyAll()")
public class ProjectController {

    @Autowired
    ProjectService projectService;


//    CREATE
    @PreAuthorize("permitAll()")
    @PostMapping("/set")
    public ResponseEntity<Project> setTeam(@RequestBody Project project){
        return projectService.setProject(project);
    }

//    READ
    @PreAuthorize("permitAll()")
    @GetMapping("/get/{id}")
    public ResponseEntity<Project> setTeam(@PathVariable Long id){
        return projectService.getProject(id);
    }
    @PreAuthorize("permitAll()")
    @GetMapping("/get")
    public ResponseEntity<List<Project>> getProjects(){
        return projectService.getProjects();
    }

//    UPDATE


//    DELETE



}
