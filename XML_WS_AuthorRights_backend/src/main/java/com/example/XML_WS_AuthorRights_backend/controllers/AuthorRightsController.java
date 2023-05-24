package com.example.XML_WS_AuthorRights_backend.controllers;

import com.example.XML_WS_AuthorRights_backend.models.ZahtevZaAutorskoPravo;
import com.example.XML_WS_AuthorRights_backend.services.AuthorRightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/author-rights",produces = MediaType.APPLICATION_XML_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
public class AuthorRightsController {
    @Autowired
    private AuthorRightsService authorRightsService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<ZahtevZaAutorskoPravo>> getAll() {
        return new ResponseEntity<>(authorRightsService.getAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/save", consumes = {MediaType.APPLICATION_XML_VALUE} )
    public ResponseEntity<HttpStatus> saveNewTrademark(@RequestBody ZahtevZaAutorskoPravo zaAutorskoPravo) {
        authorRightsService.save(zaAutorskoPravo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
