package com.example.XML_WS_backend.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.HashMap;

import com.example.XML_WS_backend.models.zahtev_za_patent.ZahtevZaPatent;

public class JaxBParser {
    private HashMap<Class, String> schemaLocationRegistry = new HashMap<>();

    public JaxBParser() {
//        schemaLocationRegistry.put(ZahtevZaPatent.class, "../../../../data/patent/zahtev_za_patent.xsd");
    }

    public void test() {
        try {
//            System.out.println("Working Directory = " + System.getProperty("user.dir"));
            System.out.println("[INFO] Testiranje: JAXB XML Schema validation.\n");

            // Definiše se JAXB kontekst (putanja do paketa sa JAXB bean-ovima)
            JAXBContext context = JAXBContext.newInstance("com.example.XML_WS_backend.models.zahtev_za_patent");

            // Unmarshaller - zadužen za konverziju iz XML-a u objektni model
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Učitavanje XML-a u objektni model
            ZahtevZaPatent zahtevZaPatent = (ZahtevZaPatent) unmarshaller.unmarshal(new File("data\\patent\\ZAHTEV_ZA_PRIZNANJE_PATENTA.xml"));

            // Ispis sadržaja objekta
            System.out.println("[INFO] Unmarshalled content:");
            System.out.println(zahtevZaPatent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main( String[] args ) {
//        JaxBParser test = new JaxBParser();
//        test.test();
//    }
}
