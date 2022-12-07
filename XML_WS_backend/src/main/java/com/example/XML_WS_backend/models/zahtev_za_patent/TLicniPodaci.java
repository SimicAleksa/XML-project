
package com.example.XML_WS_backend.models.zahtev_za_patent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TLicni_Podaci complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TLicni_Podaci"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="fizicko_pravno_lice"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice&gt;
 *                   &lt;element name="fizicko_lice" type="{http://www.ftn.uns.ac.rs/zahtev_za_patent}TFizicko_Lice"/&gt;
 *                   &lt;element name="pravno_lice" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;all&gt;
 *                             &lt;element name="poslovno_ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                           &lt;/all&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/choice&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="drzavljanstvo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="adresa" type="{http://www.ftn.uns.ac.rs/zahtev_za_patent}TAdresa"/&gt;
 *         &lt;element name="dodatni_podaci" type="{http://www.ftn.uns.ac.rs/zahtev_za_patent}TDodatniPodaci"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TLicni_Podaci", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", propOrder = {

})
public class TLicniPodaci {

    @XmlElement(name = "fizicko_pravno_lice", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
    protected TLicniPodaci.FizickoPravnoLice fizickoPravnoLice;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
    protected String drzavljanstvo;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
    protected TAdresa adresa;
    @XmlElement(name = "dodatni_podaci", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
    protected TDodatniPodaci dodatniPodaci;

    /**
     * Gets the value of the fizickoPravnoLice property.
     * 
     * @return
     *     possible object is
     *     {@link TLicniPodaci.FizickoPravnoLice }
     *     
     */
    public TLicniPodaci.FizickoPravnoLice getFizickoPravnoLice() {
        return fizickoPravnoLice;
    }

    /**
     * Sets the value of the fizickoPravnoLice property.
     * 
     * @param value
     *     allowed object is
     *     {@link TLicniPodaci.FizickoPravnoLice }
     *     
     */
    public void setFizickoPravnoLice(TLicniPodaci.FizickoPravnoLice value) {
        this.fizickoPravnoLice = value;
    }

    /**
     * Gets the value of the drzavljanstvo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrzavljanstvo() {
        return drzavljanstvo;
    }

    /**
     * Sets the value of the drzavljanstvo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrzavljanstvo(String value) {
        this.drzavljanstvo = value;
    }

    /**
     * Gets the value of the adresa property.
     * 
     * @return
     *     possible object is
     *     {@link TAdresa }
     *     
     */
    public TAdresa getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link TAdresa }
     *     
     */
    public void setAdresa(TAdresa value) {
        this.adresa = value;
    }

    /**
     * Gets the value of the dodatniPodaci property.
     * 
     * @return
     *     possible object is
     *     {@link TDodatniPodaci }
     *     
     */
    public TDodatniPodaci getDodatniPodaci() {
        return dodatniPodaci;
    }

    /**
     * Sets the value of the dodatniPodaci property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDodatniPodaci }
     *     
     */
    public void setDodatniPodaci(TDodatniPodaci value) {
        this.dodatniPodaci = value;
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
     *       &lt;choice&gt;
     *         &lt;element name="fizicko_lice" type="{http://www.ftn.uns.ac.rs/zahtev_za_patent}TFizicko_Lice"/&gt;
     *         &lt;element name="pravno_lice" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;all&gt;
     *                   &lt;element name="poslovno_ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                 &lt;/all&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/choice&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "fizickoLice",
        "pravnoLice"
    })
    public static class FizickoPravnoLice {

        @XmlElement(name = "fizicko_lice", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent")
        protected TFizickoLice fizickoLice;
        @XmlElement(name = "pravno_lice", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent")
        protected TLicniPodaci.FizickoPravnoLice.PravnoLice pravnoLice;

        /**
         * Gets the value of the fizickoLice property.
         * 
         * @return
         *     possible object is
         *     {@link TFizickoLice }
         *     
         */
        public TFizickoLice getFizickoLice() {
            return fizickoLice;
        }

        /**
         * Sets the value of the fizickoLice property.
         * 
         * @param value
         *     allowed object is
         *     {@link TFizickoLice }
         *     
         */
        public void setFizickoLice(TFizickoLice value) {
            this.fizickoLice = value;
        }

        /**
         * Gets the value of the pravnoLice property.
         * 
         * @return
         *     possible object is
         *     {@link TLicniPodaci.FizickoPravnoLice.PravnoLice }
         *     
         */
        public TLicniPodaci.FizickoPravnoLice.PravnoLice getPravnoLice() {
            return pravnoLice;
        }

        /**
         * Sets the value of the pravnoLice property.
         * 
         * @param value
         *     allowed object is
         *     {@link TLicniPodaci.FizickoPravnoLice.PravnoLice }
         *     
         */
        public void setPravnoLice(TLicniPodaci.FizickoPravnoLice.PravnoLice value) {
            this.pravnoLice = value;
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
         *       &lt;all&gt;
         *         &lt;element name="poslovno_ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *       &lt;/all&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {

        })
        public static class PravnoLice {

            @XmlElement(name = "poslovno_ime", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
            protected String poslovnoIme;

            /**
             * Gets the value of the poslovnoIme property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPoslovnoIme() {
                return poslovnoIme;
            }

            /**
             * Sets the value of the poslovnoIme property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPoslovnoIme(String value) {
                this.poslovnoIme = value;
            }

            @Override
            public String toString() {
                return
                        "\t\t\t\t\t<poslovnoIme>" + poslovnoIme + "</poslovnoIme>\n";
            }
        }

        @Override
        public String toString() {
            return
                    "\t\t\t\t<fizickoLice>\n" + fizickoLice + "\t\t\t\t</fizickoLice>\n" +
                    "\t\t\t\t<pravnoLice>" + pravnoLice + "</pravnoLice>\n";
        }
    }

    @Override
    public String toString() {
        return
                "\t\t\t<fizickoPravnoLice>\n" + fizickoPravnoLice + "\t\t\t</fizickoPravnoLice>\n"+
                "\t\t\t<drzavljanstvo>" + drzavljanstvo + "</drzavljanstvo>\n" +
                "\t\t\t<adresa>\n" + adresa + "\t\t\t</adresa>\n" +
                "\t\t\t<dodatniPodaci>\n" + dodatniPodaci + "\t\t\t</dodatniPodaci>\n";
    }
}
