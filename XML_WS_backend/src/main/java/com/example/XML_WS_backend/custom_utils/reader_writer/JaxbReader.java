package com.example.XML_WS_backend.custom_utils.reader_writer;

import com.example.XML_WS_backend.custom_utils.authenticationUtilities.AuthenticationUtilities;
import com.example.XML_WS_backend.models.zahtev_za_patent.ZahtevZaPatent;
import org.exist.xmldb.EXistResource;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.OutputKeys;

public class JaxbReader {
    public static ZahtevZaPatent ispis(String collectionName,String documentName) throws Exception {
        AuthenticationUtilities.ConnectionProperties conn  = AuthenticationUtilities.loadProperties();

        System.out.println("[INFO] " + JaxbReader.class.getSimpleName());

        // initialize collection and document identifiers
        String collectionId = null;
        String documentId = null;

        System.out.println("[INFO] Using defaults.");

        collectionId = "/db/sample/"+collectionName;
        documentId = documentName;


        System.out.println("\t- collection ID: " + collectionId);
        System.out.println("\t- document ID: " + documentId + "\n");

        // initialize database driver
        System.out.println("[INFO] Loading driver class: " + conn.driver);
        Class<?> cl = Class.forName(conn.driver);

        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");

        DatabaseManager.registerDatabase(database);

        Collection col = null;
        XMLResource res = null;
        ZahtevZaPatent zahtevZaPatent =null;

        try {
            // get the collection
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = DatabaseManager.getCollection(conn.uri + collectionId);
            col.setProperty(OutputKeys.INDENT, "yes");

            System.out.println("[INFO] Retrieving the document: " + documentId);
            res = (XMLResource) col.getResource(documentId);

            if (res == null) {
                System.out.println("[WARNING] Document '" + documentId + "' can not be found!");
            } else {

                System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");
                JAXBContext context = JAXBContext.newInstance(ZahtevZaPatent.class);

                Unmarshaller unmarshaller = context.createUnmarshaller();

                zahtevZaPatent = (ZahtevZaPatent) unmarshaller.unmarshal(res.getContentAsDOM());

                System.out.println("[INFO] Showing the document as JAXB instance: ");
                System.out.println(zahtevZaPatent);

            }
        } finally {
            //don't forget to clean up!

//            if (res != null) {
//                try {
//                    ((EXistResource) res).freeResources();
//                } catch (XMLDBException xe) {
//                    xe.printStackTrace();
//                }
//            }

            if (col != null) {
                try {
                    col.close();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
        }
        return zahtevZaPatent;
    }
}
