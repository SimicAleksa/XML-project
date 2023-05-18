package com.example.XML_WS_auth_backend.custom_utils.mappers;

import com.example.XML_WS_auth_backend.DTOs.RegistrationDTO;
import com.example.XML_WS_auth_backend.configs.Settings;
import com.example.XML_WS_auth_backend.models.User;

public class DTO2EntityMapper {
    public static User RegistrationDTO2User(RegistrationDTO registrationDTO, String role) {
        User user = new User();
        user.setFirstname(registrationDTO.getFirstname());
        user.setLastname(registrationDTO.getLastname());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword());
        user.setRole(role);
        return user;
    }
}
