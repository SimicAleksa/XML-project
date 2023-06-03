package com.example.XML_WS_Patent_backend.repository;


import com.example.XML_WS_Patent_backend.DTOs.ComplexSearchParamsDTO;
import com.example.XML_WS_Patent_backend.DTOs.ReportDTO;
import com.example.XML_WS_Patent_backend.DTOs.ReportParamsDTO;
import com.example.XML_WS_Patent_backend.database.ExistDatabase;
import com.example.XML_WS_Patent_backend.database.FusekiDatabase;
import com.example.XML_WS_Patent_backend.models.ZahtevZaPatent;
import com.example.XML_WS_Patent_backend.utils.JAXBParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.modules.XMLResource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
            fusekiDB.save(patent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ZahtevZaPatent getPatentRequestById(String patentReqNum) {
        try {
            XMLResource res = patentDB.loadResourceById(collectionUri, patentReqNum.concat(".xml"));
            if (res != null)
                return jaxbParser.parseFromXMLToObj(res.getContent().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ZahtevZaPatent> getAllPatentRequest() {
        List<ZahtevZaPatent> patentReqs = new ArrayList<>();
        try {
            ResourceIterator iterator = patentDB.loadAllResources(collectionUri).getIterator();
            while (iterator.hasMoreResources())
                patentReqs.add(jaxbParser.parseFromXMLToObj(iterator.nextResource().getContent().toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patentReqs;
    }

    public List<ZahtevZaPatent> getPatentWithBasicSearch(List<String> params) {
        List<ZahtevZaPatent> patentReqs = new ArrayList<>();
        try {
            String xpathQuery = "//*[local-name()='Zahtev_za_patent' and (" +
                    params.stream().map(searchString -> "contains(., '" + searchString + "')")
                            .collect(Collectors.joining(" or ")) + ")]";
            ResourceIterator iterator = patentDB.loadResourcesByCustomQuery(collectionUri, xpathQuery).getIterator();
            while (iterator.hasMoreResources())
                patentReqs.add(jaxbParser.parseFromXMLToObj(iterator.nextResource().getContent().toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patentReqs;
    }

    public List<ZahtevZaPatent> getPatentWithAdvancedSearch(ComplexSearchParamsDTO paramsDTO) {
        List<ZahtevZaPatent> patentReqs = new ArrayList<>();
        try {
            String xpathQuery = generateAdvancedSearchQuery(paramsDTO);
            ResourceIterator iterator = patentDB.loadResourcesByCustomQuery(collectionUri, xpathQuery).getIterator();
            while (iterator.hasMoreResources())
                patentReqs.add(jaxbParser.parseFromXMLToObj(iterator.nextResource().getContent().toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patentReqs;
    }

    private String generateAdvancedSearchQuery(ComplexSearchParamsDTO paramsDTO) {
        boolean toAddAnd = false;

        String query = "/*[local-name()='Zahtev_za_patent'][";
        String nextQuery = generateEmailNalogaPodnosiocaQuery(paramsDTO.getEmailNalogaPodnosiocaFilter());
        if (!nextQuery.equals(""))
            toAddAnd = true;
        query += nextQuery;
        if (!nextQuery.equals(""))
            toAddAnd = true;
        nextQuery = generateDatumPodnosenjaQuery(paramsDTO.getDatumPodnosenjaFilter());
        if (toAddAnd && !nextQuery.equals(""))
            query += " and ";
        query += nextQuery;
        if (!nextQuery.equals(""))
            toAddAnd = true;
        nextQuery = generateDatumPregledanjaQuery(paramsDTO.getDatumPregledanjaFilter());
        if (toAddAnd && !nextQuery.equals(""))
            query += " and ";
        query += nextQuery;
        if (!nextQuery.equals(""))
            toAddAnd = true;
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
        query.append("(.//*[local-name()='email_naloga_podnosioca' and (");
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
        query.append("(.//*[local-name()='priznati_datum_podnosenja' and (");
        for (ComplexSearchParamsDTO.DatumPodnosenjaFilterDTO f: filters) {
            query.append(String.format("xs:dateTime(.) %s xs:dateTime('%sT00:00:00') ", f.getDateOperator(), f.getValue()));
            if (!f.getFollowingOperator().equals(""))
                query.append(String.format(" %s ",f.getFollowingOperator()));
        }
        query.append(")])");
        return query.toString();
    }

    private String generateDatumPregledanjaQuery(List<ComplexSearchParamsDTO.DatumPregledanjaFilterDTO> filters) {
        if (filters == null)
            return "";

        StringBuilder query = new StringBuilder();
        query.append("(.//*[local-name()='datum_pregledanja' and (");
        for (ComplexSearchParamsDTO.DatumPregledanjaFilterDTO f: filters) {
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
        query.append("(.//*[local-name()='status' and (");
        for (ComplexSearchParamsDTO.StatusFilterDTO f: filters) {
            query.append(String.format("text()%s'%s'", f.getToNeg() ? " != " : " = ", f.getValue()));
            if (!f.getFollowingOperator().equals(""))
                query.append(String.format(" %s ",f.getFollowingOperator()));
        }
        query.append(")])");
        return query.toString();
    }

    public ReportDTO getReport(ReportParamsDTO paramsDTO) {
        List<ZahtevZaPatent> patentReqs = new ArrayList<>();
        ReportDTO reportDTO = new ReportDTO();
        int brojZahteva=0;
        int brojPrihvacenih=0;
        int brojOdbijenih=0;
        try {
            String xpathQuery = "/*[local-name()='Zahtev_za_patent']";
            ResourceIterator iterator = patentDB.loadResourcesByCustomQuery(collectionUri, xpathQuery).getIterator();
            while (iterator.hasMoreResources())
                patentReqs.add(jaxbParser.parseFromXMLToObj(iterator.nextResource().getContent().toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String startDateStrting = paramsDTO.getStartDate();
        String endDateStrting = paramsDTO.getEndDate();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date startDate = dateFormat.parse(startDateStrting);
            Date endDate = dateFormat.parse(endDateStrting);

            for (ZahtevZaPatent zzp : patentReqs) {
                String datumPrijemaString = zzp.getPopunjavaZavod().getDatumPrijema();
                Date datumPrijema = dateFormat.parse(datumPrijemaString);
                if (datumPrijema.compareTo(endDate)<0 && datumPrijema.compareTo(startDate)>0)
                    brojZahteva++;
                String datumPregledanjaString = zzp.getPopunjavaZavod().getDatumPregledanja();
                Date datumPregledanja = dateFormat.parse(datumPregledanjaString);
                if (datumPregledanja.compareTo(endDate)<0 && datumPregledanja.compareTo(startDate)>0)
                {
                    if(zzp.getPopunjavaZavod().getStatus().equals("PRIHVACENO"))
                        brojPrihvacenih++;
                    if(zzp.getPopunjavaZavod().getStatus().equals("ODBIJENO"))
                        brojOdbijenih++;
                }
            }
        }
        catch (ParseException e) {
            // Handle the ParseException if the string values are not in the expected date format
            e.printStackTrace();
        }
        reportDTO.setPodneti(String.valueOf(brojZahteva));
        reportDTO.setOdbijeni(String.valueOf(brojOdbijenih));
        reportDTO.setPrihvaceni(String.valueOf(brojPrihvacenih));


        return reportDTO;
    }


    public String getMetadataInRDF() {
        return fusekiDB.getAsRDF();
    }

    public String getMetadataInJSON() {
        return fusekiDB.getAsJSON();
    }
}
