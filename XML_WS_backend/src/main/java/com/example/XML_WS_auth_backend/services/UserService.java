package com.example.XML_WS_auth_backend.services;

import com.example.XML_WS_auth_backend.DTOs.RegistrationDTO;
import com.example.XML_WS_auth_backend.DTOs.UserInfoDTO;
import com.example.XML_WS_auth_backend.custom_exceptions.UserAlreadyExistsException;
import com.example.XML_WS_auth_backend.custom_utils.mappers.DTO2EntityMapper;
import com.example.XML_WS_auth_backend.custom_utils.mappers.Entity2DTOMapper;
import com.example.XML_WS_auth_backend.repositories.UserRepository;
import com.example.XML_WS_auth_backend.utils.TokenUtils;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {
    @Autowired
    private TokenUtils tokenUtils;
    @Autowired
    private UserRepository userRepository;

    public void registerUser(final RegistrationDTO registrationDTO) {
        if (userRepository.getByEmail(registrationDTO.getEmail()) != null)
            throw new UserAlreadyExistsException();
        userRepository.save(DTO2EntityMapper.RegistrationDTO2User(registrationDTO));
    }

    public UserInfoDTO getUserInfo(final HttpServletRequest request) throws ExpiredJwtException {
        return Entity2DTOMapper.mapUser2UserInfoDTO(
                userRepository.getByEmail(
                        tokenUtils.getEmailDirectlyFromHeader(request)
                )
        );
    }
}
