
package com.example.XML_WS_backend.models.zahtev_za_patent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TDodatniPodaci complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TDodatniPodaci"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="broj_telefona" form="qualified"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;pattern value="[0-9]{9,12}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="broj_faksa" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="e_posta"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;pattern value="[A-Za-z0-9+_.-]+@[a-z]+\.[a-z]{2,4}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TDodatniPodaci", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", propOrder = {

})
public class TDodatniPodaci {

    @XmlElement(name = "broj_telefona", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
    protected String brojTelefona;
    @XmlElement(name = "broj_faksa", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
    protected String brojFaksa;
    @XmlElement(name = "e_posta", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
    protected String ePosta;

    /**
     * Gets the value of the brojTelefona property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojTelefona() {
        return brojTelefona;
    }

    /**
     * Sets the value of the brojTelefona property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojTelefona(String value) {
        this.brojTelefona = value;
    }

    /**
     * Gets the value of the brojFaksa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojFaksa() {
        return brojFaksa;
    }

    /**
     * Sets the value of the brojFaksa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojFaksa(String value) {
        this.brojFaksa = value;
    }

    /**
     * Gets the value of the ePosta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEPosta() {
        return ePosta;
    }

    /**
     * Sets the value of the ePosta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEPosta(String value) {
        this.ePosta = value;
    }


    @Override
    public String toString() {
        return
                "\t\t\t\t<brojTelefona>" + brojTelefona + "</brojTelefona>\n" +
                "\t\t\t\t<brojFaksa>" + brojFaksa + "</brojFaksa>\n" +
                "\t\t\t\t<ePosta>" + ePosta + "</ePosta>\n";
    }
}
