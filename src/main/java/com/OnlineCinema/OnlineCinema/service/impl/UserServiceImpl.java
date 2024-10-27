package com.OnlineCinema.OnlineCinema.service.impl;

import com.OnlineCinema.OnlineCinema.dto.request.UserCreateRequest;
import com.OnlineCinema.OnlineCinema.dto.request.UserUpdateRequest;
import com.OnlineCinema.OnlineCinema.dto.response.TokenResponse;
import com.OnlineCinema.OnlineCinema.dto.response.user.UserResponse;
import com.OnlineCinema.OnlineCinema.dto.response.user.UserShortResponse;
import com.OnlineCinema.OnlineCinema.entity.User;
import com.OnlineCinema.OnlineCinema.mapper.UserMapper;
import com.OnlineCinema.OnlineCinema.repository.UserRepository;
import com.OnlineCinema.OnlineCinema.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final JwtTokenUtils jwtTokenUtils;

    @Transactional
    public TokenResponse createUser(UserCreateRequest body) {
        User user = UserMapper.mapRegRequest(body);
        log.info(user.toString());
        isUserCreated(user);

        userRepository.save(user);

        String token = jwtTokenUtils.generateToken(user);

        log.info(token);

        return TokenResponse.builder().token(token).build();
    }

    private void isUserCreated(User user) {
        if (user.getFirstName() == null) {
            throw new UsernameNotFoundException("User is not created");
        }
    }

    public UserResponse getUserResponse(Authentication authentication) {
        UUID id = jwtTokenUtils.getUserIdFromAuthentication(authentication);
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return UserMapper.mapUserToResponse(user);

    }

    public User getUserByAuthentication(Authentication authentication) {
        UUID id = jwtTokenUtils.getUserIdFromAuthentication(authentication);
        return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    //ЕЩЕ АПДЕЙТ ЮЗЕР И ГЕТ ЮЗЕР ШОРТ ИНФО

    public UserShortResponse getUserShortResponse(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return UserMapper.mapUserToShortResponse(user);
    }

    public UserResponse updateUser(UserUpdateRequest body, Authentication authentication) {
        UUID id = jwtTokenUtils.getUserIdFromAuthentication(authentication);
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (body.firstName() != null) {
            user.setFirstName(body.firstName());
        }
        if (body.lastName() != null) {
            user.setFirstName(body.lastName());
        }
        if (body.middleName() != null) {
            user.setFirstName(body.middleName());
        }
        if (body.birthdate() != null) {
            user.setBirthDate(body.birthdate());
        }

        user.setUpdatedTime(LocalDateTime.now());
        userRepository.save(user);
        return UserMapper.mapUserToResponse(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
