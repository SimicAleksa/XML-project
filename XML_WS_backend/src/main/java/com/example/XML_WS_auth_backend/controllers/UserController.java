package com.example.XML_WS_auth_backend.controllers;

import com.example.XML_WS_auth_backend.DTOs.RegistrationDTO;
import com.example.XML_WS_auth_backend.custom_exceptions.UserAlreadyExistsException;
import com.example.XML_WS_auth_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.example.XML_WS_auth_backend.configs.Settings.CROSS_ORIGIN_FRONTEND_PATH;

@RestController
@RequestMapping(value = "api/users")
@CrossOrigin(origins = CROSS_ORIGIN_FRONTEND_PATH)
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/regular/register", consumes = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<HttpStatus> registerRegularUser(@RequestBody RegistrationDTO registrationDTO) {
        try {
            this.userService.registerUser(registrationDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserAlreadyExistsException ignored) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
