package com.example.XML_WS_Trademark_backend.controllers;

import com.example.XML_WS_Trademark_backend.models.ZahtevZaPriznanjeZiga;
import com.example.XML_WS_Trademark_backend.services.TrademarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/trademark")
public class TrademarkController {
    @Autowired
    private TrademarkService trademarkService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<ZahtevZaPriznanjeZiga>> getAll() {
        return new ResponseEntity<>(trademarkService.getAll(), HttpStatus.OK);
    }
}
