package com.example.XML_WS_Trademark_backend.services;

import com.example.XML_WS_Trademark_backend.DTOs.ComplexSearchParamsDTO;
import com.example.XML_WS_Trademark_backend.models.ZahtevZaPriznanjeZiga;
import com.example.XML_WS_Trademark_backend.repositories.TrademarkRepository;
import com.example.XML_WS_Trademark_backend.utils.PDForXHTMLGenerator;
import com.example.XML_WS_Trademark_backend.utils.QRCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrademarkService {
    @Autowired
    private TrademarkRepository trademarkRepository;


    public void addNewTrademarkReq(ZahtevZaPriznanjeZiga trademark) {
        trademark.getMetaData().getBrojPrijave().setValue("Ж-" + (trademarkRepository.getAllTrademarkRequest().size() + 1));
        trademark.getMetaData().getStatus().setValue("NERESENO");
        save(trademark);
    }

    public List<ZahtevZaPriznanjeZiga> getAll() {
        return trademarkRepository.getAllTrademarkRequest();
    }

    public List<ZahtevZaPriznanjeZiga> getPendingRequests() {
        return trademarkRepository.getAllTrademarkRequest().stream()
                .filter(req -> req.getMetaData().getStatus().getValue().equals("NERESENO"))
                .collect(Collectors.toList());
    }

    public byte[] getPDF(String brojPrijave) {
        try {
            return PDForXHTMLGenerator.getPDF(trademarkRepository.getTrademarkRequestById(brojPrijave));
        } catch (Exception ignored) {
        }
        return new byte[0];
    }

    public byte[] getXHTML(String brojPrijave) {
        try {
            return PDForXHTMLGenerator.getXHTML(trademarkRepository.getTrademarkRequestById(brojPrijave));
        } catch (Exception ignored) {
        }
        return new byte[0];
    }

    public void changeTrademarkStatus(String trademarkId, boolean isApproved) {
        ZahtevZaPriznanjeZiga trademarkReq = trademarkRepository.getTrademarkRequestById(trademarkId);
        trademarkReq.getMetaData().getStatus().setValue(isApproved ? "PRIHVACENO" : "ODBIJENO");
        save(trademarkReq);
    }

    public List<ZahtevZaPriznanjeZiga> basicSearch(List<String> params, boolean onlyApproved) {
        List<ZahtevZaPriznanjeZiga> reqs = trademarkRepository.getTrademarksWithBasicSearch(params);
        if (onlyApproved)
            return reqs.stream().filter(req -> req.getMetaData().getStatus().getValue().equals("PRIHVACENO"))
                    .collect(Collectors.toList());
        return reqs;
    }

    public List<ZahtevZaPriznanjeZiga> advancedSearch(ComplexSearchParamsDTO searchParamsDTO) {
        List<ZahtevZaPriznanjeZiga> reqs = trademarkRepository.getTrademarksWithAdvancedSearch(searchParamsDTO);
        if (searchParamsDTO.getOnlyApproved())
            return reqs.stream().filter(req -> req.getMetaData().getStatus().getValue().equals("PRIHVACENO"))
                    .collect(Collectors.toList());
        return reqs;
    }

    public String getRDF() {
        return trademarkRepository.getMetadataInRDF();
    }

    public String getJSON() {
        return trademarkRepository.getMetadataInJSON();
    }

    public byte[] getQRCode(String id) {
        return QRCodeGenerator.getAsBytes(id);
    }

    private void save(ZahtevZaPriznanjeZiga trademark) {
        trademarkRepository.save(trademark);
    }

}
