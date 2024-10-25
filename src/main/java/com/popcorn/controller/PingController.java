package com.popcorn.controller;

import com.popcorn.api.PingAPI;
import com.popcorn.model.response.PingAPIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class PingController implements PingAPI {
    @Override
    public PingAPIResponse ping() {
        log.info("PingController::ping");
        return PingAPIResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(200)
                .message("Up and Running")
                .build();
    }
}
