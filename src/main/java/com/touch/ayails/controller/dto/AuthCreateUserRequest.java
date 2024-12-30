package com.touch.ayails.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthCreateUserRequest(
        @NotBlank String username,
        @NotBlank String password,
        @NotBlank String email,
        AuthCreateRoleRequest roleRequest
) {
}
