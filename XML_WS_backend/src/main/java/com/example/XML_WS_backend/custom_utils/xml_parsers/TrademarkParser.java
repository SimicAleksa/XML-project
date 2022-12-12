package com.example.XML_WS_backend.custom_utils.xml_parsers;

import com.example.XML_WS_backend.models.trademark.ZahtevZaPriznanjeZiga;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;


public class TrademarkParser {
    private static final String TRADEMARK_XML_FILE_PATH = "data\\trademark\\ZAHTEV_ZA_PRIZNANJE_ZIGA.xml";
    private static final String TRADEMARK_XML_UPDATE_FILE_PATH = "data\\trademark\\ZAHTEV_ZA_PRIZNANJE_ZIGA_UPDATE.xml";

    public static ZahtevZaPriznanjeZiga read() {
        try {
            return (ZahtevZaPriznanjeZiga) JAXBContext.newInstance(ZahtevZaPriznanjeZiga.class).createUnmarshaller()
                                                                        .unmarshal(new File(TRADEMARK_XML_FILE_PATH));
        } catch (Exception ignored) {}
        return null;
    }

    public static void printChanges(ZahtevZaPriznanjeZiga trademarkReq) {
        trademarkReq.getPunomocnik().setIme("NEKO IME");
        trademarkReq.getPunomocnik().getAdresa().setDrzavaPrebivalista("Srbija");
        try {
            JAXBContext ctx = JAXBContext.newInstance(ZahtevZaPriznanjeZiga.class);
            Marshaller marshaller = ctx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(trademarkReq, new File(TRADEMARK_XML_UPDATE_FILE_PATH));
        } catch (JAXBException ignored) {}
    }
}
