package com.OnlineCinema.OnlineCinema.dto.response.session;

import lombok.Builder;

import java.util.Date;
import java.util.UUID;

@Builder
public record ActiveSessionResponse(
        UUID id,
        UUID userId,
        Date expirationTime,
        Boolean isActive
) {
}
