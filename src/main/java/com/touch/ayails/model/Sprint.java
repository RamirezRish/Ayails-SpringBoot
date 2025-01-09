package com.touch.ayails.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Set;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sprintId;

    private Long duration;
    private String functionality;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="sprint_meets", joinColumns = @JoinColumn(name = "sprint_id"), inverseJoinColumns = @JoinColumn(name="meet_id"))
    private Set<Meet> meets;
}
