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

    public static ZahtevZaPriznanjeZiga parseFromXMLToObj(String xmlContent) throws JAXBException {
        return (ZahtevZaPriznanjeZiga) getUnmarshaller().unmarshal(new StringReader(xmlContent));
    }

    public static OutputStream parseFromObjToByteStream(ZahtevZaPriznanjeZiga trademarkReq) throws JAXBException {
        OutputStream outputStream = new ByteArrayOutputStream();
        getMarshaller().marshal(trademarkReq, outputStream);
        return outputStream;
    }
}
