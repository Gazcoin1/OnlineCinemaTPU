package com.OnlineCinema.OnlineCinema.dto.response.user;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record UserResponse(
        String id,
        String lastName,
        String firstName,
        String middleName,
        String phoneNumber,
        String email,
        LocalDate birthDate,
        LocalDateTime createdTime,
        LocalDateTime updatedTime
) {
}
