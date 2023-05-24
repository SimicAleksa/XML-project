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

    public void save(ZahtevZaAutorskoPravo zaAutorskoPravo) {
        authorRightsRepository.save(zaAutorskoPravo);
    }

    public List<ZahtevZaAutorskoPravo> getAll() {
        return authorRightsRepository.getAllCopyRightRequest();
    }

    public void getPDF() {
        try {
            PDFGenerator.generatePDFandHTML(authorRightsRepository.getAllCopyRightRequest().get(0));
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }
}
