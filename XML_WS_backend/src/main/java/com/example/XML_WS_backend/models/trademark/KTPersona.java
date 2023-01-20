
package com.example.XML_WS_backend.models.trademark;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KTPersona complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KTPersona"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Adresa" type="{ZAHTEV_ZA_PRIZNANJE_ZIGA}KTAdresa"/&gt;
 *         &lt;element name="KontaktInformacije" type="{ZAHTEV_ZA_PRIZNANJE_ZIGA}KTKontaktInformacije"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KTPersona", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", propOrder = {
    "ime",
    "adresa",
    "kontaktInformacije"
})
@Data
@NoArgsConstructor
public class KTPersona {
    @XmlElement(name = "Ime", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected String ime;
    @XmlElement(name = "Adresa", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected KTAdresa adresa;
    @XmlElement(name = "KontaktInformacije", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected KTKontaktInformacije kontaktInformacije;
}
