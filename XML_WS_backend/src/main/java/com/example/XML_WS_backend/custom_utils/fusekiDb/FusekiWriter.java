package com.example.XML_WS_backend.custom_utils.fusekiDb;

import com.example.XML_WS_backend.custom_utils.authenticationUtilities.FusekiAuthenticationUtilities;
import com.example.XML_WS_backend.custom_utils.authenticationUtilities.FusekiAuthenticationUtilities.ConnectionProperties;
import com.example.XML_WS_backend.custom_utils.grddl.MetadataExtractor;
import com.example.XML_WS_backend.custom_utils.sparql.SparqlUtil;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.xml.sax.SAXException;

import javax.xml.transform.TransformerException;
import java.io.*;

public class FusekiWriter {
    private static final String SPARQL_NAMED_GRAPH_URI = "/example/sparql/metadata";

    public static void main(String[] args) throws Exception {
        run(FusekiAuthenticationUtilities.loadProperties());
    }

    public static void run(ConnectionProperties conn) throws IOException, SAXException, TransformerException {

        System.out.println("[INFO] " + FusekiWriter.class.getSimpleName());

        // Referencing XML file with RDF data in attributes
        String xmlFilePath = "data/autorska_prava/ZAHTEV_ZA_AUTORSKA_PRAVA.xml";

        String rdfFilePath = "data/rdf/ZAHTEV_ZA_AUTORSKA_PRAVA.rdf";

        // Automatic extraction of RDF triples from XML file
        MetadataExtractor metadataExtractor = new MetadataExtractor();

        System.out.println("[INFO] Extracting metadata from RDFa attributes...");
        metadataExtractor.extractMetadata(
                new FileInputStream(new File(xmlFilePath)),
                new FileOutputStream(new File(rdfFilePath)));


        // Loading a default model with extracted metadata
        Model model = ModelFactory.createDefaultModel();
        model.read(rdfFilePath);

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        model.write(out, SparqlUtil.NTRIPLES);

        System.out.println("[INFO] Extracted metadata as RDF/XML...");
        model.write(System.out, SparqlUtil.RDF_XML);


        // Writing the named graph
        System.out.println("[INFO] Populating named graph \"" + SPARQL_NAMED_GRAPH_URI + "\" with extracted metadata.");
        String sparqlUpdate = SparqlUtil.insertData(conn.dataEndpoint + SPARQL_NAMED_GRAPH_URI, new String(out.toByteArray()));
        System.out.println(sparqlUpdate);

        // UpdateRequest represents a unit of execution
        UpdateRequest update = UpdateFactory.create(sparqlUpdate);

        UpdateProcessor processor = UpdateExecutionFactory.createRemote(update, conn.updateEndpoint);
        processor.execute();



        // Read the triples from the named graph
        System.out.println();
        System.out.println("[INFO] Retrieving triples from RDF store.");
        System.out.println("[INFO] Using \"" + SPARQL_NAMED_GRAPH_URI + "\" named graph.");

        System.out.println("[INFO] Selecting the triples from the named graph \"" + SPARQL_NAMED_GRAPH_URI + "\".");
        String sparqlQuery = SparqlUtil.selectData(conn.dataEndpoint + SPARQL_NAMED_GRAPH_URI, "?s ?p ?o");

        // Create a QueryExecution that will access a SPARQL service over HTTP
        QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);


        // Query the collection, dump output response as XML
        ResultSet results = query.execSelect();

        ResultSetFormatter.out(System.out, results);

        query.close() ;

        System.out.println("[INFO] End.");
    }
}
