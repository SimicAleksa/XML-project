package com.example.XML_WS_Patent_backend.services;


import com.example.XML_WS_Patent_backend.models.ZahtevZaPatent;
import com.example.XML_WS_Patent_backend.repository.PatentRepository;
import com.example.XML_WS_Patent_backend.utils.PDFGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                .filter(req -> req.getPopunjavaZavod().getStatus().equals("PENDING"))
                .collect(Collectors.toList());
    }

    public void getPDF() {
        try {
            PDFGenerator.generatePDFandHTML(patentRepository.getAllPatentRequest().get(0));
        } catch (Exception ignored) {}
    }

}
