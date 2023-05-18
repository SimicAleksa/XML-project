package com.example.XML_WS_Trademark_backend.repositories;

import com.example.XML_WS_Trademark_backend.database.ExistDatabase;
import com.example.XML_WS_Trademark_backend.database.FusekiDatabase;
import com.example.XML_WS_Trademark_backend.models.ZahtevZaPriznanjeZiga;
import com.example.XML_WS_Trademark_backend.utils.JAXBParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.modules.XMLResource;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TrademarkRepository {
    public static final String collectionUri = "/db/trademarks";
    private final JAXBParser<ZahtevZaPriznanjeZiga> jaxbParser;
    @Autowired
    private ExistDatabase existDB;
    @Autowired
    private FusekiDatabase fusekiDB;

    public TrademarkRepository() {
        this.jaxbParser = new JAXBParser<>(ZahtevZaPriznanjeZiga.class);
    }


    public void save(ZahtevZaPriznanjeZiga trademark) {
        String documentId = trademark.getMetaData().getBrojPrijave().getValue();
        try {
            String trademarkXML = jaxbParser.parseFromObjToByteStream(trademark);
            existDB.addToCollection(collectionUri, documentId, trademarkXML);
            fusekiDB.save(trademarkXML);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ZahtevZaPriznanjeZiga getTrademarkRequestById(String documentId) {
        try {
            XMLResource res = existDB.loadResourceById(collectionUri, documentId);
            if (res != null)
                return jaxbParser.parseFromXMLToObj(res.getContent().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ZahtevZaPriznanjeZiga> getAllTrademarkRequest() {
        List<ZahtevZaPriznanjeZiga> trademarkReqs = new ArrayList<>();
        try {
            ResourceIterator iterator = existDB.loadAllResources(collectionUri).getIterator();
            while (iterator.hasMoreResources())
                trademarkReqs.add(jaxbParser.parseFromXMLToObj(iterator.nextResource().getContent().toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trademarkReqs;
    }


}
