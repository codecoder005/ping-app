package com.popcorn.controller;

import com.popcorn.api.RootAPI;
import jakarta.servlet.http.Cookie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class RootController implements RootAPI {
    @Override
    public ResponseEntity<Map<String, Object>> post(Map<String, Object> body) {
        log.info("RootController::post {}", body);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(body);
    }

    @Override
    public ResponseEntity<Map<String, Object>> subApi(
            String id, String authorization, String query, Map<String, Object> body,
            String userId, Cookie cookie
    ) {
        log.info("RootController::subApi id: {}", id);
        log.info("RootController::subApi authorization: {}", authorization);
        log.info("RootController::subApi q: {}", query);
        log.info("RootController::subApi body: {}", body);
        log.info("RootController::subApi userId: {}", userId);
        log.info("RootController::subApi cookie: {name: {}, value: {}}", cookie.getName(), cookie.getValue());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(body);
    }
}
