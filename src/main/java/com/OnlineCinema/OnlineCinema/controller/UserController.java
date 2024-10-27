package com.OnlineCinema.OnlineCinema.controller;

import com.OnlineCinema.OnlineCinema.dto.request.UserCreateRequest;
import com.OnlineCinema.OnlineCinema.dto.request.UserUpdateRequest;
import com.OnlineCinema.OnlineCinema.dto.response.TokenResponse;
import com.OnlineCinema.OnlineCinema.dto.response.user.UserResponse;
import com.OnlineCinema.OnlineCinema.dto.response.user.UserShortResponse;
import com.OnlineCinema.OnlineCinema.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("cinema")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping("/user")
    public TokenResponse register(@RequestBody @Valid UserCreateRequest body) {
        return userService.createUser(body);
    }

    @GetMapping("/user")
    public UserResponse getProfile(Authentication authentication) {
        return userService.getUserResponse(authentication);
    }

    @GetMapping("/user/{userId}")
    public UserShortResponse findById(@PathVariable String userId) {
        UUID id = UUID.fromString(userId);
        return userService.getUserShortResponse(id);
    }

    @PatchMapping("/user")
    public UserResponse updateUserInfo(@RequestBody @Valid UserUpdateRequest body, Authentication authentication) {
        return userService.updateUser(body, authentication);
    }
}
