package com.example.XML_WS_Trademark_backend.utils;

import com.example.XML_WS_Trademark_backend.models.ZahtevZaPriznanjeZiga;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.StringReader;


public class TrademarkParserJAXB {
    public static ZahtevZaPriznanjeZiga parseFromXMLToObj(String xmlContent) throws JAXBException {
        return (ZahtevZaPriznanjeZiga) getUnmarshaller().unmarshal(new StringReader(xmlContent));
    }

    public static String parseFromObjToByteStream(ZahtevZaPriznanjeZiga trademarkReq) throws JAXBException {
        OutputStream outputStream = new ByteArrayOutputStream();
        getMarshaller().marshal(trademarkReq, outputStream);
        return outputStream.toString();
    }

    private static JAXBContext getJAXBInstance() throws JAXBException {
        return JAXBContext.newInstance(ZahtevZaPriznanjeZiga.class);
    }

    private static Unmarshaller getUnmarshaller() throws JAXBException {
        return getJAXBInstance().createUnmarshaller();
    }

    private static Marshaller getMarshaller() throws JAXBException {
        Marshaller marshaller = getJAXBInstance().createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        return marshaller;
    }

}
