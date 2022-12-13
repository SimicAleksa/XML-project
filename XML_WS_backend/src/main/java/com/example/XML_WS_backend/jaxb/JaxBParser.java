package com.example.XML_WS_backend.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.HashMap;

import com.example.XML_WS_backend.models.zahtev_za_autorska_prava.ZahtevZaAutorskaPrava;
import com.example.XML_WS_backend.models.zahtev_za_patent.ZahtevZaPatent;
import com.sun.xml.internal.ws.db.glassfish.BridgeWrapper;

public class JaxBParser {
    private HashMap<Class, String> schemaLocationRegistry = new HashMap<>();

    public JaxBParser() {
//        schemaLocationRegistry.put(ZahtevZaPatent.class, "../../../../data/patent/zahtev_za_patent.xsd");
    }

    public void test() {
        try {
//
            JAXBContext context = JAXBContext.newInstance("com.example.XML_WS_backend.models.zahtev_za_autorska_prava");
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ZahtevZaAutorskaPrava zahtevZaPrava = (ZahtevZaAutorskaPrava) unmarshaller.unmarshal(new File("data\\autorska_prava\\ZAHTEV_ZA_AUTORSKA_PRAVA.xml"));
            System.out.println("[INFO] Unmarshalled content:");
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(zahtevZaPrava, System.out);
            System.out.println("---------------------------------------------------------------------------");
            zahtevZaPrava.setPseudonimIliZnakAutora("Novi pseudonim autora");
            File xmlFile = new File("data\\autorska_prava\\Izmenjeno.xml");
            marshaller.marshal(zahtevZaPrava, xmlFile);
            marshaller.marshal(zahtevZaPrava, System.out);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
