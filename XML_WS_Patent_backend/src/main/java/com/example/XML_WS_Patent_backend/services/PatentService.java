package com.example.XML_WS_Patent_backend.services;


import com.example.XML_WS_Patent_backend.models.ZahtevZaPatent;
import com.example.XML_WS_Patent_backend.repository.PatentRepository;
import com.example.XML_WS_Patent_backend.utils.PDFGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatentService {
    @Autowired
    private PatentRepository patentRepository;

    public void save(ZahtevZaPatent trademark) {
        patentRepository.save(trademark);
    }

    public List<ZahtevZaPatent> getAll() {
        return patentRepository.getAllTrademarkRequest();
    }

    public void getPDF() {
        try {
            PDFGenerator.generatePDFandHTML(patentRepository.getAllTrademarkRequest().get(0));
        } catch (Exception ignored) {}
    }

}
