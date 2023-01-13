package com.example.XML_WS_backend.custom_utils.transformers;

import com.itextpdf.html2pdf.HtmlConverter;

import java.io.File;
import java.io.IOException;

public class PDFTransformer {

    public static final String INPUT_FILE = "data/transform_result/html/ZAHTEV_ZA_AUTORSKA_PRAVA.html";

    public void generatePDFfromHTML(String htmlLocation) throws IOException{
        File htmlFile = new File(htmlLocation);
        String htmlFileName = htmlFile.getName().split("\\.")[0];

        String outputLocation = "data/transform_result/pdf/"+htmlFileName+".pdf";

        File pdfFile = new File(outputLocation);


        System.out.println("Created pdf file:"+pdfFile.createNewFile());

        HtmlConverter.convertToPdf(htmlFile,pdfFile);

    }


    public static void main(String[] args) throws IOException{
        PDFTransformer pdfTransformer = new PDFTransformer();

        pdfTransformer.generatePDFfromHTML(INPUT_FILE);
    }
}
