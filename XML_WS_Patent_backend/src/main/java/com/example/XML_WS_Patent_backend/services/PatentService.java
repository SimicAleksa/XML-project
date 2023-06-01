package com.example.XML_WS_Patent_backend.services;


import com.example.XML_WS_Patent_backend.DTOs.ComplexSearchParamsDTO;
import com.example.XML_WS_Patent_backend.DTOs.ReportDTO;
import com.example.XML_WS_Patent_backend.DTOs.ReportParamsDTO;
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
}
