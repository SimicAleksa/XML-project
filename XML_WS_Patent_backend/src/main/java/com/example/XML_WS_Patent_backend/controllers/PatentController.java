package com.example.XML_WS_Patent_backend.controllers;

import com.example.XML_WS_Patent_backend.models.ZahtevZaPatent;
import com.example.XML_WS_Patent_backend.services.PatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/patent")
public class PatentController {
    @Autowired
    private PatentService patentService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<ZahtevZaPatent>> getAll() {
        return new ResponseEntity<>(patentService.getAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/save", consumes = {MediaType.APPLICATION_XML_VALUE} )
    public ResponseEntity<HttpStatus> saveNewTrademark(@RequestBody ZahtevZaPatent trademark) {
        patentService.save(trademark);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/pdf")
    public ResponseEntity<HttpStatus> getPDF() {
        patentService.getPDF();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
