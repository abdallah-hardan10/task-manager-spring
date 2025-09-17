package com.taskManegment.Dto;

import com.taskManegment.Entity.UserEntity;

public class UserMapper {

    public static UserResponseDto toResponseDto(UserEntity user) {
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail());
    }
}
