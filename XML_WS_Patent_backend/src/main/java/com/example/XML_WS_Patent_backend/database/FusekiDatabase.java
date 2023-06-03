package com.example.XML_WS_Patent_backend.database;

import com.example.XML_WS_Patent_backend.configs.Settings;
import com.example.XML_WS_Patent_backend.models.ZahtevZaPatent;
import com.example.XML_WS_Patent_backend.utils.MetadataExtractor;
import com.example.XML_WS_Patent_backend.utils.SparqlUtil;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.xml.transform.TransformerException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@Component
public class FusekiDatabase {
    private static final String SPARQL_NAMED_GRAPH_URI = "/patent/metadata";
    private static final String RDF_FILE_PATH = Settings.RDF_FILE_PATH;

    @Autowired
    public FusekiAuthManager authManager;


    public void save(ZahtevZaPatent patent) {
        String predNamespace = "http://www.patent.com/predicate/";
        Model model = ModelFactory.createDefaultModel();
        model.setNsPrefix("pred", predNamespace);

        Resource resource = model.createResource("http://www.patent.com/" + patent.getPopunjavaZavod().getBrojPrijave());

        resource.addProperty(model.createProperty(predNamespace, "BrojPrijave"), patent.getPopunjavaZavod().getBrojPrijave());
        resource.addProperty(model.createProperty(predNamespace, "EmailNalogaPodnosioca"), patent.getPopunjavaZavod().getEmailNalogaPodnosioca());
        resource.addProperty(model.createProperty(predNamespace, "DatumPodnosenja"), patent.getPopunjavaZavod().getDatumPrijema().toString());
        resource.addProperty(model.createProperty(predNamespace, "DatumPregledanja"), patent.getPopunjavaZavod().getDatumPregledanja().toString());
        resource.addProperty(model.createProperty(predNamespace, "Status"), patent.getPopunjavaZavod().getStatus());

        model.write(System.out, SparqlUtil.NTRIPLES);

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        model.write(out, SparqlUtil.NTRIPLES);

        String sparqlUpdate = SparqlUtil.insertData(
                authManager.endpoint + authManager.dataset + authManager.dataEndpoint + SPARQL_NAMED_GRAPH_URI,
                out.toString()
        );

        UpdateExecutionFactory.createRemote(
                UpdateFactory.create(sparqlUpdate),
                authManager.endpoint + authManager.dataset + authManager.updateEndpoint
        ).execute();
    }


    public String getAsRDF() {
        return getByType("RDF/XML");
    }

    private String getByType(String type) {
        String sparqlQuery = SparqlUtil.selectData(
                authManager.endpoint + authManager.dataset + authManager.dataEndpoint + SPARQL_NAMED_GRAPH_URI,
                "?s ?p ?o"
        );

        QueryExecution query = QueryExecutionFactory.sparqlService(
                authManager.endpoint + authManager.dataset + authManager.queryEndpoint,
                sparqlQuery
        );

        Model model = ModelFactory.createDefaultModel();

        ResultSet results = query.execSelect();
        while (results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            model.add(
                    model.createStatement(
                            solution.getResource("s"),
                            model.createProperty(solution.get("p").toString()),
                            solution.get("o")
                    )
            );
        }
        query.close();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        model.write(out, type);
        return out.toString();
    }

    public String getAsJSON() {
        return getByType("JSON-LD");
    }
}