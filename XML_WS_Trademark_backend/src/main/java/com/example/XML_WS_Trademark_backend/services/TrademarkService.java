package com.example.XML_WS_Trademark_backend.services;

import com.example.XML_WS_Trademark_backend.models.ZahtevZaPriznanjeZiga;
import com.example.XML_WS_Trademark_backend.repositories.TrademarkRepository;
import com.example.XML_WS_Trademark_backend.utils.PDFGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrademarkService {
    @Autowired
    private TrademarkRepository trademarkRepository;


    public void addNewTrademarkReq(ZahtevZaPriznanjeZiga trademark) {
        trademark.getMetaData().getBrojPrijave().setValue("Ж-" + (trademarkRepository.getAllTrademarkRequest().size()+1));
        trademark.getMetaData().getStatus().setValue("PENDING");
        save(trademark);
    }

    public List<ZahtevZaPriznanjeZiga> getAll() {
        return trademarkRepository.getAllTrademarkRequest();
    }

    public void getPDF() {
        try {
            PDFGenerator.generatePDFandHTML(trademarkRepository.getAllTrademarkRequest().get(1));
        } catch (Exception ignored) {
        }
    }

    private void save(ZahtevZaPriznanjeZiga trademark) {
        trademarkRepository.save(trademark);
    }

}
