package com.example.XML_WS_Trademark_backend.repositories;

import com.example.XML_WS_Trademark_backend.database.TrademarkDatabase;
import com.example.XML_WS_Trademark_backend.models.ZahtevZaPriznanjeZiga;
import com.example.XML_WS_Trademark_backend.utils.TrademarkParserJAXB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.modules.XMLResource;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TrademarkRepository {
    public static final String collectionUri = "/db/trademarks";
    public static final String documentId = "1";
    @Autowired
    private TrademarkDatabase trademarkDB;

    public void save(ZahtevZaPriznanjeZiga trademark) {
        try {
            trademarkDB.addToCollection(collectionUri, documentId, TrademarkParserJAXB.parseFromObjToByteStream(trademark));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ZahtevZaPriznanjeZiga getTrademarkRequestById(String trademarkReqNum) {
        try {
            XMLResource res = trademarkDB.loadResourceById(collectionUri, documentId);
            if (res != null)
                return TrademarkParserJAXB.parseFromXMLToObj(res.getContent().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ZahtevZaPriznanjeZiga> getAllTrademarkRequest() {
        List<ZahtevZaPriznanjeZiga> trademarkReqs = new ArrayList<>();
        try {
            ResourceIterator iterator = trademarkDB.loadAllResources(collectionUri).getIterator();
            while (iterator.hasMoreResources())
                trademarkReqs.add(TrademarkParserJAXB.parseFromXMLToObj(iterator.nextResource().getContent().toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trademarkReqs;
    }


}
