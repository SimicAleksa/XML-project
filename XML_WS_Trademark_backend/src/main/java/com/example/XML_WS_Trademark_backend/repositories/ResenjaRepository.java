package com.example.XML_WS_Trademark_backend.repositories;

import com.example.XML_WS_Trademark_backend.database.ExistDatabase;
import com.example.XML_WS_Trademark_backend.models.ResenjeZahteva;
import com.example.XML_WS_Trademark_backend.utils.JAXBParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ResenjaRepository {
    public static final String collectionUri = "/db/trademark-resenja";
    private final JAXBParser<ResenjeZahteva> jaxbParser;
    @Autowired
    private ExistDatabase existDB;

    public ResenjaRepository() {
        this.jaxbParser = new JAXBParser<>(ResenjeZahteva.class);
    }


    public void save(ResenjeZahteva resenjeZahteva) {
        try {
            String trademarkXML = jaxbParser.parseFromObjToByteStream(resenjeZahteva);
            existDB.addToCollection(collectionUri, resenjeZahteva.getBrojPrijave(), trademarkXML);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
