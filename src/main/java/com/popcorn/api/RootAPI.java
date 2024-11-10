package com.popcorn.api;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.Cookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api/v1/roots")
public interface RootAPI {
    @PostMapping(consumes = "application/json", produces = "application/json")
    ResponseEntity<Map<String, Object>> post(@RequestBody Map<String, Object> body);

    @PostMapping(path = "/sub/{id}", consumes = "application/json", produces = "application/json")
    @SecurityRequirement(name = "bearerAuth")
    ResponseEntity<Map<String, Object>> subApi(
            @PathVariable(name = "id") final String id,
            @RequestHeader(name = "Authorization") final String authorization,
            @RequestParam(name = "q") final String query,
            @RequestBody Map<String, Object> body,
            @RequestAttribute(name = "userId", required = false) final String userId,
            @CookieValue(name = "JSESSIONID", required = false) final Cookie cookie
    );
}
