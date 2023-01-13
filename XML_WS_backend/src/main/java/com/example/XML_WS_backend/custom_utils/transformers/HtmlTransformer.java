package com.example.XML_WS_backend.custom_utils.transformers;

import com.itextpdf.text.DocumentException;
import org.apache.xmlrpc.jaxb.JaxbParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class HtmlTransformer {
    @Autowired
    JaxbParser jaxbParser;
    private static DocumentBuilderFactory documentFactory;

    private static TransformerFactory transformerFactory;

    public static final String HTML_FILE = "data/transform_result/html/patent.html";

    public static final String INPUT_FILE = "data/patent/ZAHTEV_ZA_PRIZNANJE_PATENTA.xml";

    public static final String XSL_FILE = "data/xslt/patent.xsl";

    static {
        documentFactory = DocumentBuilderFactory.newInstance();
        documentFactory.setNamespaceAware(true);
        documentFactory.setIgnoringComments(true);
        documentFactory.setIgnoringElementContentWhitespace(true);

        transformerFactory = TransformerFactory.newInstance();
    }
    public Document buildDocument(String filePath) {

        Document document = null;
        try {

            DocumentBuilder builder = documentFactory.newDocumentBuilder();
            document = builder.parse(new File(filePath));

            if (document != null)
                System.out.println("[INFO] File parsed with no errors.");
            else
                System.out.println("[WARN] Document is null.");

        } catch (Exception e) {
            return null;
        }
        return document;
    }
    public void generateHTML(String xmlPath, String xslPath) throws FileNotFoundException {

        try {
            File xmlFile = new File(xmlPath);

            String outputPath = "data/transform_result/html/"+xmlFile.getName().split("\\.")[0]+".html";

            System.out.println(outputPath);

            File outputHtmlFile = new File(outputPath);
            System.out.println("Created html file:"+outputHtmlFile.createNewFile());

            // Initialize Transformer instance
            StreamSource transformSource = new StreamSource(new File(xslPath));
            Transformer transformer = transformerFactory.newTransformer(transformSource);
            transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // Generate XHTML
            transformer.setOutputProperty(OutputKeys.METHOD, "xhtml");

            // Transform DOM to HTML
            DOMSource source = new DOMSource(buildDocument(xmlPath));
            StreamResult result = new StreamResult(new FileOutputStream(outputPath));
            transformer.transform(source, result);



        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException, DocumentException {
        HtmlTransformer htmlTransformer = new HtmlTransformer();

        htmlTransformer.generateHTML(INPUT_FILE, XSL_FILE);
    }
}
