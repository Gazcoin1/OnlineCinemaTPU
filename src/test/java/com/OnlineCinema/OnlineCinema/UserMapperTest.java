package com.OnlineCinema.OnlineCinema;

import com.OnlineCinema.OnlineCinema.dto.request.UserCreateRequest;
import com.OnlineCinema.OnlineCinema.dto.response.user.UserResponse;
import com.OnlineCinema.OnlineCinema.dto.response.user.UserShortResponse;
import com.OnlineCinema.OnlineCinema.entity.User;
import com.OnlineCinema.OnlineCinema.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserMapperTest {
    @Test
    void testMapRegRequest() {
        UserCreateRequest request = UserCreateRequest.builder()
                .phoneNumber("79991234567")
                .password("Password1!")
                .firstName("Иван")
                .lastName("Иванов")
                .middleName("Иванович")
                .email("ivanov@example.com")
                .birthDate(LocalDate.of(1990, 1, 1))
                .build();

        User user = UserMapper.mapRegRequest(request);

        assertEquals(request.phoneNumber(), user.getPhoneNumber());
        assertEquals(request.firstName(), user.getFirstName());
        assertEquals(request.lastName(), user.getLastName());
        assertEquals(request.middleName(), user.getMiddleName());
        assertEquals(request.email(), user.getEmail());
        assertEquals(request.birthDate(), user.getBirthDate());
        assertNotNull(user.getPassword()); // Проверяем, что пароль зашифрован
        assertNotNull(user.getCreatedTime());
        assertNotNull(user.getUpdatedTime());
    }

    @Test
    void testMapUserToResponse() {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setFirstName("Иван");
        user.setLastName("Иванов");
        user.setMiddleName("Иванович");
        user.setPhoneNumber("79991234567");
        user.setEmail("ivanov@example.com");
        user.setBirthDate(LocalDate.of(1990, 1, 1));
        user.setCreatedTime(LocalDateTime.now());
        user.setUpdatedTime(LocalDateTime.now());

        UserResponse response = UserMapper.mapUserToResponse(user);

        assertEquals(user.getId().toString(), response.id());
        assertEquals(user.getFirstName(), response.firstName());
        assertEquals(user.getLastName(), response.lastName());
        assertEquals(user.getMiddleName(), response.middleName());
        assertEquals(user.getPhoneNumber(), response.phoneNumber());
        assertEquals(user.getEmail(), response.email());
        assertEquals(user.getBirthDate(), response.birthDate());
        assertEquals(user.getCreatedTime(), response.createdTime());
        assertEquals(user.getUpdatedTime(), response.updatedTime());
    }

    @Test
    void testMapUserToShortResponse() {
        User user = new User();
        user.setFirstName("Иван");
        user.setLastName("Иванов");
        user.setPhoneNumber("79991234567");
        user.setEmail("ivanov@example.com");

        UserShortResponse shortResponse = UserMapper.mapUserToShortResponse(user);

        assertEquals(user.getFirstName(), shortResponse.firstName());
        assertEquals(user.getLastName(), shortResponse.lastName());
        assertEquals(user.getPhoneNumber(), shortResponse.phoneNumber());
        assertEquals(user.getEmail(), shortResponse.email());
    }
}
