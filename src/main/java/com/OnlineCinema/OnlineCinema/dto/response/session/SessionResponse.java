package com.OnlineCinema.OnlineCinema.dto.response.session;

import lombok.Builder;

import java.util.Date;
import java.util.UUID;

@Builder
public record SessionResponse(
        UUID id,
        UUID userId,
        String token,
        Date expirationTime
) {
}
