package com.example.XML_WS_Trademark_backend.controllers;

import com.example.XML_WS_Trademark_backend.DTOs.BasicSearchParamsDTO;
import com.example.XML_WS_Trademark_backend.DTOs.ComplexSearchParamsDTO;
import com.example.XML_WS_Trademark_backend.DTOs.ListOfTrademarkRequestsDTO;
import com.example.XML_WS_Trademark_backend.DTOs.PDFBytesDTO;
import com.example.XML_WS_Trademark_backend.models.ResenjeZahteva;
import com.example.XML_WS_Trademark_backend.models.ZahtevZaPriznanjeZiga;
import com.example.XML_WS_Trademark_backend.services.ResenjaService;
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
    @Autowired
    private ResenjaService resenjaService;


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

    @PostMapping("/resenje/save")
    public ResponseEntity<HttpStatus> saveResenje(@RequestBody ResenjeZahteva resenjeZahteva) {
        resenjaService.saveNewResenje(resenjeZahteva);
        trademarkService.changeTrademarkStatus(resenjeZahteva.getBrojPrijave(), resenjeZahteva.getJePrihvacen());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/search/basic")
    public ResponseEntity<ListOfTrademarkRequestsDTO> basicSearch(@RequestBody BasicSearchParamsDTO paramsDTO) {
        return new ResponseEntity<>(
                new ListOfTrademarkRequestsDTO(trademarkService.basicSearch(paramsDTO.getParam(), paramsDTO.getOnlyApproved())),
                HttpStatus.OK
        );
    }

    @PostMapping("/search/advanced")
    public ResponseEntity<ListOfTrademarkRequestsDTO> advancedSearch(@RequestBody ComplexSearchParamsDTO paramsDTO) {
        return new ResponseEntity<>(
                new ListOfTrademarkRequestsDTO(trademarkService.advancedSearch(paramsDTO)),
                HttpStatus.OK
        );
    }

    @GetMapping("/metadata/rdf")
    public ResponseEntity<String> getRDF() {
        return new ResponseEntity<>(trademarkService.getRDF(), HttpStatus.OK);
    }

    @GetMapping("/metadata/json")
    public ResponseEntity<String> getJSON() {
        return new ResponseEntity<>(trademarkService.getJSON(), HttpStatus.OK);
    }

}
