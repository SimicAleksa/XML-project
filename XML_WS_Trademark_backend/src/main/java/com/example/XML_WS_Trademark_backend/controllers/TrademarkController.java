package com.example.XML_WS_Trademark_backend.controllers;

import com.example.XML_WS_Trademark_backend.DTOs.ListOfTrademarkRequestsDTO;
import com.example.XML_WS_Trademark_backend.DTOs.PDFBytesDTO;
import com.example.XML_WS_Trademark_backend.models.ZahtevZaPriznanjeZiga;
import com.example.XML_WS_Trademark_backend.services.TrademarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/trademark", produces = MediaType.APPLICATION_XML_VALUE)
@CrossOrigin("http://localhost:4200")
public class TrademarkController {
    @Autowired
    private TrademarkService trademarkService;

    @GetMapping(path = "/all")
    public ResponseEntity<ListOfTrademarkRequestsDTO> getAll() {
        return new ResponseEntity<>(new ListOfTrademarkRequestsDTO(trademarkService.getAll()), HttpStatus.OK);
    }

    @GetMapping(path = "/pending")
    public ResponseEntity<ListOfTrademarkRequestsDTO> getPending() {
        return new ResponseEntity<>(new ListOfTrademarkRequestsDTO(trademarkService.getPendingRequests()), HttpStatus.OK);
    }

    @PostMapping(path = "/save", consumes = {MediaType.APPLICATION_XML_VALUE} )
    public ResponseEntity<HttpStatus> saveNewTrademark(@RequestBody ZahtevZaPriznanjeZiga trademark) {
        trademarkService.addNewTrademarkReq(trademark);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/pdf/{id}")
    public ResponseEntity<PDFBytesDTO> getPDF(@PathVariable String id) {
        return new ResponseEntity<>(new PDFBytesDTO(trademarkService.getPDF(id)), HttpStatus.OK);
    }

    @GetMapping("/xhtml/{id}")
    public ResponseEntity<PDFBytesDTO> getXHTML(@PathVariable String id) {
        return new ResponseEntity<>(new PDFBytesDTO(trademarkService.getXHTML(id)), HttpStatus.OK);
    }
}
