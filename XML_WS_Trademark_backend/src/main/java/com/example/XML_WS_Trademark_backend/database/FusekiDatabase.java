package com.example.XML_WS_Trademark_backend.database;

import com.example.XML_WS_Trademark_backend.utils.MetadataExtractor;
import com.example.XML_WS_Trademark_backend.utils.SparqlUtil;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
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
    private static final String SPARQL_NAMED_GRAPH_URI = "/trademark/metadata";
    private static final String RDF_FILE_PATH = "src/main/resources/formats_data/ZahtevZaPriznanjeZiga.rdf";

    @Autowired
    public FusekiAuthManager authManager;


    public void save(String reqXML) throws IOException, TransformerException {

        MetadataExtractor.extractMetadata(reqXML, Files.newOutputStream(Paths.get(RDF_FILE_PATH)));
        Model model = ModelFactory.createDefaultModel();
        model.read(RDF_FILE_PATH);

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        model.write(out, SparqlUtil.NTRIPLES);

        String sparqlUpdate = SparqlUtil.insertData(
                            authManager.endpoint + authManager.dataset  + authManager.dataEndpoint + SPARQL_NAMED_GRAPH_URI,
                                    out.toString()
                            );

        UpdateExecutionFactory.createRemote(
                                            UpdateFactory.create(sparqlUpdate),
                                            authManager.endpoint + authManager.dataset + authManager.updateEndpoint
                                    ).execute();
    }

    public void read() {
        String sparqlQuery = SparqlUtil.selectData(
                        authManager.endpoint + authManager.dataset + authManager.dataEndpoint + SPARQL_NAMED_GRAPH_URI,
                        "?s ?p ?o"
                        );

        QueryExecution query = QueryExecutionFactory.sparqlService(
                                        authManager.endpoint + authManager.dataset + authManager.queryEndpoint,
                                        sparqlQuery
                                );

        ResultSet results = query.execSelect();
        ResultSetFormatter.out(System.out, results);
        query.close() ;
    }

}