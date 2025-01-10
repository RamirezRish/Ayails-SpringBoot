package com.touch.ayails.controller.dto;

import java.util.Set;

public record TeamCreateRequest(
        String title,
        Set<Long> idMembers
) {
}
