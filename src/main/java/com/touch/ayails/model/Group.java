package com.touch.ayails.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="group_project", joinColumns = @JoinColumn(name = "group_id"), inverseJoinColumns = @JoinColumn(name="project_id"))
    private Set<Project> projects;
}
