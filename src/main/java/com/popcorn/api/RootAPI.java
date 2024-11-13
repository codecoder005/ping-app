package com.popcorn.api;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.Cookie;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api/v1/roots")
public interface RootAPI {
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "success", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Map.class))}),
            @ApiResponse(responseCode = "400", description = "bad request", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Map.class))}),
            @ApiResponse(responseCode = "401", description = "unauthorized", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Map.class))}),
            @ApiResponse(responseCode = "500", description = "internal server error", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Map.class))}),
            @ApiResponse(responseCode = "503", description = "internal server error", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Map.class))}),
    })

    @PostMapping(consumes = "application/json", produces = "application/json")
    ResponseEntity<Map<String, Object>> post(@RequestBody Map<String, Object> body);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "success", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Map.class))}),
            @ApiResponse(responseCode = "400", description = "bad request", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Map.class))}),
            @ApiResponse(responseCode = "401", description = "unauthorized", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Map.class))}),
            @ApiResponse(responseCode = "500", description = "internal server error", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Map.class))}),
            @ApiResponse(responseCode = "503", description = "internal server error", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Map.class))}),
    })
    @Parameters(value = {
            @Parameter(name = "Authorization", schema = @Schema(title = "Authorization", implementation = Map.class, allowableValues = "range[1-256]"), in = ParameterIn.HEADER, description = "")
    })
    @SecurityRequirement(name = "bearerAuth")
    @PostMapping(path = "/sub/{id}", consumes = "application/json", produces = "application/json")
    ResponseEntity<Map<String, Object>> subApi(
            @PathVariable(name = "id") final String id,
            @RequestHeader(name = "Authorization") final String authorization,
            @RequestParam(name = "q") final String query,
            @RequestBody Map<String, Object> body,
            @RequestAttribute(name = "userId", required = false) final String userId,
            @CookieValue(name = "JSESSIONID", required = false) final Cookie cookie
    );
}
