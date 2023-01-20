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
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class PDFGenerator {
    private static DocumentBuilderFactory documentFactory;
    private static TransformerFactory transformerFactory;
    private static final String XSL_FILE_PATH = Settings.XSL_FILE_PATH;
    private static final String PDF_FILE_PATH = Settings.PDF_FILE_PATH;
    private static final String HTML_FILE_PATH = Settings.HTML_FILE_PATH;

    static {
        setupDocBuilderFactory();
        setupTransformerFactory();
    }

    public static void generatePDFandHTML(ZahtevZaPriznanjeZiga trademarkReq) throws Exception {
        generateHTML(trademarkReq);
        generatePDF();
    }

    private static void generateHTML(ZahtevZaPriznanjeZiga trademarkReq) throws Exception {
        try {
            Transformer transformer = getTransformerByXSLFile(new StreamSource(new File(XSL_FILE_PATH)));
            transformer.transform(
                    new DOMSource(makeDocFromTrademarkReq(trademarkReq)),
                    new StreamResult(Files.newOutputStream(Paths.get(HTML_FILE_PATH)))
            );
        } catch (TransformerFactoryConfigurationError | TransformerException ignored) {}
    }

    private static void generatePDF() {
        try {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(PDF_FILE_PATH)));
            document.open();
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, Files.newInputStream(Paths.get(HTML_FILE_PATH)));
            document.close();
        } catch (IOException | DocumentException ignored) {}
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
