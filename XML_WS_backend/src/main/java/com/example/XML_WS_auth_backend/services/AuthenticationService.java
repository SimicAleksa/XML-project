package com.example.XML_WS_auth_backend.services;

import com.example.XML_WS_auth_backend.DTOs.LoginDTO;
import com.example.XML_WS_auth_backend.models.User;
import com.example.XML_WS_auth_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository officialsRepository;

    public ResponseEntity<HttpStatus> loginUser(LoginDTO loginDTO) {
        User user = officialsRepository.getByEmail(loginDTO.getEmail());
        if (user == null || !user.getEmail().equals(loginDTO.getEmail()) || !user.getPassword().equals(loginDTO.getPassword()))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
