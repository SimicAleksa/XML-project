package com.example.XML_WS_Trademark_backend.utils;

import com.example.XML_WS_Trademark_backend.models.ZahtevZaPriznanjeZiga;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
public class TrademarkParserJAXB {
    private static final String TRADEMARK_XML_FILE_PATH = "src\\main\\resources\\xmls\\ZAHTEV_ZA_PRIZNANJE_ZIGA.xml";
    private static final String TRADEMARK_XML_UPDATE_FILE_PATH = "src\\main\\resources\\xmls\\ZAHTEV_ZA_PRIZNANJE_ZIGA_UPDATE.xml";

    public static JAXBContext getJAXBInstance() throws JAXBException {
        return JAXBContext.newInstance(ZahtevZaPriznanjeZiga.class);
    }

    public static Unmarshaller getUnmarshaller() throws JAXBException {
        return getJAXBInstance().createUnmarshaller();
    }

    public static Marshaller getMarshaller() throws JAXBException {
        Marshaller marshaller = getJAXBInstance().createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        return marshaller;
    }

    public static ZahtevZaPriznanjeZiga parseFromXMLToObj() throws JAXBException {
        return (ZahtevZaPriznanjeZiga) getUnmarshaller().unmarshal(new File(TRADEMARK_XML_FILE_PATH));
    }

    public static OutputStream parseFromObjToByteStream(ZahtevZaPriznanjeZiga trademarkReq) throws JAXBException {
        OutputStream outputStream = new ByteArrayOutputStream();
        getMarshaller().marshal(trademarkReq, outputStream);
        return outputStream;
    }
}
