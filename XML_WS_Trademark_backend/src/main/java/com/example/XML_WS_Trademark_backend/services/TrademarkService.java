package com.example.XML_WS_Trademark_backend.services;

import com.example.XML_WS_Trademark_backend.models.ZahtevZaPriznanjeZiga;
import com.example.XML_WS_Trademark_backend.repositories.TrademarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrademarkService {
    @Autowired
    private TrademarkRepository trademarkRepository;

    public void save(ZahtevZaPriznanjeZiga trademark) {
        trademarkRepository.save(trademark);
    }

    public List<ZahtevZaPriznanjeZiga> getAll() {
        return trademarkRepository.getAllTrademarkRequest();
    }


}
