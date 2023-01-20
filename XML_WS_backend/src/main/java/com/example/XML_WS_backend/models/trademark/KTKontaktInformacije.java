
package com.example.XML_WS_backend.models.trademark;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KTKontaktInformacije complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KTKontaktInformacije"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Telefon" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="E-mail" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Faks" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KTKontaktInformacije", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", propOrder = {
    "telefon",
    "eMail",
    "faks"
})
@Data
@NoArgsConstructor
public class KTKontaktInformacije {
    @XmlElement(name = "Telefon", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected String telefon;
    @XmlElement(name = "E-mail", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected String eMail;
    @XmlElement(name = "Faks", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected String faks;
}
