package com.popcorn.mapper;

import com.popcorn.dto.UserDto;
import com.popcorn.entity.UserEntity;

public class UserMapper {
    public static UserEntity map(UserDto dto) {
        return UserEntity.builder()
                .userId(dto.getUserId())
                .name(dto.getName())
                .email(dto.getEmail())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build();
    }

    public static UserDto map(UserEntity entity) {
        return UserDto.builder()
                .userId(entity.getUserId())
                .name(entity.getName())
                .email(entity.getEmail())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
