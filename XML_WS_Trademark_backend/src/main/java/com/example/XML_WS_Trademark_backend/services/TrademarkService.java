package com.example.XML_WS_Trademark_backend.services;

import com.example.XML_WS_Trademark_backend.models.ZahtevZaPriznanjeZiga;
import com.example.XML_WS_Trademark_backend.repositories.TrademarkRepository;
import com.example.XML_WS_Trademark_backend.utils.PDForXHTMLGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ZahtevZaPriznanjeZiga> getPendingRequests() {
        return trademarkRepository.getAllTrademarkRequest().stream()
                .filter(req -> req.getMetaData().getStatus().getValue().equals("PENDING"))
                .collect(Collectors.toList());
    }

    public byte[] getPDF(String brojPrijave) {
        try {
            return PDForXHTMLGenerator.getPDF(getZahtevByBrojPrijave(brojPrijave));
        } catch (Exception ignored) {}
        return new byte[0];
    }

    public byte[] getXHTML(String brojPrijave) {
        try {
            return PDForXHTMLGenerator.getXHTML(getZahtevByBrojPrijave(brojPrijave));
        } catch (Exception ignored) {}
        return new byte[0];
    }

    private void save(ZahtevZaPriznanjeZiga trademark) {
        trademarkRepository.save(trademark);
    }

    private ZahtevZaPriznanjeZiga getZahtevByBrojPrijave(String brojPrijave) {
        ZahtevZaPriznanjeZiga trademarkReq = null;
        for (ZahtevZaPriznanjeZiga req: trademarkRepository.getAllTrademarkRequest())
            if (req.getMetaData().getBrojPrijave().getValue().equals(brojPrijave)) {
                trademarkReq = req;
                break;
            }
        return trademarkReq;
    }

}
