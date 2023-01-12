package com.example.XML_WS_backend.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringWriter;
import java.util.HashMap;

import com.example.XML_WS_backend.custom_utils.authenticationUtilities.AuthenticationUtilities;
import com.example.XML_WS_backend.custom_utils.reader_writer.JaxbReader;
import com.example.XML_WS_backend.custom_utils.reader_writer.JaxbWriter;
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

            // TODO ovdje pozvati ono
            JaxbWriter.upis("patent", "1", zahtevZaPatent );
            System.out.println("Citaj mali");
            JaxbReader.ispis("patent", "1.xml");

            // Ispis sadržaja objekta
//            System.out.println("[INFO] Unmarshalled content:");
//            System.out.println(zahtevZaPatent);

            // Izmena podataka
            zahtevZaPatent.getPodnosilacPrijave().getLicniPodaci().getFizickoPravnoLice().getFizickoLice().setIme("DODATO IME PODNOSILAC");
            zahtevZaPatent.getPodnosilacPrijave().getLicniPodaci().getFizickoPravnoLice().getFizickoLice().setPrezime("DODATO PREZIME PODNOSILAC");

            zahtevZaPatent.getPronalazac().getPodaciOPronalazacu().getFizickoLice().setIme("DODATO IME PRONALAZAC");
            zahtevZaPatent.getPronalazac().getPodaciOPronalazacu().getFizickoLice().setPrezime("DODATO PREZIME PRONALAZAC");

            // Marshaller je objekat zadužen za konverziju iz objektnog u XML model
            Marshaller marshaller = context.createMarshaller();

            // Podešavanje marshaller-a
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Ispis izmenjenog sadrzaja
//            System.out.println("\n\n\n[INFO] Updated content:");
//            // Umesto System.out-a, može se koristiti FileOutputStream
//            marshaller.marshal(zahtevZaPatent, System.out);

            File xmlFile = new File("data\\patent\\ZAHTEV_ZA_PRIZNANJE_PATENTA_UPDATE.xml");
            marshaller.marshal(zahtevZaPatent, xmlFile);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
