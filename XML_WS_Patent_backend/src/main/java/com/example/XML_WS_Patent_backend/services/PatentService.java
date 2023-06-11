package com.example.XML_WS_Patent_backend.services;


import com.example.XML_WS_Patent_backend.DTOs.ComplexSearchParamsDTO;
import com.example.XML_WS_Patent_backend.DTOs.ReportDTO;
import com.example.XML_WS_Patent_backend.DTOs.ReportParamsDTO;
import com.example.XML_WS_Patent_backend.models.ZahtevZaPatent;
import com.example.XML_WS_Patent_backend.repository.PatentRepository;
import com.example.XML_WS_Patent_backend.utils.PDForXHTMLGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatentService {
    @Autowired
    private PatentRepository patentRepository;

    public void save(ZahtevZaPatent patent) {
        patentRepository.save(patent);
    }

    public List<ZahtevZaPatent> getAll() {
        return patentRepository.getAllPatentRequest();
    }

    public List<ZahtevZaPatent> getPendingRequests() {
        return patentRepository.getAllPatentRequest().stream()
                .filter(req -> req.getPopunjavaZavod().getStatus().equals("NERESENO"))
                .collect(Collectors.toList());
    }

    public byte[] getPDF(String brojPrijave) {
        try {
            return PDForXHTMLGenerator.getPDF(patentRepository.getPatentRequestById(brojPrijave));
        } catch (Exception ignored) {}
        return new byte[0];
    }

    public byte[] getXHTML(String brojPrijave) {
        try {
            return PDForXHTMLGenerator.getXHTML(patentRepository.getPatentRequestById(brojPrijave));
        } catch (Exception ignored) {}
        return new byte[0];
    }

    public void changePatentStatus(String patentId, boolean isApproved, String datumPregledanja) {
        ZahtevZaPatent patentReq = patentRepository.getPatentRequestById(patentId);
        patentReq.getPopunjavaZavod().setStatus(isApproved ? "PRIHVACENO" : "ODBIJENO");
        patentReq.getPopunjavaZavod().setDatumPregledanja(datumPregledanja.toString());
        save(patentReq);
    }

    public List<ZahtevZaPatent> basicSearch(List<String> params, boolean onlyApproved) {
        List<ZahtevZaPatent> reqs = patentRepository.getPatentWithBasicSearch(params);
        if (onlyApproved)
            return reqs.stream().filter(req -> req.getPopunjavaZavod().getStatus().equals("PRIHVACENO"))
                    .collect(Collectors.toList());
        return reqs;
    }

    public List<ZahtevZaPatent> advancedSearch(ComplexSearchParamsDTO searchParamsDTO) {
        List<ZahtevZaPatent> reqs = patentRepository.getPatentWithAdvancedSearch(searchParamsDTO);
        if (searchParamsDTO.getOnlyApproved())
            return reqs.stream().filter(req -> req.getPopunjavaZavod().getStatus().equals("PRIHVACENO"))
                    .collect(Collectors.toList());
        return reqs;
    }

    public ReportDTO getReport(ReportParamsDTO paramsDTO) {
        return patentRepository.getReport(paramsDTO);
    }

    public String getRDF() {
        try {
            generateRDFFileFromString(patentRepository.getMetadataInRDF(),"rdfData.rdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return patentRepository.getMetadataInRDF();
    }

    public void generateRDFFileFromString(String rdfString, String filePath) throws IOException {
        Model model = ModelFactory.createDefaultModel();
        Resource resource = model.createResource();
        resource.addProperty(model.createProperty("http://example.org/property"), rdfString);
        try (FileOutputStream output = new FileOutputStream(filePath)) {
            model.write(output, "RDF/XML");
        }
    }

    public String getJSON() {
        createJsonFileFromString(patentRepository.getMetadataInJSON(), "jsonData.json");
        return patentRepository.getMetadataInJSON();
    }


    public void createJsonFileFromString(String jsonString, String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Object jsonObject = objectMapper.readValue(jsonString, Object.class);
            objectMapper.writeValue(new File(filePath), jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<ZahtevZaPatent> referenceSearch(String param) {
        List<ZahtevZaPatent> reqs = patentRepository.getAllPatentRequest();
        List<ZahtevZaPatent> retVal = new ArrayList<>();
        for(ZahtevZaPatent zahtevZaPatent : reqs){
            for(ZahtevZaPatent.ZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava.RanijaPrijava ranijaPrijava : zahtevZaPatent.getZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava().getRanijaPrijave()){
                if(ranijaPrijava.getBrojRanijePrijave().equals(param))
                    retVal.add(zahtevZaPatent);
            }
        }
        return retVal;
    }
}
