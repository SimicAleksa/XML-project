package com.example.XML_WS_backend.services;

import com.example.XML_WS_backend.DTOs.LoginDTO;
import com.example.XML_WS_backend.models.Official;
import com.example.XML_WS_backend.repositories.IOfficialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private IOfficialsRepository officialsRepository;

    public ResponseEntity<HttpStatus> loginUser(LoginDTO loginDTO) {
        Official official = officialsRepository.getByEmail(loginDTO.getEmail());
        if (official == null || !official.getEmail().equals(loginDTO.getEmail()) || !official.getPassword().equals(loginDTO.getPassword()))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
