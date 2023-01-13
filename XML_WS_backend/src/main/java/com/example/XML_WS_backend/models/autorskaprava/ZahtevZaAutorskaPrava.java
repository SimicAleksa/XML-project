
package com.example.XML_WS_backend.models.autorskaprava;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="pseudonim_ili_znak_autora" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="podaci_o_podnosiocu"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="lice"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;choice&gt;
 *                             &lt;element name="fizicko_lice" type="{http://www.ftn.uns.ac.rs/AutorskaPravaLatinica}TPodnosilac"/&gt;
 *                             &lt;element name="pravno_lice"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="poslovno_ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="podaci_o_sedistu" type="{http://www.ftn.uns.ac.rs/AutorskaPravaLatinica}TAdresa"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/choice&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="telefon"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;pattern value="[0-9]{9,12}"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="email"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;pattern value="[\w-]+@([\w-]+\.)+[\w-]+"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="podaci_o_autoru" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice&gt;
 *                   &lt;element name="anoniman_autor" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="autor" type="{http://www.ftn.uns.ac.rs/AutorskaPravaLatinica}TAutor"/&gt;
 *                 &lt;/choice&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="podaci_o_punomocniku" type="{http://www.ftn.uns.ac.rs/AutorskaPravaLatinica}TPunomocnik"/&gt;
 *         &lt;element name="podaci_o_delu"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;all&gt;
 *                   &lt;element name="naslov" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="alternativni_naslov" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="podaci_o_delu_prerade" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;all&gt;
 *                             &lt;element name="naslov_dela_prerade" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="autor_dela_prerade" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                           &lt;/all&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="vrsta_autorskog_dela" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="forma_zapisa_autorskog_dela" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="delo_stvoreno_u_radnom_odnosu" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="nacin_koriscenja_dela" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/all&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="prilozi"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;all&gt;
 *                   &lt;element name="opis_dela" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="primer_dela" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/all&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/all&gt;
 *       &lt;attribute name="datum_podnosenja" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
 *       &lt;attribute name="broj_prijave" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
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
@XmlRootElement(name = "ZAHTEV_ZA_UNOSENJE_U_EVIDENCIJU_I_DEPONOVANJE_AUTORSKIH_DELA", namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica")
public class ZahtevZaAutorskaPrava {

    @XmlElement(name = "pseudonim_ili_znak_autora", namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica", required = true)
    protected String pseudonimIliZnakAutora;
    @XmlElement(name = "podaci_o_podnosiocu", namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica", required = true)
    protected ZahtevZaAutorskaPrava.PodaciOPodnosiocu podaciOPodnosiocu;
    @XmlElement(name = "podaci_o_autoru", namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica")
    protected ZahtevZaAutorskaPrava.PodaciOAutoru podaciOAutoru;
    @XmlElement(name = "podaci_o_punomocniku", namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica", required = true)
    protected TPunomocnik podaciOPunomocniku;
    @XmlElement(name = "podaci_o_delu", namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica", required = true)
    protected ZahtevZaAutorskaPrava.PodaciODelu podaciODelu;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica", required = true)
    protected ZahtevZaAutorskaPrava.Prilozi prilozi;
    @XmlAttribute(name = "datum_podnosenja")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumPodnosenja;
    @XmlAttribute(name = "broj_prijave")
    protected String brojPrijave;

    /**
     * Gets the value of the pseudonimIliZnakAutora property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPseudonimIliZnakAutora() {
        return pseudonimIliZnakAutora;
    }

    /**
     * Sets the value of the pseudonimIliZnakAutora property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPseudonimIliZnakAutora(String value) {
        this.pseudonimIliZnakAutora = value;
    }

    /**
     * Gets the value of the podaciOPodnosiocu property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaAutorskaPrava.PodaciOPodnosiocu }
     *     
     */
    public ZahtevZaAutorskaPrava.PodaciOPodnosiocu getPodaciOPodnosiocu() {
        return podaciOPodnosiocu;
    }

    /**
     * Sets the value of the podaciOPodnosiocu property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaAutorskaPrava.PodaciOPodnosiocu }
     *     
     */
    public void setPodaciOPodnosiocu(ZahtevZaAutorskaPrava.PodaciOPodnosiocu value) {
        this.podaciOPodnosiocu = value;
    }

    /**
     * Gets the value of the podaciOAutoru property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaAutorskaPrava.PodaciOAutoru }
     *     
     */
    public ZahtevZaAutorskaPrava.PodaciOAutoru getPodaciOAutoru() {
        return podaciOAutoru;
    }

    /**
     * Sets the value of the podaciOAutoru property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaAutorskaPrava.PodaciOAutoru }
     *     
     */
    public void setPodaciOAutoru(ZahtevZaAutorskaPrava.PodaciOAutoru value) {
        this.podaciOAutoru = value;
    }

    /**
     * Gets the value of the podaciOPunomocniku property.
     * 
     * @return
     *     possible object is
     *     {@link TPunomocnik }
     *     
     */
    public TPunomocnik getPodaciOPunomocniku() {
        return podaciOPunomocniku;
    }

    /**
     * Sets the value of the podaciOPunomocniku property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPunomocnik }
     *     
     */
    public void setPodaciOPunomocniku(TPunomocnik value) {
        this.podaciOPunomocniku = value;
    }

    /**
     * Gets the value of the podaciODelu property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaAutorskaPrava.PodaciODelu }
     *     
     */
    public ZahtevZaAutorskaPrava.PodaciODelu getPodaciODelu() {
        return podaciODelu;
    }

    /**
     * Sets the value of the podaciODelu property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaAutorskaPrava.PodaciODelu }
     *     
     */
    public void setPodaciODelu(ZahtevZaAutorskaPrava.PodaciODelu value) {
        this.podaciODelu = value;
    }

    /**
     * Gets the value of the prilozi property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaAutorskaPrava.Prilozi }
     *     
     */
    public ZahtevZaAutorskaPrava.Prilozi getPrilozi() {
        return prilozi;
    }

    /**
     * Sets the value of the prilozi property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaAutorskaPrava.Prilozi }
     *     
     */
    public void setPrilozi(ZahtevZaAutorskaPrava.Prilozi value) {
        this.prilozi = value;
    }

    /**
     * Gets the value of the datumPodnosenja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumPodnosenja() {
        return datumPodnosenja;
    }

    /**
     * Sets the value of the datumPodnosenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumPodnosenja(XMLGregorianCalendar value) {
        this.datumPodnosenja = value;
    }

    /**
     * Gets the value of the brojPrijave property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojPrijave() {
        return brojPrijave;
    }

    /**
     * Sets the value of the brojPrijave property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojPrijave(String value) {
        this.brojPrijave = value;
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
     *         &lt;element name="anoniman_autor" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="autor" type="{http://www.ftn.uns.ac.rs/AutorskaPravaLatinica}TAutor"/&gt;
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
        "anonimanAutor",
        "autor"
    })
    public static class PodaciOAutoru {

        @XmlElement(name = "anoniman_autor", namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica")
        protected Boolean anonimanAutor;
        @XmlElement(namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica")
        protected TAutor autor;

        /**
         * Gets the value of the anonimanAutor property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isAnonimanAutor() {
            return anonimanAutor;
        }

        /**
         * Sets the value of the anonimanAutor property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setAnonimanAutor(Boolean value) {
            this.anonimanAutor = value;
        }

        /**
         * Gets the value of the autor property.
         * 
         * @return
         *     possible object is
         *     {@link TAutor }
         *     
         */
        public TAutor getAutor() {
            return autor;
        }

        /**
         * Sets the value of the autor property.
         * 
         * @param value
         *     allowed object is
         *     {@link TAutor }
         *     
         */
        public void setAutor(TAutor value) {
            this.autor = value;
        }

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
     *         &lt;element name="naslov" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="alternativni_naslov" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="podaci_o_delu_prerade" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;all&gt;
     *                   &lt;element name="naslov_dela_prerade" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="autor_dela_prerade" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                 &lt;/all&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="vrsta_autorskog_dela" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="forma_zapisa_autorskog_dela" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="delo_stvoreno_u_radnom_odnosu" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="nacin_koriscenja_dela" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    public static class PodaciODelu {

        @XmlElement(namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica", required = true)
        protected String naslov;
        @XmlElement(name = "alternativni_naslov", namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica")
        protected String alternativniNaslov;
        @XmlElement(name = "podaci_o_delu_prerade", namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica")
        protected ZahtevZaAutorskaPrava.PodaciODelu.PodaciODeluPrerade podaciODeluPrerade;
        @XmlElement(name = "vrsta_autorskog_dela", namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica", required = true)
        protected String vrstaAutorskogDela;
        @XmlElement(name = "forma_zapisa_autorskog_dela", namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica", required = true)
        protected String formaZapisaAutorskogDela;
        @XmlElement(name = "delo_stvoreno_u_radnom_odnosu", namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica")
        protected boolean deloStvorenoURadnomOdnosu;
        @XmlElement(name = "nacin_koriscenja_dela", namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica", required = true)
        protected String nacinKoriscenjaDela;

        /**
         * Gets the value of the naslov property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNaslov() {
            return naslov;
        }

        /**
         * Sets the value of the naslov property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNaslov(String value) {
            this.naslov = value;
        }

        /**
         * Gets the value of the alternativniNaslov property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAlternativniNaslov() {
            return alternativniNaslov;
        }

        /**
         * Sets the value of the alternativniNaslov property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAlternativniNaslov(String value) {
            this.alternativniNaslov = value;
        }

        /**
         * Gets the value of the podaciODeluPrerade property.
         * 
         * @return
         *     possible object is
         *     {@link ZahtevZaAutorskaPrava.PodaciODelu.PodaciODeluPrerade }
         *     
         */
        public ZahtevZaAutorskaPrava.PodaciODelu.PodaciODeluPrerade getPodaciODeluPrerade() {
            return podaciODeluPrerade;
        }

        /**
         * Sets the value of the podaciODeluPrerade property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZahtevZaAutorskaPrava.PodaciODelu.PodaciODeluPrerade }
         *     
         */
        public void setPodaciODeluPrerade(ZahtevZaAutorskaPrava.PodaciODelu.PodaciODeluPrerade value) {
            this.podaciODeluPrerade = value;
        }

        /**
         * Gets the value of the vrstaAutorskogDela property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVrstaAutorskogDela() {
            return vrstaAutorskogDela;
        }

        /**
         * Sets the value of the vrstaAutorskogDela property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVrstaAutorskogDela(String value) {
            this.vrstaAutorskogDela = value;
        }

        /**
         * Gets the value of the formaZapisaAutorskogDela property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFormaZapisaAutorskogDela() {
            return formaZapisaAutorskogDela;
        }

        /**
         * Sets the value of the formaZapisaAutorskogDela property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFormaZapisaAutorskogDela(String value) {
            this.formaZapisaAutorskogDela = value;
        }

        /**
         * Gets the value of the deloStvorenoURadnomOdnosu property.
         * 
         */
        public boolean isDeloStvorenoURadnomOdnosu() {
            return deloStvorenoURadnomOdnosu;
        }

        /**
         * Sets the value of the deloStvorenoURadnomOdnosu property.
         * 
         */
        public void setDeloStvorenoURadnomOdnosu(boolean value) {
            this.deloStvorenoURadnomOdnosu = value;
        }

        /**
         * Gets the value of the nacinKoriscenjaDela property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNacinKoriscenjaDela() {
            return nacinKoriscenjaDela;
        }

        /**
         * Sets the value of the nacinKoriscenjaDela property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNacinKoriscenjaDela(String value) {
            this.nacinKoriscenjaDela = value;
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
         *         &lt;element name="naslov_dela_prerade" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="autor_dela_prerade" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
        public static class PodaciODeluPrerade {

            @XmlElement(name = "naslov_dela_prerade", namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica", required = true)
            protected String naslovDelaPrerade;
            @XmlElement(name = "autor_dela_prerade", namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica", required = true)
            protected String autorDelaPrerade;

            /**
             * Gets the value of the naslovDelaPrerade property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNaslovDelaPrerade() {
                return naslovDelaPrerade;
            }

            /**
             * Sets the value of the naslovDelaPrerade property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNaslovDelaPrerade(String value) {
                this.naslovDelaPrerade = value;
            }

            /**
             * Gets the value of the autorDelaPrerade property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAutorDelaPrerade() {
                return autorDelaPrerade;
            }

            /**
             * Sets the value of the autorDelaPrerade property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAutorDelaPrerade(String value) {
                this.autorDelaPrerade = value;
            }

        }

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
     *         &lt;element name="lice"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;choice&gt;
     *                   &lt;element name="fizicko_lice" type="{http://www.ftn.uns.ac.rs/AutorskaPravaLatinica}TPodnosilac"/&gt;
     *                   &lt;element name="pravno_lice"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="poslovno_ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="podaci_o_sedistu" type="{http://www.ftn.uns.ac.rs/AutorskaPravaLatinica}TAdresa"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/choice&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="telefon"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;pattern value="[0-9]{9,12}"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="email"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;pattern value="[\w-]+@([\w-]+\.)+[\w-]+"/&gt;
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
    @XmlType(name = "", propOrder = {
        "lice",
        "telefon",
        "email"
    })
    public static class PodaciOPodnosiocu {

        @XmlElement(namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica", required = true)
        protected ZahtevZaAutorskaPrava.PodaciOPodnosiocu.Lice lice;
        @XmlElement(namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica", required = true)
        protected String telefon;
        @XmlElement(namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica", required = true)
        protected String email;

        /**
         * Gets the value of the lice property.
         * 
         * @return
         *     possible object is
         *     {@link ZahtevZaAutorskaPrava.PodaciOPodnosiocu.Lice }
         *     
         */
        public ZahtevZaAutorskaPrava.PodaciOPodnosiocu.Lice getLice() {
            return lice;
        }

        /**
         * Sets the value of the lice property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZahtevZaAutorskaPrava.PodaciOPodnosiocu.Lice }
         *     
         */
        public void setLice(ZahtevZaAutorskaPrava.PodaciOPodnosiocu.Lice value) {
            this.lice = value;
        }

        /**
         * Gets the value of the telefon property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTelefon() {
            return telefon;
        }

        /**
         * Sets the value of the telefon property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTelefon(String value) {
            this.telefon = value;
        }

        /**
         * Gets the value of the email property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEmail() {
            return email;
        }

        /**
         * Sets the value of the email property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEmail(String value) {
            this.email = value;
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
         *         &lt;element name="fizicko_lice" type="{http://www.ftn.uns.ac.rs/AutorskaPravaLatinica}TPodnosilac"/&gt;
         *         &lt;element name="pravno_lice"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="poslovno_ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="podaci_o_sedistu" type="{http://www.ftn.uns.ac.rs/AutorskaPravaLatinica}TAdresa"/&gt;
         *                 &lt;/sequence&gt;
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
        public static class Lice {

            @XmlElement(name = "fizicko_lice", namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica")
            protected TPodnosilac fizickoLice;
            @XmlElement(name = "pravno_lice", namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica")
            protected ZahtevZaAutorskaPrava.PodaciOPodnosiocu.Lice.PravnoLice pravnoLice;

            /**
             * Gets the value of the fizickoLice property.
             * 
             * @return
             *     possible object is
             *     {@link TPodnosilac }
             *     
             */
            public TPodnosilac getFizickoLice() {
                return fizickoLice;
            }

            /**
             * Sets the value of the fizickoLice property.
             * 
             * @param value
             *     allowed object is
             *     {@link TPodnosilac }
             *     
             */
            public void setFizickoLice(TPodnosilac value) {
                this.fizickoLice = value;
            }

            /**
             * Gets the value of the pravnoLice property.
             * 
             * @return
             *     possible object is
             *     {@link ZahtevZaAutorskaPrava.PodaciOPodnosiocu.Lice.PravnoLice }
             *     
             */
            public ZahtevZaAutorskaPrava.PodaciOPodnosiocu.Lice.PravnoLice getPravnoLice() {
                return pravnoLice;
            }

            /**
             * Sets the value of the pravnoLice property.
             * 
             * @param value
             *     allowed object is
             *     {@link ZahtevZaAutorskaPrava.PodaciOPodnosiocu.Lice.PravnoLice }
             *     
             */
            public void setPravnoLice(ZahtevZaAutorskaPrava.PodaciOPodnosiocu.Lice.PravnoLice value) {
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
             *       &lt;sequence&gt;
             *         &lt;element name="poslovno_ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="podaci_o_sedistu" type="{http://www.ftn.uns.ac.rs/AutorskaPravaLatinica}TAdresa"/&gt;
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
                "poslovnoIme",
                "podaciOSedistu"
            })
            public static class PravnoLice {

                @XmlElement(name = "poslovno_ime", namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica", required = true)
                protected String poslovnoIme;
                @XmlElement(name = "podaci_o_sedistu", namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica", required = true)
                protected TAdresa podaciOSedistu;

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

                /**
                 * Gets the value of the podaciOSedistu property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link TAdresa }
                 *     
                 */
                public TAdresa getPodaciOSedistu() {
                    return podaciOSedistu;
                }

                /**
                 * Sets the value of the podaciOSedistu property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link TAdresa }
                 *     
                 */
                public void setPodaciOSedistu(TAdresa value) {
                    this.podaciOSedistu = value;
                }

            }

        }

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
     *         &lt;element name="opis_dela" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="primer_dela" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    public static class Prilozi {

        @XmlElement(name = "opis_dela", namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica", required = true)
        protected String opisDela;
        @XmlElement(name = "primer_dela", namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica", required = true)
        protected String primerDela;

        /**
         * Gets the value of the opisDela property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOpisDela() {
            return opisDela;
        }

        /**
         * Sets the value of the opisDela property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOpisDela(String value) {
            this.opisDela = value;
        }

        /**
         * Gets the value of the primerDela property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPrimerDela() {
            return primerDela;
        }

        /**
         * Sets the value of the primerDela property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPrimerDela(String value) {
            this.primerDela = value;
        }

    }

}
