package com.touch.ayails.controller.dto;

import com.touch.ayails.model.ProductBacklog;
import com.touch.ayails.model.Project;

import java.util.List;
import java.util.Set;

public record TeamResponse(
        Long idTeam,
        String title,
        List<Long> idProjects,
        List<String> titleProjects
) {
}
