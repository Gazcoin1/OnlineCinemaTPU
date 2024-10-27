package com.OnlineCinema.OnlineCinema.dto.response.user;

import lombok.Builder;

@Builder
public record UserShortResponse(
        String lastName,
        String firstName,
        String email,
        String phoneNumber
) {
}
