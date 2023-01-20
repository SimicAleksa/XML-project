
package com.example.XML_WS_backend.models.trademark;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KTAdresa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KTAdresa"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Ulica" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="BrojUlice" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="PostanskiBroj" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="MestoPrebivalista" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="DrzavaPrebivalista" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KTAdresa", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", propOrder = {
    "ulica",
    "brojUlice",
    "postanskiBroj",
    "mestoPrebivalista",
    "drzavaPrebivalista"
})
@Data
@NoArgsConstructor
public class KTAdresa {
    @XmlElement(name = "Ulica", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected String ulica;
    @XmlElement(name = "BrojUlice", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA")
    protected int brojUlice;
    @XmlElement(name = "PostanskiBroj", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA")
    protected int postanskiBroj;
    @XmlElement(name = "MestoPrebivalista", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected String mestoPrebivalista;
    @XmlElement(name = "DrzavaPrebivalista", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected String drzavaPrebivalista;
}
