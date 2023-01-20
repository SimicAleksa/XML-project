package com.example.XML_WS_Trademark_backend.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.StringReader;


@SuppressWarnings("unchecked")
public class JAXBParser<ReqType> {
    private final Class<ReqType> reqType;

    public JAXBParser(Class<ReqType> reqType) {
        this.reqType = reqType;
    }

    public ReqType parseFromXMLToObj(String xmlContent) throws JAXBException {
        return (ReqType) getUnmarshaller().unmarshal(new StringReader(xmlContent));
    }

    public String parseFromObjToByteStream(ReqType trademarkReq) throws JAXBException {
        OutputStream outputStream = new ByteArrayOutputStream();
        getMarshaller().marshal(trademarkReq, outputStream);
        return outputStream.toString();
    }

    private JAXBContext getJAXBInstance() throws JAXBException {
        return JAXBContext.newInstance(reqType);
    }

    private Unmarshaller getUnmarshaller() throws JAXBException {
        return getJAXBInstance().createUnmarshaller();
    }

    private Marshaller getMarshaller() throws JAXBException {
        Marshaller marshaller = getJAXBInstance().createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        return marshaller;
    }

}
