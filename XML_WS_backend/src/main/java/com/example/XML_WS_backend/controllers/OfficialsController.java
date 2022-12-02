package com.example.XML_WS_backend.controllers;

import com.example.XML_WS_backend.services.OfficialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfficialsController {
    @Autowired
    private OfficialsService officialsService;

    @PostMapping("/user/register")
    public ResponseEntity<HttpStatus> registerUser() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
