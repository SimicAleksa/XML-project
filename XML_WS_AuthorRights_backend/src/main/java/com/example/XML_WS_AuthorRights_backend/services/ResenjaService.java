package com.example.XML_WS_AuthorRights_backend.services;


import com.example.XML_WS_AuthorRights_backend.models.ResenjeZahteva;
import com.example.XML_WS_AuthorRights_backend.repository.ResenjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResenjaService {
    @Autowired
    private ResenjaRepository resenjaRepository;

    public void saveNewResenje(ResenjeZahteva resenjeZahteva) {
        resenjaRepository.save(resenjeZahteva);
    }

}
