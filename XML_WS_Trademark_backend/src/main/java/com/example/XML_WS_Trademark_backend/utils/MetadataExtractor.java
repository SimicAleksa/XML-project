package com.example.XML_WS_Trademark_backend.utils;

import org.apache.xalan.xsltc.trax.TransformerFactoryImpl;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;


public class MetadataExtractor {
    private static final String XSLT_FILE = "src/main/resources/formats_data/grddl.xsl";

    public static void extractMetadata(String in, OutputStream out) throws TransformerException {
        getGrddlTransformer(new StreamSource(new File(XSLT_FILE)))
                .transform(
                        new StreamSource(new StringReader(adjustInpXML(in))),
                        new StreamResult(out)
                );
    }

    private static Transformer getGrddlTransformer(StreamSource transformSource) throws TransformerConfigurationException {
        Transformer grddlTransformer = new TransformerFactoryImpl().newTransformer(transformSource);
        grddlTransformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
        grddlTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
        return grddlTransformer;
    }

    private static String adjustInpXML(String inpXML) {
        return inpXML.replaceFirst("ZahtevZaPriznanjeZiga","ZahtevZaPriznanjeZiga xmlns:pred=\"http://www.ftn.uns.ac.rs/zahtev_za_zig/pred/\" ");
    }

}
