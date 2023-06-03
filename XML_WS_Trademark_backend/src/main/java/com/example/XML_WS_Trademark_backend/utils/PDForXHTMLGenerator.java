package com.example.XML_WS_Trademark_backend.utils;


import com.example.XML_WS_Trademark_backend.configs.Settings;
import com.example.XML_WS_Trademark_backend.models.ZahtevZaPriznanjeZiga;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;


public class PDForXHTMLGenerator {
    private static DocumentBuilderFactory documentFactory;
    private static TransformerFactory transformerFactory;
    private static final String XSL_FILE_PATH = Settings.XSL_FILE_PATH;

    static {
        setupDocBuilderFactory();
        setupTransformerFactory();
    }

    public static byte[] getPDF(ZahtevZaPriznanjeZiga trademarkReq) {
        return generatePDF(generateXHTML(trademarkReq));
    }

    public static byte[] getXHTML(ZahtevZaPriznanjeZiga trademarkReq) {
        return generateXHTML(trademarkReq);
    }

    private static byte[] generateXHTML(ZahtevZaPriznanjeZiga trademarkReq) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Transformer transformer = getTransformerByXSLFile(new StreamSource(new File(XSL_FILE_PATH)));
            transformer.transform(
                    new DOMSource(makeDocFromTrademarkReq(trademarkReq)),
                    new StreamResult(outputStream)
            );

            return outputStream.toByteArray();
        } catch (TransformerFactoryConfigurationError | TransformerException ignored) {}
        return new byte[0];
    }

    private static byte[] generatePDF(byte[] htmlBytes) {
        try {
            Document document = new Document();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
            document.open();
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(htmlBytes));
            document.close();

            return outputStream.toByteArray();
        } catch (IOException | DocumentException ignored) {}
        return new byte[0];
    }

    private static org.w3c.dom.Document makeDocFromTrademarkReq(ZahtevZaPriznanjeZiga trademarkReq) {
        org.w3c.dom.Document document = null;
        try {
            DocumentBuilder builder = documentFactory.newDocumentBuilder();
            document = builder.parse(
                    new InputSource(
                            new ByteArrayInputStream(
                                    new JAXBParser<>(ZahtevZaPriznanjeZiga.class).parseFromObjToByteStream(trademarkReq).getBytes()
                            )
                    )
            );
        } catch (Exception ignored) {}
        return document;
    }

    private static Transformer getTransformerByXSLFile(StreamSource src) throws TransformerConfigurationException {
        Transformer transformer = transformerFactory.newTransformer(src);
        transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xhtml");
        return transformer;
    }

    private static void setupDocBuilderFactory() {
        documentFactory = DocumentBuilderFactory.newInstance();
        documentFactory.setNamespaceAware(true);
        documentFactory.setIgnoringComments(true);
        documentFactory.setIgnoringElementContentWhitespace(true);
    }

    private static void setupTransformerFactory() {
        transformerFactory = TransformerFactory.newInstance();
    }

}
