package com.popcorn.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

public interface UserAPI {
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Map<String, Object>> getUsers();
}
