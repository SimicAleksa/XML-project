package com.example.XML_WS_AuthorRights_backend.repository;

import com.example.XML_WS_AuthorRights_backend.database.ExistDatabase;
import com.example.XML_WS_AuthorRights_backend.models.ResenjeZahteva;
import com.example.XML_WS_AuthorRights_backend.utils.JAXBParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ResenjaRepository {
    public static final String collectionUri = "/db/cr-resenja";
    private final JAXBParser<ResenjeZahteva> jaxbParser;
    @Autowired
    private ExistDatabase existDB;

    public ResenjaRepository() {
        this.jaxbParser = new JAXBParser<>(ResenjeZahteva.class);
    }


    public void save(ResenjeZahteva resenjeZahteva) {
        try {
            String patentXML = jaxbParser.parseFromObjToByteStream(resenjeZahteva);
            existDB.addToCollection(collectionUri, resenjeZahteva.getBrojPrijave(), patentXML);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
