package com.touch.ayails.service;


import com.touch.ayails.controller.dto.TeamCreateRequest;
import com.touch.ayails.controller.dto.TeamResponse;
import com.touch.ayails.model.ProductBacklog;
import com.touch.ayails.model.Project;
import com.touch.ayails.model.Team;
import com.touch.ayails.repository.TeamRepositoryI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TeamService {

    @Autowired
    TeamRepositoryI teamRepositoryI;

    private final Logger logger = LoggerFactory.getLogger(TeamService.class);


    private TeamResponse convert(Team team){
        if(team.getProjects() == null){
            return new TeamResponse(
                    team.getIdTeam(),
                    team.getTitle(),
                    null,
                    null
            );
        } else {
            return new TeamResponse(
                    team.getIdTeam(),
                    team.getTitle(),
                    team.getProjects().stream()
                            .map(Project::getProjectId)
                            .toList(),
                    team.getProjects().stream()
                            .map(Project::getTitle)
                            .toList()
            );
        }
    }

//    CREATE
    public ResponseEntity<TeamResponse> setTeam(TeamCreateRequest teamCreateRequest){
        Team team = this.teamRepositoryI.save(
                Team.builder()
                        .title(teamCreateRequest.title())
                        .idMembers(teamCreateRequest.idMembers())
                        .build()
        );
        return ResponseEntity.ok(convert(team));
    }

//    READ
    public ResponseEntity<TeamResponse> getTeam(Long id){
        return ResponseEntity.ok(convert(this.teamRepositoryI.findById(id).orElseThrow()));
    }

    public ResponseEntity<List<Team>> getTeams(){
        return ResponseEntity.ok(teamRepositoryI.findAll());
    }

//    UPDATE


//    DELETE



}
