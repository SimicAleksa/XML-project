package com.example.XML_WS_AuthorRights_backend.services;


import com.example.XML_WS_AuthorRights_backend.models.ResenjeZahteva;
import com.example.XML_WS_AuthorRights_backend.models.ZahtevZaAutorskoPravo;
import com.example.XML_WS_AuthorRights_backend.repository.AuthorRightsRepository;
import com.example.XML_WS_AuthorRights_backend.repository.ResenjaRepository;
import com.itextpdf.text.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.util.Objects;

//////////////////////////////////////////////////////////////////////////////
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import com.itextpdf.text.pdf.PdfWriter;

@Service
public class ResenjaService {
    @Autowired
    private ResenjaRepository resenjaRepository;

    @Autowired
    private AuthorRightsRepository authorRightsRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment env;

    public void saveNewResenje(ResenjeZahteva resenjeZahteva) {
        resenjaRepository.save(resenjeZahteva);
    }

    public void sendEmailGornji(ResenjeZahteva resenjeZahteva) {
        String email = getSubmitterEmail(resenjeZahteva);
        sendEmail(email, "naslov", "U prilogu vam saljemo...", resenjeZahteva);
    }

    public void sendEmail(String sendToEmail, String mailSubj, String mailText, ResenjeZahteva resenjeZahteva) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setFrom(Objects.requireNonNull(env.getProperty("spring.mail.username")));
            helper.setTo(sendToEmail);
            helper.setSubject(mailSubj);
            helper.setText(mailText);

            MimeBodyPart pdfBodyPart = createPdfBodyPart(resenjeZahteva);
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(pdfBodyPart);

            mimeMessage.setContent(mimeMultipart);

            javaMailSender.send(mimeMessage);

            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private MimeBodyPart createPdfBodyPart(ResenjeZahteva resenjeZahteva) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            writePdf(outputStream, resenjeZahteva);
            byte[] bytes = outputStream.toByteArray();

            DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
            MimeBodyPart pdfBodyPart = new MimeBodyPart();
            pdfBodyPart.setDataHandler(new DataHandler(dataSource));
            pdfBodyPart.setFileName("Resenje.pdf");

            return pdfBodyPart;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void writePdf(OutputStream outputStream, ResenjeZahteva resenjeZahteva) throws Exception {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, outputStream);

        document.open();

        // Broj prijave (Header)
        if (resenjeZahteva.getJePrihvacen())
        {
            Paragraph header = new Paragraph("Broj prijave: " + resenjeZahteva.getBrojPrijave() +
                    "\nDatum: " + resenjeZahteva.getDatumPodnosenjaResenja().substring(0,10));
            header.setAlignment(Element.ALIGN_RIGHT);
            document.add(header);
        }
        else
        {
            Paragraph header = new Paragraph("\nDatum: " + resenjeZahteva.getDatumPodnosenjaResenja().substring(0,10));
            header.setAlignment(Element.ALIGN_RIGHT);
            document.add(header);
        }


        Paragraph mainBody = new Paragraph();
        if (resenjeZahteva.getJePrihvacen()) {
            mainBody.add(new Phrase("\nVas zahtev je odobren."));
        } else {
            mainBody.add(new Phrase("\nVas zahtev je odbijen."));
            mainBody.add(new Phrase("\nObrazlozenje: " + resenjeZahteva.getObrazlozenje()));

        }
        document.add(mainBody);

        // Sluzbenik (Footer)
        Paragraph footer = new Paragraph("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nSluzbenik: \n" + resenjeZahteva.getSluzbenikImeIPrezime());
        footer.setAlignment(Element.ALIGN_RIGHT);
        document.add(footer);

      /*  // Additional content
        document.addTitle("Test PDF");
        document.addSubject("Testing email PDF");
        document.addKeywords("iText, email");
        document.addAuthor("Jee Vang");
        document.addCreator("Jee Vang");
*/


        document.close();
    }

    private String getSubmitterEmail(ResenjeZahteva resenjeZahteva) {
        String brojPrijave = resenjeZahteva.getBrojPrijave();
        ZahtevZaAutorskoPravo z = authorRightsRepository.getCRRequestById(brojPrijave);
        return z.getEmailNalogaPodnosioca();
    }
}
