package com.OnlineCinema.OnlineCinema.dto.response.session;

import lombok.Builder;

@Builder
public record DeleteSessionResponse(
        String message
) {
}
