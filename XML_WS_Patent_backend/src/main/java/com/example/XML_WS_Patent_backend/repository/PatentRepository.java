package com.example.XML_WS_Patent_backend.repository;


import com.example.XML_WS_Patent_backend.database.ExistDatabase;
import com.example.XML_WS_Patent_backend.database.FusekiDatabase;
import com.example.XML_WS_Patent_backend.models.ZahtevZaPatent;
import com.example.XML_WS_Patent_backend.utils.JAXBParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.modules.XMLResource;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PatentRepository {
    public static final String collectionUri = "/db/patents";
    public static final String documentId = "1";

    private final JAXBParser<ZahtevZaPatent> jaxbParser;
    @Autowired
    private ExistDatabase patentDB;
    @Autowired
    private FusekiDatabase fusekiDB;

    public PatentRepository() {
        this.jaxbParser = new JAXBParser<>(ZahtevZaPatent.class);
    }


    public void save(ZahtevZaPatent patent) {
        try {
            String documentID = patent.getPopunjavaZavod().getBrojPrijave().concat(".xml");
            String patentXML = jaxbParser.parseFromObjToByteStream(patent);
            patentDB.addToCollection(collectionUri, documentID, patentXML);
            fusekiDB.save(patentXML);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ZahtevZaPatent getTrademarkRequestById(String trademarkReqNum) {
        try {
            XMLResource res = patentDB.loadResourceById(collectionUri, documentId);
            if (res != null)
                return jaxbParser.parseFromXMLToObj(res.getContent().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ZahtevZaPatent> getAllTrademarkRequest() {
        List<ZahtevZaPatent> trademarkReqs = new ArrayList<>();
        try {
            ResourceIterator iterator = patentDB.loadAllResources(collectionUri).getIterator();
            while (iterator.hasMoreResources())
                trademarkReqs.add(jaxbParser.parseFromXMLToObj(iterator.nextResource().getContent().toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trademarkReqs;
    }

}
