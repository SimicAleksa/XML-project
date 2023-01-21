package com.example.XML_WS_AuthorRights_backend.configs;

public class Settings {
    public static final String REQ_NAME = "zahtev_za_autorsko_pravo";
    public static final String DATA_FILES_PATH = "src/main/resources/data_files";
    public static final String RDF_FILE_PATH = String.format("%s/%s.rdf", DATA_FILES_PATH, REQ_NAME);
    public static final String GRDDL_FILE = String.format("%s/grddl.xsl", DATA_FILES_PATH);
    public static final String XSL_FILE_PATH = String.format("%s/%s.xsl", DATA_FILES_PATH, REQ_NAME);
    public static final String PDF_FILE_PATH = String.format("%s/%s.pdf", DATA_FILES_PATH, REQ_NAME);
    public static final String HTML_FILE_PATH = String.format("%s/%s.html", DATA_FILES_PATH, REQ_NAME);
    public static final String PREDICATE_NAMESPACE = "xmlns:pred=\"http://www.ftn.uns.ac.rs/AutorskaPrava/pred/\"";
}
