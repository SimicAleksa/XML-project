package com.example.XML_WS_backend.controllers;

import com.example.XML_WS_backend.DTOs.RegistrationDTO;
import com.example.XML_WS_backend.models.Official;
import com.example.XML_WS_backend.services.OfficialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/officials")
public class OfficialsController {
    @Autowired
    private OfficialsService officialsService;

    @PostMapping(value = "/register", consumes = "application/json")
    public ResponseEntity<Official> registerUser(@RequestBody RegistrationDTO registrationDTO) {
        return officialsService.registerUser(registrationDTO);
    }

}
