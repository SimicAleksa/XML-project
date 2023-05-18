package com.example.XML_WS_Trademark_backend.repositories;

import com.example.XML_WS_Trademark_backend.DTOs.ComplexSearchParamsDTO;
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
import java.util.stream.Collectors;

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

    public List<ZahtevZaPriznanjeZiga> getTrademarksWithBasicSearch(List<String> params) {
        List<ZahtevZaPriznanjeZiga> trademarkReqs = new ArrayList<>();
        try {
            String xpathQuery = "//*[local-name()='ZahtevZaPriznanjeZiga' and (" +
                    params.stream().map(searchString -> "contains(., '" + searchString + "')")
                            .collect(Collectors.joining(" or ")) + ")]";
            ResourceIterator iterator = existDB.loadResourcesByCustomQuery(collectionUri, xpathQuery).getIterator();
            while (iterator.hasMoreResources())
                trademarkReqs.add(jaxbParser.parseFromXMLToObj(iterator.nextResource().getContent().toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trademarkReqs;
    }

    public List<ZahtevZaPriznanjeZiga> getTrademarksWithAdvancedSearch(ComplexSearchParamsDTO paramsDTO) {
        List<ZahtevZaPriznanjeZiga> trademarkReqs = new ArrayList<>();
        try {
            String xpathQuery = generateAdvancedSearchQuery(paramsDTO);
            ResourceIterator iterator = existDB.loadResourcesByCustomQuery(collectionUri, xpathQuery).getIterator();
            while (iterator.hasMoreResources())
                trademarkReqs.add(jaxbParser.parseFromXMLToObj(iterator.nextResource().getContent().toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trademarkReqs;
    }

    private String generateAdvancedSearchQuery(ComplexSearchParamsDTO paramsDTO) {
        boolean toAddAnd = false;

        String query = "/*[local-name()='ZahtevZaPriznanjeZiga'][";
        String nextQuery = generateEmailNalogaPodnosiocaQuery(paramsDTO.getEmailNalogaPodnosiocaFilter());
        if (!nextQuery.equals(""))
            toAddAnd = true;
        query += nextQuery;

        nextQuery = generateDatumPodnosenjaQuery(paramsDTO.getDatumPodnosenjaFilter());
        if (toAddAnd && !nextQuery.equals(""))
            query += " and ";
        query += nextQuery;

        nextQuery = generateStatusQuery(paramsDTO.getStatusFilter());
        if (toAddAnd && !nextQuery.equals(""))
            query += " and ";
        query += nextQuery + "]";

        return query;
    }

    private String generateEmailNalogaPodnosiocaQuery(List<ComplexSearchParamsDTO.EmailNalogaPodnosiocaFilterDTO> filters) {
        if (filters == null)
            return "";

        StringBuilder query = new StringBuilder();
        query.append("(.//*[local-name()='EmailNalogaPodnosioca' and (");
        for (ComplexSearchParamsDTO.EmailNalogaPodnosiocaFilterDTO f : filters) {
            query.append(String.format("%s(contains(text(),'%s')) ", f.getToNeg() ? "not" : "", f.getValue()));
            if (!f.getFollowingOperator().equals(""))
                query.append(String.format(" %s ",f.getFollowingOperator()));
        }
        query.append(")])");
        return query.toString();
    }

    private String generateDatumPodnosenjaQuery(List<ComplexSearchParamsDTO.DatumPodnosenjaFilterDTO> filters) {
        if (filters == null)
            return "";

        StringBuilder query = new StringBuilder();
        query.append("(.//*[local-name()='DatumPodnosenja' and (");
        for (ComplexSearchParamsDTO.DatumPodnosenjaFilterDTO f: filters) {
            query.append(String.format("xs:dateTime(.) %s xs:dateTime('%sT00:00:00') ", f.getDateOperator(), f.getValue()));
            if (!f.getFollowingOperator().equals(""))
                query.append(String.format(" %s ",f.getFollowingOperator()));
        }
        query.append(")])");
        return query.toString();
    }

    private String generateStatusQuery(List<ComplexSearchParamsDTO.StatusFilterDTO> filters) {
        if (filters == null)
            return "";

        StringBuilder query = new StringBuilder();
        query.append("(.//*[local-name()='Status' and (");
        for (ComplexSearchParamsDTO.StatusFilterDTO f: filters) {
            query.append(String.format("text()%s'%s'", f.getToNeg() ? " != " : " = ", f.getValue()));
            if (!f.getFollowingOperator().equals(""))
                query.append(String.format(" %s ",f.getFollowingOperator()));
        }
        query.append(")])");
        return query.toString();
    }
}
