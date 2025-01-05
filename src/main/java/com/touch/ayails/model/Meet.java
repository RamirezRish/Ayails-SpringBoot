package com.touch.ayails.model;

import com.touch.ayails.enums.ScrumTypeEnum;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Meet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ScrumTypeEnum scrum_type;
    private Long duration;
    private List<String> goals;
    private String format;
    private String access;
    private Time time;
    private List<String> notes;
}
