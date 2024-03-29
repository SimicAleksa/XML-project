package com.example.XML_WS_Patent_backend.controllers;

import com.example.XML_WS_Patent_backend.DTOs.*;
import com.example.XML_WS_Patent_backend.models.ResenjeZahteva;
import com.example.XML_WS_Patent_backend.models.ZahtevZaPatent;
import com.example.XML_WS_Patent_backend.services.PatentService;
import com.example.XML_WS_Patent_backend.services.ResenjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/api/patent", produces = MediaType.APPLICATION_XML_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
public class PatentController {
    @Autowired
    private PatentService patentService;

    @Autowired
    private ResenjaService resenjaService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<ZahtevZaPatent>> getAll() {
        return new ResponseEntity<>(patentService.getAll(), HttpStatus.OK);
    }

    @PostMapping(path="/report")
    public ResponseEntity<ReportDTO> getReportData(@RequestBody ReportParamsDTO paramsDTO) {
        return new ResponseEntity<>(patentService.getReport(paramsDTO), HttpStatus.OK);
    }

    @GetMapping(path = "/pending")
    public ResponseEntity<ListOfPatentRequestsDTO> getPending() {
        return new ResponseEntity<>(new ListOfPatentRequestsDTO(patentService.getPendingRequests()), HttpStatus.OK);
    }

    @PostMapping(path = "/save", consumes = {MediaType.APPLICATION_XML_VALUE} )
    public ResponseEntity<HttpStatus> saveNewPatent(@RequestBody ZahtevZaPatent patent) {
        patentService.save(patent);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/pdf/{id}")
    public ResponseEntity<PDFBytesDTO> getPDF(@PathVariable String id) {
        return new ResponseEntity<>(new PDFBytesDTO(patentService.getPDF(id)), HttpStatus.OK);
    }

    @GetMapping("/xhtml/{id}")
    public ResponseEntity<PDFBytesDTO> getXHTML(@PathVariable String id) {
        byte[] xhtmlContent = patentService.getXHTML(id);
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
        return new ResponseEntity<>(new PDFBytesDTO(patentService.getXHTML(id)), HttpStatus.OK);
    }

    @PostMapping("/resenje/save")
    public ResponseEntity<HttpStatus> saveResenje(@RequestBody ResenjeZahteva resenjeZahteva) {
        resenjaService.saveNewResenje(resenjeZahteva);
        patentService.changePatentStatus(resenjeZahteva.getBrojPrijave(), resenjeZahteva.getJePrihvacen(), resenjeZahteva.getDatumPodnosenjaResenja());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/reference")
    public ResponseEntity<ListOfPatentRequestsDTO> referencedFiles(@RequestBody ReferencedFilesDTO paramsDTO) {
        return new ResponseEntity<>(
                new ListOfPatentRequestsDTO(patentService.referenceSearch(paramsDTO.getParam())),
                HttpStatus.OK
        );
    }

    @PostMapping("/search/basic")
    public ResponseEntity<ListOfPatentRequestsDTO> basicSearch(@RequestBody BasicSearchParamsDTO paramsDTO) {
        return new ResponseEntity<>(
                new ListOfPatentRequestsDTO(patentService.basicSearch(paramsDTO.getParam(), paramsDTO.getOnlyApproved())),
                HttpStatus.OK
        );
    }

    @PostMapping("/search/advanced")
    public ResponseEntity<ListOfPatentRequestsDTO> advancedSearch(@RequestBody ComplexSearchParamsDTO paramsDTO) {
        return new ResponseEntity<>(
                new ListOfPatentRequestsDTO(patentService.advancedSearch(paramsDTO)),
                HttpStatus.OK
        );
    }

    @GetMapping("/metadata/rdf")
    public ResponseEntity<String> getRDF() {
        return new ResponseEntity<>(patentService.getRDF(), HttpStatus.OK);
    }

    @GetMapping("/metadata/json")
    public ResponseEntity<String> getJSON() {
        return new ResponseEntity<>(patentService.getJSON(), HttpStatus.OK);
    }

}
