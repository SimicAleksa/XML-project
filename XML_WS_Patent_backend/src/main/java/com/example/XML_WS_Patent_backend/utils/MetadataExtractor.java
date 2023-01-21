package com.example.XML_WS_Patent_backend.utils;

import com.example.XML_WS_Patent_backend.configs.Settings;
import org.apache.xalan.xsltc.trax.TransformerFactoryImpl;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.OutputStream;
import java.io.StringReader;


public class MetadataExtractor {
    private static final String XSLT_FILE = Settings.GRDDL_FILE;


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
        return inpXML.replaceFirst(Settings.REQ_NAME,String.format("%s %s", Settings.REQ_NAME, Settings.PREDICATE_NAMESPACE));
    }

}
