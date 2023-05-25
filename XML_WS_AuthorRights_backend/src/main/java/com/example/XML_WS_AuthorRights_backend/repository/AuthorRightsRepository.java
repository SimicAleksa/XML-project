package com.example.XML_WS_AuthorRights_backend.repository;

import com.example.XML_WS_AuthorRights_backend.database.ExistDatabase;
import com.example.XML_WS_AuthorRights_backend.database.FusekiDatabase;
import com.example.XML_WS_AuthorRights_backend.models.ZahtevZaAutorskoPravo;
import com.example.XML_WS_AuthorRights_backend.utils.JAXBParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.modules.XMLResource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AuthorRightsRepository {
    public static final String collectionUri = "/db/author-rights";
    public static final String documentId = "1";

    private final JAXBParser<ZahtevZaAutorskoPravo> jaxbParser;
    @Autowired
    private ExistDatabase copyRightDB;
    @Autowired
    private FusekiDatabase fusekiDB;

    public AuthorRightsRepository() {
        this.jaxbParser = new JAXBParser<>(ZahtevZaAutorskoPravo.class);
    }


    public void save(ZahtevZaAutorskoPravo copyRight) {
        try {
            String documentID = copyRight.getBrojPrijave().concat(".xml");
            String copyRightXML = jaxbParser.parseFromObjToByteStream(copyRight);
            copyRightDB.addToCollection(collectionUri, documentID, copyRightXML);
            fusekiDB.save(copyRightXML);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ZahtevZaAutorskoPravo getCRRequestById(String crReqNum) {
        try {
            XMLResource res = copyRightDB.loadResourceById(collectionUri, crReqNum.concat(".xml"));
            if (res != null)
                return jaxbParser.parseFromXMLToObj(res.getContent().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ZahtevZaAutorskoPravo> getAllCopyRightRequest() {
        List<ZahtevZaAutorskoPravo> trademarkReqs = new ArrayList<>();
        try {
            ResourceIterator iterator = copyRightDB.loadAllResources(collectionUri).getIterator();
            while (iterator.hasMoreResources())
                trademarkReqs.add(jaxbParser.parseFromXMLToObj(iterator.nextResource().getContent().toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trademarkReqs;
    }

    public List<ZahtevZaAutorskoPravo> getCopyRightWithBasicSearch(List<String> params) {
        List<ZahtevZaAutorskoPravo> copyRightReqs = new ArrayList<>();
        try {
            String xpathQuery = "//*[local-name()='ZahtevZaAutorskoPravo' and (" +
                    params.stream().map(searchString -> "contains(., '" + searchString + "')")
                            .collect(Collectors.joining(" or ")) + ")]";
            ResourceIterator iterator = copyRightDB.loadResourcesByCustomQuery(collectionUri, xpathQuery).getIterator();
            while (iterator.hasMoreResources())
                copyRightReqs.add(jaxbParser.parseFromXMLToObj(iterator.nextResource().getContent().toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return copyRightReqs;
    }
}
