package com.example.XML_WS_backend.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.HashMap;

import com.example.XML_WS_backend.custom_utils.reader_writer.JaxbReader;
import com.example.XML_WS_backend.custom_utils.reader_writer.JaxbWriter;
import com.example.XML_WS_backend.models.autorskaprava.ZahtevZaAutorskaPrava;




public class JaxBParser {
    private HashMap<Class, String> schemaLocationRegistry = new HashMap<>();

    public JaxBParser() {
//        schemaLocationRegistry.put(ZahtevZaPatent.class, "../../../../data/patent/zahtev_za_patent.xsd");
    }

    public void test() {
        try {
//
            JAXBContext context = JAXBContext.newInstance("com.example.XML_WS_backend.models.autorskaprava");
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ZahtevZaAutorskaPrava zahtevZaPrava = (ZahtevZaAutorskaPrava) unmarshaller.unmarshal(new File("data\\autorska_prava\\ZAHTEV_ZA_AUTORSKA_PRAVA.xml"));

            JaxbWriter.upis("prava", "1", zahtevZaPrava );
            System.out.println("Citaj mali");
            JaxbReader.ispis("prava", "1.xml");

            System.out.println("[INFO] Unmarshalled content:");
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//            marshaller.marshal(zahtevZaPrava, System.out);
            System.out.println("---------------------------------------------------------------------------");
            zahtevZaPrava.setPseudonimIliZnakAutora("Novi pseudonim autora");
            File xmlFile = new File("data\\autorska_prava\\Izmenjeno.xml");
            marshaller.marshal(zahtevZaPrava, xmlFile);
//            marshaller.marshal(zahtevZaPrava, System.out);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
