package com.touch.ayails.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateUserRequest(
        @NotBlank Long id,
        @NotBlank String username,
        @NotBlank String email,
        @NotBlank String password) {
}
