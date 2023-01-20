package com.example.XML_WS_backend.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.HashMap;

import com.example.XML_WS_backend.models.zahtev_za_autorska_prava.ZahtevZaAutorskaPrava;
import com.example.XML_WS_backend.models.zahtev_za_patent.ZahtevZaPatent;

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

            context = JAXBContext.newInstance("com.example.XML_WS_backend.models.zahtev_za_patent");
            unmarshaller = context.createUnmarshaller();
            marshaller = context.createMarshaller();
            ZahtevZaPatent zahtevZaPatent = (ZahtevZaPatent) unmarshaller.unmarshal(new File("data\\patent\\ZAHTEV_ZA_PRIZNANJE_PATENTA.xml"));
            zahtevZaPatent.getPodnosilacPrijave().getLicniPodaci().getFizickoPravnoLice().getFizickoLice().setIme("DODATO IME PODNOSILAC");
            zahtevZaPatent.getPodnosilacPrijave().getLicniPodaci().getFizickoPravnoLice().getFizickoLice().setPrezime("DODATO PREZIME PODNOSILAC");
            zahtevZaPatent.getPronalazac().getPodaciOPronalazacu().getFizickoLice().setIme("DODATO IME PRONALAZAC");
            zahtevZaPatent.getPronalazac().getPodaciOPronalazacu().getFizickoLice().setPrezime("DODATO PREZIME PRONALAZAC");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(zahtevZaPatent, System.out);
            xmlFile = new File("data\\patent\\ZAHTEV_ZA_PRIZNANJE_PATENTA_UPDATE.xml");
            marshaller.marshal(zahtevZaPatent, xmlFile);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
