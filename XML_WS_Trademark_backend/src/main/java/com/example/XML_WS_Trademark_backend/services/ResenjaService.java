package com.example.XML_WS_Trademark_backend.services;


import com.example.XML_WS_Trademark_backend.models.ResenjeZahteva;
import com.example.XML_WS_Trademark_backend.repositories.ResenjaRepository;
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
