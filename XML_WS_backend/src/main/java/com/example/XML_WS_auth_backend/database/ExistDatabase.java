package com.example.XML_WS_auth_backend.database;

import org.exist.xmldb.EXistResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;

import javax.xml.transform.OutputKeys;

@Component
public class ExistDatabase {
    public static String collectionUri = "/db/users";

    @Autowired
    public ExistAuthManager authManager;

    public void createDBConnection() throws Exception {
        Class<?> cl = Class.forName(authManager.getDriver());
        Database database = (Database) cl.getDeclaredConstructor().newInstance();
        database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database);
    }

    public void closeDBConnection(Collection collection, XMLResource resource) throws XMLDBException {
        if (collection != null)
            collection.close();

        if (resource != null)
            ((EXistResource) resource).freeResources();
    }

    public XPathQueryService getXPathQueryService(Collection col) throws XMLDBException {
        return (XPathQueryService)col.getService("XPathQueryService", "1.0");
    }

    public Collection getOrCreateCollection(int pathOffset) throws XMLDBException {
        Collection collection = DatabaseManager.getCollection(authManager.getUri()+collectionUri, authManager.getUser(), authManager.getPassword());
        if (collection == null) {
            if (collectionUri.startsWith("/"))
                collectionUri = collectionUri.substring(1);

            String[] pathSegments = collectionUri.split("/");
            if (pathSegments.length > 0) {
                StringBuilder path = new StringBuilder();
                for (int i = 0; i <= pathOffset; i++)
                    path.append("/").append(pathSegments[i]);

                Collection startCol = DatabaseManager.getCollection(authManager.getUri() + path, authManager.getUser(), authManager.getPassword());
                if (startCol == null) {
                    String parentPath = path.substring(0, path.lastIndexOf("/"));
                    Collection parentCol = DatabaseManager.getCollection(authManager.getUri() + parentPath, authManager.getUser(), authManager.getPassword());
                    CollectionManagementService service = (CollectionManagementService) parentCol.getService("CollectionManagementService", "1.0");
                    collection = service.createCollection(pathSegments[pathOffset]);
                    collection.close();
                    parentCol.close();
                }
                else
                    startCol.close();
            }
            return getOrCreateCollection(++pathOffset);
        }
        else
            return collection;
    }

    public void addToCollection(String collectionId, String documentId, String xmlDoc) throws Exception  {
        createDBConnection();

        Collection collection = getOrCreateCollection(0);
        //ToDo dodat nastavak .xml zarad dobavljanja podataka
        XMLResource resource = (XMLResource) collection.createResource(documentId+".xml", XMLResource.RESOURCE_TYPE);
        resource.setContent(xmlDoc);
        collection.storeResource(resource);

        closeDBConnection(collection, resource);
    }

    public XMLResource loadResourceById(String collectionUri, String documentId) throws Exception  {
        createDBConnection();
        try (Collection collection = getOrCreateCollection(0)) {
            collection.setProperty(OutputKeys.INDENT, "yes");

            //ToDo dodat nastavak .xml zarad dobavljanja podataka (pogledaj gornji todo)
            return (XMLResource) collection.getResource(documentId+".xml");
        }
    }

    public ResourceSet loadAllResources(String collectionUri) throws Exception  {
        createDBConnection();
        try (Collection collection = getOrCreateCollection(0)) {
            collection.setProperty(OutputKeys.INDENT, "yes");
            return getXPathQueryService(collection).query("/*");
        }
    }
}
