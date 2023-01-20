package com.example.XML_WS_backend.controllers;

import com.example.XML_WS_backend.DTOs.RegistrationDTO;
import com.example.XML_WS_backend.models.User;
import com.example.XML_WS_backend.services.XMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.example.XML_WS_backend.configs.Settings.CROSS_ORIGIN_FRONTEND_PATH;

@Controller
@RequestMapping(value="/xml")
public class XMLController {
    @Autowired
    private XMLService xmlService;


    @GetMapping(value = "/trademark/read")
    @CrossOrigin(origins = CROSS_ORIGIN_FRONTEND_PATH)
    public ResponseEntity<HttpStatus> readTrademarkXML() {
        xmlService.readTrademarkXMLFile();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
