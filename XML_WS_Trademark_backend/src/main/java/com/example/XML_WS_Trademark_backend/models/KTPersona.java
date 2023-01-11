
package com.example.XML_WS_Trademark_backend.models;

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
 *         &lt;element name="Ime"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
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
public class KTPersona {

    @XmlElement(name = "Ime", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected String ime;
    @XmlElement(name = "Adresa", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected KTAdresa adresa;
    @XmlElement(name = "KontaktInformacije", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected KTKontaktInformacije kontaktInformacije;

    /**
     * Gets the value of the ime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIme() {
        return ime;
    }

    /**
     * Sets the value of the ime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIme(String value) {
        this.ime = value;
    }

    /**
     * Gets the value of the adresa property.
     * 
     * @return
     *     possible object is
     *     {@link KTAdresa }
     *     
     */
    public KTAdresa getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link KTAdresa }
     *     
     */
    public void setAdresa(KTAdresa value) {
        this.adresa = value;
    }

    /**
     * Gets the value of the kontaktInformacije property.
     * 
     * @return
     *     possible object is
     *     {@link KTKontaktInformacije }
     *     
     */
    public KTKontaktInformacije getKontaktInformacije() {
        return kontaktInformacije;
    }

    /**
     * Sets the value of the kontaktInformacije property.
     * 
     * @param value
     *     allowed object is
     *     {@link KTKontaktInformacije }
     *     
     */
    public void setKontaktInformacije(KTKontaktInformacije value) {
        this.kontaktInformacije = value;
    }

}
