package com.example.XML_WS_auth_backend.services;

import com.example.XML_WS_auth_backend.DTOs.RegistrationDTO;
import com.example.XML_WS_auth_backend.custom_exceptions.UserAlreadyExistsException;
import com.example.XML_WS_auth_backend.custom_utils.mappers.DTO2EntityMapper;
import com.example.XML_WS_auth_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void registerUser(RegistrationDTO registrationDTO) {
        if (userRepository.getByEmail(registrationDTO.getEmail()) != null)
            throw new UserAlreadyExistsException();
        userRepository.save(DTO2EntityMapper.RegistrationDTO2User(registrationDTO));
    }
}
