package com.example.XML_WS_backend.services;

import com.example.XML_WS_backend.DTOs.RegistrationDTO;
import com.example.XML_WS_backend.custom_utils.mappers.DTO_2_EntityMapper;
import com.example.XML_WS_backend.models.User;
import com.example.XML_WS_backend.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository officialsRepository;

    public ResponseEntity<User> registerUser(RegistrationDTO registrationDTO) {
        User user = DTO_2_EntityMapper.RegistrationDTO_2_User(registrationDTO, true);

        if (user == null)
            return new ResponseEntity<>(null, HttpStatus.UNPROCESSABLE_ENTITY);;

        if (officialsRepository.getByEmail(user.getEmail()) != null)
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);

        officialsRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
