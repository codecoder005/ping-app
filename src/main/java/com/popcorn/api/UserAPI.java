package com.popcorn.api;

import com.popcorn.dto.UserDto;
import com.popcorn.model.request.CreateUserRequest;
import com.popcorn.model.request.UpdateUserRequest;
import com.popcorn.model.response.CreateUserResponse;
import com.popcorn.model.response.DeleteUserResponse;
import com.popcorn.model.response.UpdateUserResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;


public interface UserAPI {
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request);

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Collection<UserDto>> getUsers();

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<UserDto> getUserByUserId(@PathVariable(name = "userId") UUID userId);

    @PutMapping(path = "/{userId}")
    ResponseEntity<UpdateUserResponse> updateUser(@PathVariable(name = "userId") UUID userId, @RequestBody UpdateUserRequest request);

    @DeleteMapping(path = "/{userId}")
    ResponseEntity<DeleteUserResponse> deleteUserByUserId(@PathVariable(name = "userId") UUID userId);
}
