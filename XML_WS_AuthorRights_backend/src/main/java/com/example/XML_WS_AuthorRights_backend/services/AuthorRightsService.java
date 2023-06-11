package com.example.XML_WS_AuthorRights_backend.services;

import com.example.XML_WS_AuthorRights_backend.DTOs.ComplexSearchParamsDTO;
import com.example.XML_WS_AuthorRights_backend.DTOs.ReportDTO;
import com.example.XML_WS_AuthorRights_backend.DTOs.ReportParamsDTO;
import com.example.XML_WS_AuthorRights_backend.models.ZahtevZaAutorskoPravo;
import com.example.XML_WS_AuthorRights_backend.repository.AuthorRightsRepository;
import com.example.XML_WS_AuthorRights_backend.utils.PDForXHTMLGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AuthorRightsService {
    @Autowired
    private AuthorRightsRepository authorRightsRepository;

    public void save(ZahtevZaAutorskoPravo zaAutorskoPravo) {
        authorRightsRepository.save(zaAutorskoPravo);
    }

    public List<ZahtevZaAutorskoPravo> getAll() {
        return authorRightsRepository.getAllCopyRightRequest();
    }

    public List<ZahtevZaAutorskoPravo> getPendingRequests() {
        return authorRightsRepository.getAllCopyRightRequest().stream()
                .filter(req -> req.getStatus().equals("NERESENO"))
                .collect(Collectors.toList());
    }

    public byte[] getPDF(String brojPrijave) {
        try {
            return PDForXHTMLGenerator.getPDF(authorRightsRepository.getCRRequestById(brojPrijave));
        } catch (Exception ignored) {}
        return new byte[0];
    }

    public byte[] getXHTML(String brojPrijave) {
        try {
            return PDForXHTMLGenerator.getXHTML(authorRightsRepository.getCRRequestById(brojPrijave));
        } catch (Exception ignored) {}
        return new byte[0];
    }

    public void changeCRStatus(String crId, boolean isApproved, String datumPregledanja) {
        ZahtevZaAutorskoPravo crReq = authorRightsRepository.getCRRequestById(crId);
        crReq.setStatus(isApproved ? "PRIHVACENO" : "ODBIJENO");
        crReq.setDatumPregledanja(datumPregledanja.toString());
        save(crReq);
    }

    public List<ZahtevZaAutorskoPravo> basicSearch(List<String> params, boolean onlyApproved) {
        List<ZahtevZaAutorskoPravo> reqs = authorRightsRepository.getCopyRightWithBasicSearch(params);
        if (onlyApproved)
            return reqs.stream().filter(req -> req.getStatus().equals("PRIHVACENO"))
                    .collect(Collectors.toList());
        return reqs;
    }

    public List<ZahtevZaAutorskoPravo> advancedSearch(ComplexSearchParamsDTO searchParamsDTO) {
        List<ZahtevZaAutorskoPravo> reqs = authorRightsRepository.getCopyRightWithAdvancedSearch(searchParamsDTO);
        if (searchParamsDTO.getOnlyApproved())
            return reqs.stream().filter(req -> req.getStatus().equals("PRIHVACENO"))
                    .collect(Collectors.toList());
        return reqs;
    }

    public String getRDF() {
        try {
            generateRDFFileFromString(authorRightsRepository.getMetadataInRDF(),"rdfData.rdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return authorRightsRepository.getMetadataInRDF();
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
        createJsonFileFromString(authorRightsRepository.getMetadataInJSON(), "jsonData.json");
        return authorRightsRepository.getMetadataInJSON();
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

    public ReportDTO getReport(ReportParamsDTO paramsDTO) {
        return authorRightsRepository.getReport(paramsDTO);
    }
}
