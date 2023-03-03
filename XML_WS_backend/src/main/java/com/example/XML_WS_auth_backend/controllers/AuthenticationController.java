package com.example.XML_WS_auth_backend.controllers;

import com.example.XML_WS_auth_backend.DTOs.AuthTokenDTO;
import com.example.XML_WS_auth_backend.DTOs.LoginDTO;
import com.example.XML_WS_auth_backend.custom_exceptions.AuthFailedException;
import com.example.XML_WS_auth_backend.custom_exceptions.CredsNotValidException;
import com.example.XML_WS_auth_backend.custom_exceptions.UserNotFoundException;
import com.example.XML_WS_auth_backend.services.AuthenticationService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.example.XML_WS_auth_backend.configs.Settings.CROSS_ORIGIN_FRONTEND_PATH;


@RestController
@RequestMapping(value = "api/auth")
@CrossOrigin(origins = CROSS_ORIGIN_FRONTEND_PATH)
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/login", consumes = {MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<AuthTokenDTO> loginUser(@RequestBody LoginDTO loginDTO) {
        try {
            return new ResponseEntity<>(authenticationService.loginUser(loginDTO), HttpStatus.OK);
        } catch (CredsNotValidException ignored) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (UserNotFoundException ignored) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/regular")
    public ResponseEntity<HttpStatus> authTokenForRegularUser(HttpServletRequest request) {
        try {
            authenticationService.authRegularUser(request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (AuthFailedException | ExpiredJwtException ignored) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(value = "/official")
    public ResponseEntity<HttpStatus> authTokenForOfficialUser(HttpServletRequest request) {
        try {
            authenticationService.authOfficialUser(request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (AuthFailedException | ExpiredJwtException ignored) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(value = "/admin")
    public ResponseEntity<HttpStatus> authTokenForAdmin(HttpServletRequest request) {
        try {
            authenticationService.authAdmin(request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (AuthFailedException | ExpiredJwtException ignored) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

}
