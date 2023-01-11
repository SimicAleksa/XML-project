package com.example.XML_WS_Trademark_backend.services;

import com.example.XML_WS_Trademark_backend.models.ZahtevZaPriznanjeZiga;
import com.example.XML_WS_Trademark_backend.repositories.TrademarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrademarkService {
    public final String contextPath = "com.zavod.model";
    public final String dataPath = "./data/z1.xml";

    private List<ZahtevZaPriznanjeZiga> trademarks;

    @Autowired
    private TrademarkRepository trademarkRepository;


    public List<ZahtevZaPriznanjeZiga> getAll() {
        return null;
    }


}
