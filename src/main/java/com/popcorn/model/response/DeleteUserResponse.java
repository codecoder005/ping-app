package com.popcorn.model.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteUserResponse {
    private UUID userId;
    private String message;
    private LocalDateTime deletedAt;
}
