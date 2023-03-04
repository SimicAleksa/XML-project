package com.example.XML_WS_auth_backend.custom_utils.mappers;

import com.example.XML_WS_auth_backend.DTOs.UserInfoDTO;
import com.example.XML_WS_auth_backend.models.User;

public class Entity2DTOMapper {
    public static UserInfoDTO mapUser2UserInfoDTO(User user) {
        return new UserInfoDTO(user.getFirstname(), user.getLastname(),
                                user.getEmail(), user.getRole()) ;
    }
}
