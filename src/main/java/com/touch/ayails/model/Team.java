package com.touch.ayails.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTeam;

    private String title;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="team_projects", joinColumns = @JoinColumn(name = "team_id"), inverseJoinColumns = @JoinColumn(name="project_id"))
    private Set<Project> projects;
}
