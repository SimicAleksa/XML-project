package com.example.XML_WS_Trademark_backend.services;

import com.example.XML_WS_Trademark_backend.DTOs.ComplexSearchParamsDTO;
import com.example.XML_WS_Trademark_backend.DTOs.ReportDTO;
import com.example.XML_WS_Trademark_backend.DTOs.ReportParamsDTO;
import com.example.XML_WS_Trademark_backend.models.ZahtevZaPriznanjeZiga;
import com.example.XML_WS_Trademark_backend.repositories.TrademarkRepository;
import com.example.XML_WS_Trademark_backend.utils.PDForXHTMLGenerator;
import com.example.XML_WS_Trademark_backend.utils.QRCodeGenerator;
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
public class TrademarkService {
    @Autowired
    private TrademarkRepository trademarkRepository;


    public void addNewTrademarkReq(ZahtevZaPriznanjeZiga trademark) {
        trademark.getMetaData().getBrojPrijave().setValue("Ж-" + (trademarkRepository.getAllTrademarkRequest().size() + 1));
        trademark.getMetaData().getStatus().setValue("NERESENO");
        save(trademark);
    }

    public List<ZahtevZaPriznanjeZiga> getAll() {
        return trademarkRepository.getAllTrademarkRequest();
    }

    public List<ZahtevZaPriznanjeZiga> getPendingRequests() {
        return trademarkRepository.getAllTrademarkRequest().stream()
                .filter(req -> req.getMetaData().getStatus().getValue().equals("NERESENO"))
                .collect(Collectors.toList());
    }

    public byte[] getPDF(String brojPrijave) {
        try {
            return PDForXHTMLGenerator.getPDF(trademarkRepository.getTrademarkRequestById(brojPrijave));
        } catch (Exception ignored) {
        }
        return new byte[0];
    }

    public byte[] getXHTML(String brojPrijave) {
        try {
            return PDForXHTMLGenerator.getXHTML(trademarkRepository.getTrademarkRequestById(brojPrijave));
        } catch (Exception ignored) {
        }
        return new byte[0];
    }

    public void changeTrademarkStatus(String trademarkId, boolean isApproved) {
        ZahtevZaPriznanjeZiga trademarkReq = trademarkRepository.getTrademarkRequestById(trademarkId);
        trademarkReq.getMetaData().getStatus().setValue(isApproved ? "PRIHVACENO" : "ODBIJENO");
        save(trademarkReq);
    }

    public List<ZahtevZaPriznanjeZiga> basicSearch(List<String> params, boolean onlyApproved) {
        List<ZahtevZaPriznanjeZiga> reqs = trademarkRepository.getTrademarksWithBasicSearch(params);
        if (onlyApproved)
            return reqs.stream().filter(req -> req.getMetaData().getStatus().getValue().equals("PRIHVACENO"))
                    .collect(Collectors.toList());
        return reqs;
    }

    public List<ZahtevZaPriznanjeZiga> advancedSearch(ComplexSearchParamsDTO searchParamsDTO) {
        List<ZahtevZaPriznanjeZiga> reqs = trademarkRepository.getTrademarksWithAdvancedSearch(searchParamsDTO);
        if (searchParamsDTO.getOnlyApproved())
            return reqs.stream().filter(req -> req.getMetaData().getStatus().getValue().equals("PRIHVACENO"))
                    .collect(Collectors.toList());
        return reqs;
    }

    public String getRDF() {
        try {
            generateRDFFileFromString(trademarkRepository.getMetadataInRDF(),"rdfData.rdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trademarkRepository.getMetadataInRDF();
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
        createJsonFileFromString(trademarkRepository.getMetadataInJSON(), "jsonData.json");
        return trademarkRepository.getMetadataInJSON();
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

    public byte[] getQRCode(String id) {
        return QRCodeGenerator.getAsBytes(id);
    }

    public ReportDTO getReport(final ReportParamsDTO reportParamsDTO) {
        return trademarkRepository.getReportData(reportParamsDTO.getStartDate(), reportParamsDTO.getEndDate());
    }

    private void save(ZahtevZaPriznanjeZiga trademark) {
        trademarkRepository.save(trademark);
    }

}
