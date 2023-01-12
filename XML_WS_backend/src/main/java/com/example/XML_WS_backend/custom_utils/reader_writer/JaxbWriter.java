package com.example.XML_WS_backend.custom_utils.reader_writer;

import com.example.XML_WS_backend.custom_utils.authenticationUtilities.AuthenticationUtilities;
import com.example.XML_WS_backend.models.zahtev_za_patent.ZahtevZaPatent;
import org.exist.xmldb.EXistResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.math.BigDecimal;

import static com.example.XML_WS_backend.custom_utils.connectionUtil.CollectionUtil.getOrCreateCollection;

@Repository
public class JaxbWriter {

    public static ZahtevZaPatent upis(String collectionName, String documentName, ZahtevZaPatent zahtevZaPatent) throws Exception {

        AuthenticationUtilities.ConnectionProperties conn = AuthenticationUtilities.loadProperties();

        System.out.println("[INFO] " + JaxbWriter.class.getSimpleName());

        // initialize collection and document identifiers
        String collectionId = null;
        String documentId = null;

        System.out.println("[INFO] Using defaults.");

        collectionId = "/db/sample/"+collectionName;
        documentId = documentName;



        System.out.println("\t- collection ID: " + collectionId);
        System.out.println("\t- document ID: " + documentId);

        // initialize database driver
        System.out.println("[INFO] Loading driver class: " + conn.driver);
        Class<?> cl = Class.forName(conn.driver);


        // encapsulation of the database driver functionality
        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");

        // entry point for the API which enables you to get the Collection reference
        DatabaseManager.registerDatabase(database);

        // a collection of Resources stored within an XML database
        Collection col = null;
        XMLResource res = null;
        OutputStream os = new ByteArrayOutputStream();

        try {

            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = getOrCreateCollection(collectionId,conn);

            /*
             *  create new XMLResource with a given id
             *  an id is assigned to the new resource if left empty (null)
             */
            System.out.println("[INFO] Inserting the document: " + documentId);
            res = (XMLResource) col.createResource(documentId+".xml", XMLResource.RESOURCE_TYPE);

            System.out.println("[INFO] Unmarshalling XML document to an JAXB instance: ");
            JAXBContext context = JAXBContext.newInstance(ZahtevZaPatent.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // marshal the contents to an output stream
            marshaller.marshal(zahtevZaPatent, os);

            // link the stream to the XML resource
            res.setContent(os);
            System.out.println("[INFO] Storing the document: " + res.getId());

            col.storeResource(res);
            System.out.println("[INFO] Done.");



        }catch (Error e){
            System.out.println("Bila je greska");
            e.printStackTrace();
        } finally {

            //don't forget to cleanup
//            if(res != null) {
//                try {
//                    ((EXistResource)res).freeResources();
//                } catch (XMLDBException xe) {
//                    xe.printStackTrace();
//                }
//            }

            if(col != null) {
                try {
                    col.close();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
            return zahtevZaPatent;
        }
    }
}
