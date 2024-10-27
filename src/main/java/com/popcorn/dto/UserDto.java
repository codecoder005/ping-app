package com.popcorn.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private UUID userId;
    private String name;
    private String email;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
