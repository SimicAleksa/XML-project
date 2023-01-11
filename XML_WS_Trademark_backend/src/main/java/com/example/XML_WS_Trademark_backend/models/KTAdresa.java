
package com.example.XML_WS_Trademark_backend.models;

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
 *         &lt;element name="Ulica"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="BrojUlice"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PostanskiBroj"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="MestoPrebivalista"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="DrzavaPrebivalista"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
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

    /**
     * Gets the value of the ulica property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUlica() {
        return ulica;
    }

    /**
     * Sets the value of the ulica property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUlica(String value) {
        this.ulica = value;
    }

    /**
     * Gets the value of the brojUlice property.
     * 
     */
    public int getBrojUlice() {
        return brojUlice;
    }

    /**
     * Sets the value of the brojUlice property.
     * 
     */
    public void setBrojUlice(int value) {
        this.brojUlice = value;
    }

    /**
     * Gets the value of the postanskiBroj property.
     * 
     */
    public int getPostanskiBroj() {
        return postanskiBroj;
    }

    /**
     * Sets the value of the postanskiBroj property.
     * 
     */
    public void setPostanskiBroj(int value) {
        this.postanskiBroj = value;
    }

    /**
     * Gets the value of the mestoPrebivalista property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMestoPrebivalista() {
        return mestoPrebivalista;
    }

    /**
     * Sets the value of the mestoPrebivalista property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMestoPrebivalista(String value) {
        this.mestoPrebivalista = value;
    }

    /**
     * Gets the value of the drzavaPrebivalista property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrzavaPrebivalista() {
        return drzavaPrebivalista;
    }

    /**
     * Sets the value of the drzavaPrebivalista property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrzavaPrebivalista(String value) {
        this.drzavaPrebivalista = value;
    }

}
