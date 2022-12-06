package com.example.XML_WS_backend.controllers;

import com.example.XML_WS_backend.DTOs.RegistrationDTO;
import com.example.XML_WS_backend.models.User;
import com.example.XML_WS_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.example.XML_WS_backend.configs.Settings.CROSS_ORIGIN_FRONTEND_PATH;

@RestController
@RequestMapping(value = "api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/register", consumes = "application/json")
    @CrossOrigin(origins = CROSS_ORIGIN_FRONTEND_PATH)
    public ResponseEntity<User> registerUser(@RequestBody RegistrationDTO registrationDTO) {
        return userService.registerUser(registrationDTO);
    }

}
