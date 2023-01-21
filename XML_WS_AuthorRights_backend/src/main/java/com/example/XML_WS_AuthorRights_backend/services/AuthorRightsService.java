package com.example.XML_WS_AuthorRights_backend.services;

import com.example.XML_WS_AuthorRights_backend.models.ZahtevZaAutorskoPravo;
import com.example.XML_WS_AuthorRights_backend.repository.AuthorRightsRepository;
import com.example.XML_WS_AuthorRights_backend.utils.PDFGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthorRightsService {
    @Autowired
    private AuthorRightsRepository authorRightsRepository;

    public void save(ZahtevZaAutorskoPravo trademark) {
        authorRightsRepository.save(trademark);
    }

    public List<ZahtevZaAutorskoPravo> getAll() {
        return authorRightsRepository.getAllTrademarkRequest();
    }

    public void getPDF() {
        try {
            PDFGenerator.generatePDFandHTML(authorRightsRepository.getAllTrademarkRequest().get(0));
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }
}
