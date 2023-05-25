package com.example.XML_WS_AuthorRights_backend.controllers;

import com.example.XML_WS_AuthorRights_backend.DTOs.BasicSearchParamsDTO;
import com.example.XML_WS_AuthorRights_backend.DTOs.ComplexSearchParamsDTO;
import com.example.XML_WS_AuthorRights_backend.DTOs.ListOfCopyRightRequestsDTO;
import com.example.XML_WS_AuthorRights_backend.DTOs.PDFBytesDTO;
import com.example.XML_WS_AuthorRights_backend.models.ResenjeZahteva;
import com.example.XML_WS_AuthorRights_backend.models.ZahtevZaAutorskoPravo;
import com.example.XML_WS_AuthorRights_backend.services.AuthorRightsService;
import com.example.XML_WS_AuthorRights_backend.services.ResenjaService;
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
    @Autowired
    private ResenjaService resenjaService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<ZahtevZaAutorskoPravo>> getAll() {
        return new ResponseEntity<>(authorRightsService.getAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/save", consumes = {MediaType.APPLICATION_XML_VALUE} )
    public ResponseEntity<HttpStatus> saveNewTrademark(@RequestBody ZahtevZaAutorskoPravo zaAutorskoPravo) {
        authorRightsService.save(zaAutorskoPravo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/pending")
    public ResponseEntity<ListOfCopyRightRequestsDTO> getPending() {
        return new ResponseEntity<>(new ListOfCopyRightRequestsDTO(authorRightsService.getPendingRequests()), HttpStatus.OK);
    }

    @GetMapping("/pdf/{id}")
    public ResponseEntity<PDFBytesDTO> getPDF(@PathVariable String id) {
        return new ResponseEntity<>(new PDFBytesDTO(authorRightsService.getPDF(id)), HttpStatus.OK);
    }

    @GetMapping("/xhtml/{id}")
    public ResponseEntity<PDFBytesDTO> getXHTML(@PathVariable String id) {
        return new ResponseEntity<>(new PDFBytesDTO(authorRightsService.getXHTML(id)), HttpStatus.OK);
    }

    @PostMapping("/resenje/save")
    public ResponseEntity<HttpStatus> saveResenje(@RequestBody ResenjeZahteva resenjeZahteva) {
        resenjaService.saveNewResenje(resenjeZahteva);
        authorRightsService.changeCRStatus(resenjeZahteva.getBrojPrijave(), resenjeZahteva.getJePrihvacen());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/search/basic")
    public ResponseEntity<ListOfCopyRightRequestsDTO> basicSearch(@RequestBody BasicSearchParamsDTO paramsDTO) {
        return new ResponseEntity<>(
                new ListOfCopyRightRequestsDTO(authorRightsService.basicSearch(paramsDTO.getParam(), paramsDTO.getOnlyApproved())),
                HttpStatus.OK
        );
    }

    @PostMapping("/search/advanced")
    public ResponseEntity<ListOfCopyRightRequestsDTO> advancedSearch(@RequestBody ComplexSearchParamsDTO paramsDTO) {
        return new ResponseEntity<>(
                new ListOfCopyRightRequestsDTO(authorRightsService.advancedSearch(paramsDTO)),
                HttpStatus.OK
        );
    }

}
