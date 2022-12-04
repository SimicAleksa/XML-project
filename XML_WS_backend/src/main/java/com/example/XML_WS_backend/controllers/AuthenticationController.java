package com.example.XML_WS_backend.controllers;

import com.example.XML_WS_backend.DTOs.LoginDTO;
import com.example.XML_WS_backend.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.XML_WS_backend.configs.Settings.CROSS_ORIGIN_FRONTEND_PATH;


@RestController
@RequestMapping(value = "api/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/login", consumes = "application/json")
    @CrossOrigin(origins = CROSS_ORIGIN_FRONTEND_PATH)
    public ResponseEntity<HttpStatus> loginUser(@RequestBody LoginDTO loginDTO) {
        return authenticationService.loginUser(loginDTO);
    }
}
