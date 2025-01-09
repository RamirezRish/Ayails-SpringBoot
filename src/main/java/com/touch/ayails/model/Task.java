package com.touch.ayails.model;

import com.touch.ayails.enums.TaskPriorityEnum;
import com.touch.ayails.enums.TaskStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Long responsible;
    private TaskStatusEnum status;
    private TaskPriorityEnum priority;
    private String description;
    private String observation;
    private String devDoubts;
    private Date timeLimit;

}
