package com.example.XML_WS_auth_backend.controllers;

import com.example.XML_WS_auth_backend.DTOs.RegistrationDTO;
import com.example.XML_WS_auth_backend.DTOs.UserInfoDTO;
import com.example.XML_WS_auth_backend.custom_exceptions.UserAlreadyExistsException;
import com.example.XML_WS_auth_backend.services.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
            this.userService.registerRegularUser(registrationDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserAlreadyExistsException ignored) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping(value = "/official/register", consumes = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<HttpStatus> registerOfficial(@RequestBody RegistrationDTO registrationDTO) {
        try {
            this.userService.registerOfficial(registrationDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserAlreadyExistsException ignored) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping(value = "/admin/register", consumes = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<HttpStatus> registerAdmin(@RequestBody RegistrationDTO registrationDTO) {
        try {
            this.userService.registerAdmin(registrationDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserAlreadyExistsException ignored) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping(value = "/info", produces = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserInfoDTO> fetchUserData(final HttpServletRequest request) {
        try {
            return new ResponseEntity<>(userService.getUserInfo(request), HttpStatus.OK);
        } catch (ExpiredJwtException ignored) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

}
