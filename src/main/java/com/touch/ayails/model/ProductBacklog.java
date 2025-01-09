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
public class ProductBacklog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productBacklogId;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="product_backlog_sprint", joinColumns = @JoinColumn(name = "product_backlog_id"), inverseJoinColumns = @JoinColumn(name="sprint_id"))
    private Set<Sprint> sprints;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="product_backlog_tasks", joinColumns = @JoinColumn(name = "product_backlog_id"), inverseJoinColumns = @JoinColumn(name="task_id"))
    private Set<Task> tasks;
}
