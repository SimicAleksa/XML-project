
package com.example.XML_WS_backend.models.trademark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KTZig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KTZig"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TipZiga" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="TipZnaka" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="IzgledZnaka" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *         &lt;element name="Boje"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Boja" type="{ZAHTEV_ZA_PRIZNANJE_ZIGA}PTBoja" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TransliteracijaZnaka" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PrevodZnaka" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="OpisZnaka" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KTZig", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", propOrder = {
    "tipZiga",
    "tipZnaka",
    "izgledZnaka",
    "boje",
    "transliteracijaZnaka",
    "prevodZnaka",
    "opisZnaka"
})
public class KTZig {

    @XmlElement(name = "TipZiga", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected String tipZiga;
    @XmlElement(name = "TipZnaka", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected String tipZnaka;
    @XmlElement(name = "IzgledZnaka", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected byte[] izgledZnaka;
    @XmlElement(name = "Boje", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected KTZig.Boje boje;
    @XmlElement(name = "TransliteracijaZnaka", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected String transliteracijaZnaka;
    @XmlElement(name = "PrevodZnaka", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected String prevodZnaka;
    @XmlElement(name = "OpisZnaka", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected String opisZnaka;

    /**
     * Gets the value of the tipZiga property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipZiga() {
        return tipZiga;
    }

    /**
     * Sets the value of the tipZiga property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipZiga(String value) {
        this.tipZiga = value;
    }

    /**
     * Gets the value of the tipZnaka property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipZnaka() {
        return tipZnaka;
    }

    /**
     * Sets the value of the tipZnaka property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipZnaka(String value) {
        this.tipZnaka = value;
    }

    /**
     * Gets the value of the izgledZnaka property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getIzgledZnaka() {
        return izgledZnaka;
    }

    /**
     * Sets the value of the izgledZnaka property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setIzgledZnaka(byte[] value) {
        this.izgledZnaka = value;
    }

    /**
     * Gets the value of the boje property.
     * 
     * @return
     *     possible object is
     *     {@link KTZig.Boje }
     *     
     */
    public KTZig.Boje getBoje() {
        return boje;
    }

    /**
     * Sets the value of the boje property.
     * 
     * @param value
     *     allowed object is
     *     {@link KTZig.Boje }
     *     
     */
    public void setBoje(KTZig.Boje value) {
        this.boje = value;
    }

    /**
     * Gets the value of the transliteracijaZnaka property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransliteracijaZnaka() {
        return transliteracijaZnaka;
    }

    /**
     * Sets the value of the transliteracijaZnaka property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransliteracijaZnaka(String value) {
        this.transliteracijaZnaka = value;
    }

    /**
     * Gets the value of the prevodZnaka property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrevodZnaka() {
        return prevodZnaka;
    }

    /**
     * Sets the value of the prevodZnaka property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrevodZnaka(String value) {
        this.prevodZnaka = value;
    }

    /**
     * Gets the value of the opisZnaka property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpisZnaka() {
        return opisZnaka;
    }

    /**
     * Sets the value of the opisZnaka property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpisZnaka(String value) {
        this.opisZnaka = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Boja" type="{ZAHTEV_ZA_PRIZNANJE_ZIGA}PTBoja" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "boja"
    })
    public static class Boje {

        @XmlElement(name = "Boja", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
        protected List<String> boja;

        /**
         * Gets the value of the boja property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the boja property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBoja().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getBoja() {
            if (boja == null) {
                boja = new ArrayList<String>();
            }
            return this.boja;
        }

        @Override
        public String toString() {
            return "Boje{" +
                    "boja=" + boja +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "KTZig{" +
                "tipZiga='" + tipZiga + '\'' +
                ", tipZnaka='" + tipZnaka + '\'' +
                ", izgledZnaka=" + Arrays.toString(izgledZnaka) +
                ", boje=" + boje +
                ", transliteracijaZnaka='" + transliteracijaZnaka + '\'' +
                ", prevodZnaka='" + prevodZnaka + '\'' +
                ", opisZnaka='" + opisZnaka + '\'' +
                '}';
    }
}
