package com.example.XML_WS_AuthorRights_backend.services;

import com.example.XML_WS_AuthorRights_backend.DTOs.ComplexSearchParamsDTO;
import com.example.XML_WS_AuthorRights_backend.models.ZahtevZaAutorskoPravo;
import com.example.XML_WS_AuthorRights_backend.repository.AuthorRightsRepository;
import com.example.XML_WS_AuthorRights_backend.utils.PDForXHTMLGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return authorRightsRepository.getMetadataInRDF();
    }

    public String getJSON() {
        return authorRightsRepository.getMetadataInJSON();
    }
}
