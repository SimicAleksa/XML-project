package com.example.XML_WS_backend.custom_utils.xml_parsers;

import com.example.XML_WS_backend.models.trademark.ZahtevZaPriznanjeZiga;

import javax.xml.bind.JAXBContext;
import java.io.File;


public class TrademarkParser {
    private static final String TRADEMARK_MODELS_PATH = "com.example.XML_WS_backend.models.trademark";
    private static final String TRADEMARK_XML_FILE_PATH = "data\\trademark\\ZAHTEV_ZA_PRIZNANJE_ZIGA.xml";

    public static ZahtevZaPriznanjeZiga read() {
        try {
            return (ZahtevZaPriznanjeZiga) JAXBContext.newInstance(TRADEMARK_MODELS_PATH).createUnmarshaller()
                                                                        .unmarshal(new File(TRADEMARK_XML_FILE_PATH));
        } catch (Exception ignored) {}
        return null;
    }

    public static void print(ZahtevZaPriznanjeZiga trademarkReq) {
        System.out.println(trademarkReq);
    }
}
