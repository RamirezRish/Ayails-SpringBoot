package com.touch.ayails.controller.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"username","message","jwt", "id","status"})
public record AuthResponse(
        String username,
        String message,
        String jwt,
        Long id,
        boolean status
) {
}
