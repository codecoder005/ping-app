package com.popcorn.controller;

import com.popcorn.api.PingAPI;
import com.popcorn.api.UserAPI;
import com.popcorn.model.response.PingAPIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UserController implements PingAPI, UserAPI {
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
    public ResponseEntity<Map<String, Object>> getUsers() {
        log.info("UserController::getUsers");
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of(
                        "status", "200",
                        "timestamp", LocalDateTime.now()
                ));
    }
}
