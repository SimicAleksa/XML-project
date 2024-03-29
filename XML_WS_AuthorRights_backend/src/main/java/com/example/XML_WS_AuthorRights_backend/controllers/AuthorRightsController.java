package com.example.XML_WS_AuthorRights_backend.controllers;

import com.example.XML_WS_AuthorRights_backend.DTOs.*;
import com.example.XML_WS_AuthorRights_backend.models.ResenjeZahteva;
import com.example.XML_WS_AuthorRights_backend.models.ZahtevZaAutorskoPravo;
import com.example.XML_WS_AuthorRights_backend.services.AuthorRightsService;
import com.example.XML_WS_AuthorRights_backend.services.ResenjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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
    public ResponseEntity<HttpStatus> saveNewCopyRight(@RequestBody ZahtevZaAutorskoPravo zaAutorskoPravo) {
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
        byte[] xhtmlContent = authorRightsService.getXHTML(id);
        String filePath = "xhtmlData.xhtml";
        File file = new File(filePath);

        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(xhtmlContent);
            outputStream.close();

            System.out.println("XHTML file created successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while creating the XHTML file: " + e.getMessage());
        }
        return new ResponseEntity<>(new PDFBytesDTO(authorRightsService.getXHTML(id)), HttpStatus.OK);
    }

    @PostMapping("/resenje/save")
    public ResponseEntity<HttpStatus> saveResenje(@RequestBody ResenjeZahteva resenjeZahteva) {
        resenjaService.saveNewResenje(resenjeZahteva);
        authorRightsService.changeCRStatus(resenjeZahteva.getBrojPrijave(), resenjeZahteva.getJePrihvacen(), resenjeZahteva.getDatumPodnosenjaResenja());
        resenjaService.sendEmailGornji(resenjeZahteva);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/search/basic")
    public ResponseEntity<ListOfCopyRightRequestsDTO> basicSearch(@RequestBody BasicSearchParamsDTO paramsDTO) {
        return new ResponseEntity<>(
                new ListOfCopyRightRequestsDTO(authorRightsService.basicSearch(paramsDTO.getParam(), paramsDTO.getOnlyApproved())),
                HttpStatus.OK
        );
    }

    @PostMapping("/reference")
    public ResponseEntity<ListOfCopyRightRequestsDTO> referencedFiles(@RequestBody ReferencedFilesDTO paramsDTO) {
        return new ResponseEntity<>(
                new ListOfCopyRightRequestsDTO(authorRightsService.referenceSearch(paramsDTO.getParam())),
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

    @GetMapping("/metadata/rdf")
    public ResponseEntity<String> getRDF() {
        return new ResponseEntity<>(authorRightsService.getRDF(), HttpStatus.OK);
    }

    @GetMapping("/metadata/json")
    public ResponseEntity<String> getJSON() {
        return new ResponseEntity<>(authorRightsService.getJSON(), HttpStatus.OK);
    }

    @PostMapping(path="/report")
    public ResponseEntity<ReportDTO> getReportData(@RequestBody ReportParamsDTO paramsDTO) {
        return new ResponseEntity<>(authorRightsService.getReport(paramsDTO), HttpStatus.OK);
    }

}
