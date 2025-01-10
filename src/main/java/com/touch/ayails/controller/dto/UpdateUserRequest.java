package com.touch.ayails.controller.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UpdateUserRequest(
        @NotBlank Long id,
        @NotBlank String username,
        @NotBlank String email,
        @NotBlank String password,
        List<Long> idTeams) {
}
