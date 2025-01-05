package com.touch.ayails.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Set;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long duration;
    private String functionality;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="sprint_meet", joinColumns = @JoinColumn(name = "sprint_id"), inverseJoinColumns = @JoinColumn(name="meet_id"))
    private Set<Meet> meets;
}
