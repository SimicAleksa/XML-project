package com.example.XML_WS_auth_backend.repositories;

import com.example.XML_WS_auth_backend.database.ExistDatabase;
import com.example.XML_WS_auth_backend.models.User;
import com.example.XML_WS_auth_backend.utils.JAXBParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.modules.XMLResource;

@Repository
public class UserRepository {
    public static final String collectionUri = "/db/users";

    private final JAXBParser<User> jaxbParser;
    @Autowired
    private ExistDatabase existDB;


    public UserRepository() {
        this.jaxbParser = new JAXBParser<>(User.class);
    }

    public User getByEmail(String email) {
        try {
            XMLResource user = this.existDB.loadResourceById(collectionUri, email);
            if (user != null)
                return jaxbParser.parseFromXMLToObj(user.getContent().toString());
        } catch (Exception ignored) {}
        return null;
    }

    public void save(User user) {
        try {
            existDB.addToCollection(collectionUri, user.getEmail(), jaxbParser.parseFromObjToByteStream(user));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
