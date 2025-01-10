package com.touch.ayails.service;

import com.touch.ayails.controller.dto.UpdateUserRequest;
import com.touch.ayails.model.Team;
import com.touch.ayails.model.User;
import com.touch.ayails.repository.TeamRepositoryI;
import com.touch.ayails.repository.UserRepositoryI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepositoryI userRepositoryI;

    @Autowired
    TeamRepositoryI teamRepositoryI;

    private final Logger logger = LoggerFactory.getLogger(UserService.class);


//    CREATE
    public ResponseEntity<User> createUser(User user){
//        return userRepositoryI.save(user);
        return ResponseEntity.ok(userRepositoryI.save(user));
    }


//    READ
    public List<User> getUsers(){
        return userRepositoryI.findAll();
    }

    public ResponseEntity<User> getUserById(Long id){
//        return this.userRepositoryI.findById(id);
        return ResponseEntity.ok(this.userRepositoryI.findById(id).orElse(null));
    }

//    UPDATE
    public User updateUser(UpdateUserRequest userReq){
        Optional<User> user = this.userRepositoryI.findById(userReq.id());



        if(user.isPresent()){
//            Set<Role> roles;
            User u = user.get();
            u.setUsername(userReq.username());
            u.setEmail(userReq.email());
            u.setPassword(userReq.password());

            try {
                if (!userReq.idTeams().isEmpty()) {
                    Set<Team> teams = new HashSet<>();
                    for (Long idTeam : userReq.idTeams()){
                        try {
                            Team team = teamRepositoryI.findById(idTeam).get();
                            logger.debug(String.valueOf(team));
                            Set<Long> idMembers = team.getIdMembers();
                            idMembers.add(userReq.id());
                            team.setIdMembers(idMembers);
                            teams.add(team);
                        } catch (Error err){
                            logger.debug("1 instance");
                            logger.error(String.valueOf(err));
                        }
                    }
                    u.setTeams(teams);
                }
            } catch (Error error){
                logger.debug("2 instance");
                logger.error(String.valueOf(error));

            }

            return userRepositoryI.save(u);
        } else {
            logger.debug("User not found.");
        }

        return null;
    }

//    DELETE
}
