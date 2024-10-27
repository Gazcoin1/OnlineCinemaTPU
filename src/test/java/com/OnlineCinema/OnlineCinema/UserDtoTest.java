package com.OnlineCinema.OnlineCinema;

import com.OnlineCinema.OnlineCinema.dto.request.UserCreateRequest;
import com.OnlineCinema.OnlineCinema.dto.request.UserUpdateRequest;
import com.OnlineCinema.OnlineCinema.dto.response.user.UserResponse;
import com.OnlineCinema.OnlineCinema.dto.response.user.UserShortResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserDtoTest {
    @Test
    void testUserCreateRequest() {
        UserCreateRequest request = UserCreateRequest.builder()
                .phoneNumber("79991234567")
                .password("Password1!")
                .firstName("Иван")
                .lastName("Иванов")
                .middleName("Иванович")
                .email("ivanov@example.com")
                .birthDate(LocalDate.of(1990, 1, 1))
                .build();

        assertEquals("79991234567", request.phoneNumber());
        assertEquals("Password1!", request.password());
        assertEquals("Иван", request.firstName());
        assertEquals("Иванов", request.lastName());
        assertEquals("Иванович", request.middleName());
        assertEquals("ivanov@example.com", request.email());
        assertEquals(LocalDate.of(1990, 1, 1), request.birthDate());
    }

    @Test
    void testUserUpdateRequest() {
        UserUpdateRequest request = UserUpdateRequest.builder()
                .firstName("Иван")
                .lastName("Иванов")
                .middleName("Иванович")
                .birthdate(LocalDate.of(1990, 1, 1))
                .build();

        assertEquals("Иван", request.firstName());
        assertEquals("Иванов", request.lastName());
        assertEquals("Иванович", request.middleName());
        assertEquals(LocalDate.of(1990, 1, 1), request.birthdate());
    }

    @Test
    void testUserResponse() {
        UserResponse response = UserResponse.builder()
                .id("123e4567-e89b-12d3-a456-426614174000")
                .firstName("Иван")
                .lastName("Иванов")
                .middleName("Иванович")
                .phoneNumber("79991234567")
                .email("ivanov@example.com")
                .birthDate(LocalDate.of(1990, 1, 1))
                .createdTime(LocalDateTime.now())
                .updatedTime(LocalDateTime.now())
                .build();

        assertEquals("Иван", response.firstName());
        assertEquals("Иванов", response.lastName());
        assertEquals("Иванович", response.middleName());
        assertEquals("79991234567", response.phoneNumber());
        assertEquals("ivanov@example.com", response.email());
        assertEquals(LocalDate.of(1990, 1, 1), response.birthDate());
        assertNotNull(response.createdTime());
        assertNotNull(response.updatedTime());
    }

    @Test
    void testUserShortResponse() {
        UserShortResponse shortResponse = UserShortResponse.builder()
                .firstName("Иван")
                .lastName("Иванов")
                .phoneNumber("79991234567")
                .email("ivanov@example.com")
                .build();

        assertEquals("Иван", shortResponse.firstName());
        assertEquals("Иванов", shortResponse.lastName());
        assertEquals("79991234567", shortResponse.phoneNumber());
        assertEquals("ivanov@example.com", shortResponse.email());
    }
}
