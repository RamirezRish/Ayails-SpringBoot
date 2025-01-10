package com.touch.ayails.controller;

import com.touch.ayails.controller.dto.TeamCreateRequest;
import com.touch.ayails.controller.dto.TeamResponse;
import com.touch.ayails.model.Team;
import com.touch.ayails.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
@PreAuthorize("denyAll()")
public class TeamController {

    @Autowired
    TeamService teamService;


//    CREATE
//                  ünico que puede crear team es SCRUM_MASTER
    @PreAuthorize("permitAll()")
    @PostMapping("/set")
    public ResponseEntity<TeamResponse> setTeam(@RequestBody TeamCreateRequest teamCreateRequest){
        return teamService.setTeam(teamCreateRequest);
    }

//    READ
    @PreAuthorize("permitAll()")
    @GetMapping("/get/{id}")
    public ResponseEntity<TeamResponse> getTeam(@PathVariable Long id){
        return teamService.getTeam(id);
    }
    @PreAuthorize("permitAll()")
    @GetMapping("/get")
    public ResponseEntity<List<Team>> getTeams(){
        return teamService.getTeams();
    }


//    UPDATE


//    DELETE



}
