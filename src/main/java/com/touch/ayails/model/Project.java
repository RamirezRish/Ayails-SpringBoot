package com.touch.ayails.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="project_product_backlog", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name="product_backlog_id"))
    private Set<ProductBacklog> productBacklogs;
}
