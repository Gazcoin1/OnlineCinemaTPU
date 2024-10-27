package com.OnlineCinema.OnlineCinema.mapper;

import com.OnlineCinema.OnlineCinema.dto.request.UserCreateRequest;
import com.OnlineCinema.OnlineCinema.dto.response.user.UserResponse;
import com.OnlineCinema.OnlineCinema.dto.response.user.UserShortResponse;
import com.OnlineCinema.OnlineCinema.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper {
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static User mapRegRequest(UserCreateRequest body) {
        User user = new User();
        user.setPhoneNumber(body.phoneNumber());
        user.setPassword(passwordEncoder.encode(body.password()));
        user.setLastName(body.lastName());
        user.setFirstName(body.firstName());
        user.setMiddleName(body.middleName());
        user.setEmail(body.email());
        user.setBirthDate(body.birthDate());
        user.setCreatedTime(LocalDateTime.now());
        user.setUpdatedTime(LocalDateTime.now());

        return user;
    }

    public static UserResponse mapUserToResponse(User user) {
        return new UserResponse(
                user.getId().toString(),
                user.getLastName(),
                user.getFirstName(),
                user.getMiddleName(),
                user.getPhoneNumber(),
                user.getEmail(),
                user.getBirthDate(),
                user.getCreatedTime(),
                user.getUpdatedTime()
        );
    }

    public static UserShortResponse mapUserToShortResponse(User user) {
        return new UserShortResponse(
                user.getLastName(),
                user.getFirstName(),
                user.getEmail(),
                user.getPhoneNumber()
        );
    }
}
