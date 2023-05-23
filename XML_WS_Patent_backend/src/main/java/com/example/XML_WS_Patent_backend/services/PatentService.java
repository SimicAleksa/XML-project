package com.example.XML_WS_Patent_backend.services;


import com.example.XML_WS_Patent_backend.models.ZahtevZaPatent;
import com.example.XML_WS_Patent_backend.repository.PatentRepository;
import com.example.XML_WS_Patent_backend.utils.PDForXHTMLGenerator;
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

    public void changePatentStatus(String patentId, boolean isApproved) {
        ZahtevZaPatent patentReq = patentRepository.getPatentRequestById(patentId);
        patentReq.getPopunjavaZavod().setStatus(isApproved ? "PRIHVACENO" : "ODBIJENO");
        save(patentReq);
    }

}
