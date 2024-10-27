package com.popcorn.controller;

import com.popcorn.api.PingAPI;
import com.popcorn.api.UserAPI;
import com.popcorn.dto.UserDto;
import com.popcorn.entity.UserEntity;
import com.popcorn.mapper.UserMapper;
import com.popcorn.model.request.CreateUserRequest;
import com.popcorn.model.request.UpdateUserRequest;
import com.popcorn.model.response.CreateUserResponse;
import com.popcorn.model.response.DeleteUserResponse;
import com.popcorn.model.response.PingAPIResponse;
import com.popcorn.model.response.UpdateUserResponse;
import com.popcorn.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController implements PingAPI, UserAPI {
    private final UserRepository userRepository;

    @Override
    public PingAPIResponse ping() {
        log.info("UserController::Ping API");
        return PingAPIResponse.builder()
                .message("Up and running")
                .status(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @Override
    public ResponseEntity<CreateUserResponse> createUser(CreateUserRequest request) {
        log.info("UserController::CreateUser API");
        var createdUser = userRepository.save(
                UserEntity.builder()
                        .name(request.getName())
                        .email(request.getEmail())
                        .build()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(
                CreateUserResponse.builder()
                        .userId(createdUser.getUserId())
                        .build()
        );
    }

    @Override
    public ResponseEntity<Collection<UserDto>> getUsers() {
        log.info("UserController::getUsers API");
        var users = userRepository.findAll().stream().map(UserMapper::map).toList();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @Override
    public ResponseEntity<UserDto> getUserByUserId(UUID userId) {
        log.info("UserController::getUserById API");
        return ResponseEntity.status(HttpStatus.OK)
                .body(userRepository.findById(userId).map(UserMapper::map).orElse(null));
    }

    @Override
    @Transactional
    public ResponseEntity<UpdateUserResponse> updateUser(UUID userId, UpdateUserRequest request) {
        var existingUser = userRepository.findById(userId).orElse(null);
        if(existingUser == null) {
            return ResponseEntity.status(HttpStatus.OK).body(UpdateUserResponse.builder().message("user not found").build());
        }
        existingUser.setName(request.getName());
        existingUser.setEmail(request.getEmail());
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(UpdateUserResponse.builder().message("Details updated").build());
    }

    @Override
    public ResponseEntity<DeleteUserResponse> deleteUserByUserId(UUID userId) {
        log.info("UserController::deleteUserById API");
        userRepository.deleteById(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(DeleteUserResponse.builder().userId(userId).deletedAt(LocalDateTime.now()).build());
    }
}
