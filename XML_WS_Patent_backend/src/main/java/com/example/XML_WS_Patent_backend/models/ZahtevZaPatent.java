
package com.example.XML_WS_Patent_backend.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="popunjava_zavod"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;all&gt;
 *                   &lt;element name="broj_prijave" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="datum_prijema" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element name="priznati_datum_podnosenja" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                 &lt;/all&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="naziv_pronalaska"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;all&gt;
 *                   &lt;element name="na_srpskom_jeziku" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="na_engleskom_jeziku" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/all&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="podnosilac_prijave"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;all&gt;
 *                   &lt;element name="podnosilac_prijave_je_i_pronalazac" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="licni_podaci" type="{http://www.ftn.uns.ac.rs/zahtev_za_patent}TLicni_Podaci"/&gt;
 *                 &lt;/all&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="pronalazac"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;all&gt;
 *                   &lt;element name="pronalazac_ne_zeli_da_bude_naveden_u_prijavi" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="pronalazac_je_podnosilac_prijave" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="podaci_o_pronalazacu"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;all&gt;
 *                             &lt;element name="fizicko_lice" type="{http://www.ftn.uns.ac.rs/zahtev_za_patent}TFizicko_Lice"/&gt;
 *                             &lt;element name="adresa" type="{http://www.ftn.uns.ac.rs/zahtev_za_patent}TAdresa"/&gt;
 *                             &lt;element name="dodatni_podaci" type="{http://www.ftn.uns.ac.rs/zahtev_za_patent}TDodatniPodaci"/&gt;
 *                           &lt;/all&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/all&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="punomocnik"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;all&gt;
 *                   &lt;element name="vrsta_punomocja"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;all&gt;
 *                             &lt;element name="punomocnik_za_zastupanje" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                             &lt;element name="punomocnik_za_prijem_pismena" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                           &lt;/all&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="licni_podaci" type="{http://www.ftn.uns.ac.rs/zahtev_za_patent}TLicni_Podaci"/&gt;
 *                 &lt;/all&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="dostavljanje_podaci"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;all&gt;
 *                   &lt;element name="adresa" type="{http://www.ftn.uns.ac.rs/zahtev_za_patent}TAdresa"/&gt;
 *                   &lt;element name="podnosilac_saglasan_dostavljanje_elektronskim_putem" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="podnosilac_saglasan_dostavljanje_u_papirnoj_formi" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                 &lt;/all&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="prijava"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;all&gt;
 *                   &lt;element name="dopunska_prijava" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="izdvojena_prijava" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="broj_osnovne_prijave" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="datum_podnosenja_osnovne_prijave" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                 &lt;/all&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="zahtev_za_priznanje_prava_prvenstva_iz_ranijih_prijava"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;all&gt;
 *                   &lt;element name="ranija_prijava"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;all&gt;
 *                             &lt;element name="datum_podnosenja_ranije_prijave" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                             &lt;element name="broj_ranije_prijave" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="dvoslovna_oznaka_drzave"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;maxLength value="2"/&gt;
 *                                   &lt;minLength value="2"/&gt;
 *                                   &lt;pattern value="[A-Z][A-Z]"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/all&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/all&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
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
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "Zahtev_za_patent", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent")
public class ZahtevZaPatent {

    @XmlElement(name = "popunjava_zavod", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
    protected ZahtevZaPatent.PopunjavaZavod popunjavaZavod;
    @XmlElement(name = "naziv_pronalaska", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
    protected ZahtevZaPatent.NazivPronalaska nazivPronalaska;
    @XmlElement(name = "podnosilac_prijave", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
    protected ZahtevZaPatent.PodnosilacPrijave podnosilacPrijave;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
    protected ZahtevZaPatent.Pronalazac pronalazac;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
    protected ZahtevZaPatent.Punomocnik punomocnik;
    @XmlElement(name = "dostavljanje_podaci", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
    protected ZahtevZaPatent.DostavljanjePodaci dostavljanjePodaci;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
    protected ZahtevZaPatent.Prijava prijava;
    @XmlElement(name = "zahtev_za_priznanje_prava_prvenstva_iz_ranijih_prijava", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
    protected ZahtevZaPatent.ZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava zahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava;

    /**
     * Gets the value of the popunjavaZavod property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaPatent.PopunjavaZavod }
     *     
     */
    public ZahtevZaPatent.PopunjavaZavod getPopunjavaZavod() {
        return popunjavaZavod;
    }

    /**
     * Sets the value of the popunjavaZavod property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaPatent.PopunjavaZavod }
     *     
     */
    public void setPopunjavaZavod(ZahtevZaPatent.PopunjavaZavod value) {
        this.popunjavaZavod = value;
    }

    /**
     * Gets the value of the nazivPronalaska property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaPatent.NazivPronalaska }
     *     
     */
    public ZahtevZaPatent.NazivPronalaska getNazivPronalaska() {
        return nazivPronalaska;
    }

    /**
     * Sets the value of the nazivPronalaska property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaPatent.NazivPronalaska }
     *     
     */
    public void setNazivPronalaska(ZahtevZaPatent.NazivPronalaska value) {
        this.nazivPronalaska = value;
    }

    /**
     * Gets the value of the podnosilacPrijave property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaPatent.PodnosilacPrijave }
     *     
     */
    public ZahtevZaPatent.PodnosilacPrijave getPodnosilacPrijave() {
        return podnosilacPrijave;
    }

    /**
     * Sets the value of the podnosilacPrijave property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaPatent.PodnosilacPrijave }
     *     
     */
    public void setPodnosilacPrijave(ZahtevZaPatent.PodnosilacPrijave value) {
        this.podnosilacPrijave = value;
    }

    /**
     * Gets the value of the pronalazac property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaPatent.Pronalazac }
     *     
     */
    public ZahtevZaPatent.Pronalazac getPronalazac() {
        return pronalazac;
    }

    /**
     * Sets the value of the pronalazac property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaPatent.Pronalazac }
     *     
     */
    public void setPronalazac(ZahtevZaPatent.Pronalazac value) {
        this.pronalazac = value;
    }

    /**
     * Gets the value of the punomocnik property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaPatent.Punomocnik }
     *     
     */
    public ZahtevZaPatent.Punomocnik getPunomocnik() {
        return punomocnik;
    }

    /**
     * Sets the value of the punomocnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaPatent.Punomocnik }
     *     
     */
    public void setPunomocnik(ZahtevZaPatent.Punomocnik value) {
        this.punomocnik = value;
    }

    /**
     * Gets the value of the dostavljanjePodaci property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaPatent.DostavljanjePodaci }
     *     
     */
    public ZahtevZaPatent.DostavljanjePodaci getDostavljanjePodaci() {
        return dostavljanjePodaci;
    }

    /**
     * Sets the value of the dostavljanjePodaci property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaPatent.DostavljanjePodaci }
     *     
     */
    public void setDostavljanjePodaci(ZahtevZaPatent.DostavljanjePodaci value) {
        this.dostavljanjePodaci = value;
    }

    /**
     * Gets the value of the prijava property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaPatent.Prijava }
     *     
     */
    public ZahtevZaPatent.Prijava getPrijava() {
        return prijava;
    }

    /**
     * Sets the value of the prijava property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaPatent.Prijava }
     *     
     */
    public void setPrijava(ZahtevZaPatent.Prijava value) {
        this.prijava = value;
    }

    /**
     * Gets the value of the zahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaPatent.ZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava }
     *     
     */
    public ZahtevZaPatent.ZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava getZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava() {
        return zahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava;
    }

    /**
     * Sets the value of the zahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaPatent.ZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava }
     *     
     */
    public void setZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava(ZahtevZaPatent.ZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava value) {
        this.zahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava = value;
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
     *         &lt;element name="adresa" type="{http://www.ftn.uns.ac.rs/zahtev_za_patent}TAdresa"/&gt;
     *         &lt;element name="podnosilac_saglasan_dostavljanje_elektronskim_putem" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="podnosilac_saglasan_dostavljanje_u_papirnoj_formi" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    public static class DostavljanjePodaci {

        @XmlElement(namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
        protected TAdresa adresa;
        @XmlElement(name = "podnosilac_saglasan_dostavljanje_elektronskim_putem", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent")
        protected boolean podnosilacSaglasanDostavljanjeElektronskimPutem;
        @XmlElement(name = "podnosilac_saglasan_dostavljanje_u_papirnoj_formi", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent")
        protected boolean podnosilacSaglasanDostavljanjeUPapirnojFormi;

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
         * Gets the value of the podnosilacSaglasanDostavljanjeElektronskimPutem property.
         * 
         */
        public boolean isPodnosilacSaglasanDostavljanjeElektronskimPutem() {
            return podnosilacSaglasanDostavljanjeElektronskimPutem;
        }

        /**
         * Sets the value of the podnosilacSaglasanDostavljanjeElektronskimPutem property.
         * 
         */
        public void setPodnosilacSaglasanDostavljanjeElektronskimPutem(boolean value) {
            this.podnosilacSaglasanDostavljanjeElektronskimPutem = value;
        }

        /**
         * Gets the value of the podnosilacSaglasanDostavljanjeUPapirnojFormi property.
         * 
         */
        public boolean isPodnosilacSaglasanDostavljanjeUPapirnojFormi() {
            return podnosilacSaglasanDostavljanjeUPapirnojFormi;
        }

        /**
         * Sets the value of the podnosilacSaglasanDostavljanjeUPapirnojFormi property.
         * 
         */
        public void setPodnosilacSaglasanDostavljanjeUPapirnojFormi(boolean value) {
            this.podnosilacSaglasanDostavljanjeUPapirnojFormi = value;
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
     *         &lt;element name="na_srpskom_jeziku" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="na_engleskom_jeziku" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    public static class NazivPronalaska {

        @XmlElement(name = "na_srpskom_jeziku", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
        protected String naSrpskomJeziku;
        @XmlElement(name = "na_engleskom_jeziku", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
        protected String naEngleskomJeziku;

        /**
         * Gets the value of the naSrpskomJeziku property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNaSrpskomJeziku() {
            return naSrpskomJeziku;
        }

        /**
         * Sets the value of the naSrpskomJeziku property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNaSrpskomJeziku(String value) {
            this.naSrpskomJeziku = value;
        }

        /**
         * Gets the value of the naEngleskomJeziku property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNaEngleskomJeziku() {
            return naEngleskomJeziku;
        }

        /**
         * Sets the value of the naEngleskomJeziku property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNaEngleskomJeziku(String value) {
            this.naEngleskomJeziku = value;
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
     *         &lt;element name="podnosilac_prijave_je_i_pronalazac" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="licni_podaci" type="{http://www.ftn.uns.ac.rs/zahtev_za_patent}TLicni_Podaci"/&gt;
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
    public static class PodnosilacPrijave {

        @XmlElement(name = "podnosilac_prijave_je_i_pronalazac", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent")
        protected boolean podnosilacPrijaveJeIPronalazac;
        @XmlElement(name = "licni_podaci", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
        protected TLicniPodaci licniPodaci;

        /**
         * Gets the value of the podnosilacPrijaveJeIPronalazac property.
         * 
         */
        public boolean isPodnosilacPrijaveJeIPronalazac() {
            return podnosilacPrijaveJeIPronalazac;
        }

        /**
         * Sets the value of the podnosilacPrijaveJeIPronalazac property.
         * 
         */
        public void setPodnosilacPrijaveJeIPronalazac(boolean value) {
            this.podnosilacPrijaveJeIPronalazac = value;
        }

        /**
         * Gets the value of the licniPodaci property.
         * 
         * @return
         *     possible object is
         *     {@link TLicniPodaci }
         *     
         */
        public TLicniPodaci getLicniPodaci() {
            return licniPodaci;
        }

        /**
         * Sets the value of the licniPodaci property.
         * 
         * @param value
         *     allowed object is
         *     {@link TLicniPodaci }
         *     
         */
        public void setLicniPodaci(TLicniPodaci value) {
            this.licniPodaci = value;
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
     *         &lt;element name="broj_prijave" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="datum_prijema" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element name="priznati_datum_podnosenja" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
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
    public static class PopunjavaZavod {

        @XmlElement(name = "broj_prijave", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
        protected String brojPrijave;
        @XmlElement(name = "datum_prijema", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar datumPrijema;
        @XmlElement(name = "priznati_datum_podnosenja", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar priznatiDatumPodnosenja;

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
         * Gets the value of the datumPrijema property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDatumPrijema() {
            return datumPrijema;
        }

        /**
         * Sets the value of the datumPrijema property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDatumPrijema(XMLGregorianCalendar value) {
            this.datumPrijema = value;
        }

        /**
         * Gets the value of the priznatiDatumPodnosenja property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getPriznatiDatumPodnosenja() {
            return priznatiDatumPodnosenja;
        }

        /**
         * Sets the value of the priznatiDatumPodnosenja property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setPriznatiDatumPodnosenja(XMLGregorianCalendar value) {
            this.priznatiDatumPodnosenja = value;
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
     *         &lt;element name="dopunska_prijava" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="izdvojena_prijava" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="broj_osnovne_prijave" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="datum_podnosenja_osnovne_prijave" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
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
    public static class Prijava {

        @XmlElement(name = "dopunska_prijava", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent")
        protected boolean dopunskaPrijava;
        @XmlElement(name = "izdvojena_prijava", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent")
        protected boolean izdvojenaPrijava;
        @XmlElement(name = "broj_osnovne_prijave", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
        protected String brojOsnovnePrijave;
        @XmlElement(name = "datum_podnosenja_osnovne_prijave", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar datumPodnosenjaOsnovnePrijave;

        /**
         * Gets the value of the dopunskaPrijava property.
         * 
         */
        public boolean isDopunskaPrijava() {
            return dopunskaPrijava;
        }

        /**
         * Sets the value of the dopunskaPrijava property.
         * 
         */
        public void setDopunskaPrijava(boolean value) {
            this.dopunskaPrijava = value;
        }

        /**
         * Gets the value of the izdvojenaPrijava property.
         * 
         */
        public boolean isIzdvojenaPrijava() {
            return izdvojenaPrijava;
        }

        /**
         * Sets the value of the izdvojenaPrijava property.
         * 
         */
        public void setIzdvojenaPrijava(boolean value) {
            this.izdvojenaPrijava = value;
        }

        /**
         * Gets the value of the brojOsnovnePrijave property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBrojOsnovnePrijave() {
            return brojOsnovnePrijave;
        }

        /**
         * Sets the value of the brojOsnovnePrijave property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBrojOsnovnePrijave(String value) {
            this.brojOsnovnePrijave = value;
        }

        /**
         * Gets the value of the datumPodnosenjaOsnovnePrijave property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDatumPodnosenjaOsnovnePrijave() {
            return datumPodnosenjaOsnovnePrijave;
        }

        /**
         * Sets the value of the datumPodnosenjaOsnovnePrijave property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDatumPodnosenjaOsnovnePrijave(XMLGregorianCalendar value) {
            this.datumPodnosenjaOsnovnePrijave = value;
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
     *         &lt;element name="pronalazac_ne_zeli_da_bude_naveden_u_prijavi" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="pronalazac_je_podnosilac_prijave" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="podaci_o_pronalazacu"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;all&gt;
     *                   &lt;element name="fizicko_lice" type="{http://www.ftn.uns.ac.rs/zahtev_za_patent}TFizicko_Lice"/&gt;
     *                   &lt;element name="adresa" type="{http://www.ftn.uns.ac.rs/zahtev_za_patent}TAdresa"/&gt;
     *                   &lt;element name="dodatni_podaci" type="{http://www.ftn.uns.ac.rs/zahtev_za_patent}TDodatniPodaci"/&gt;
     *                 &lt;/all&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
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
    @XmlType(name = "", propOrder = {

    })
    public static class Pronalazac {

        @XmlElement(name = "pronalazac_ne_zeli_da_bude_naveden_u_prijavi", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent")
        protected boolean pronalazacNeZeliDaBudeNavedenUPrijavi;
        @XmlElement(name = "pronalazac_je_podnosilac_prijave", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent")
        protected boolean pronalazacJePodnosilacPrijave;
        @XmlElement(name = "podaci_o_pronalazacu", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
        protected ZahtevZaPatent.Pronalazac.PodaciOPronalazacu podaciOPronalazacu;

        /**
         * Gets the value of the pronalazacNeZeliDaBudeNavedenUPrijavi property.
         * 
         */
        public boolean isPronalazacNeZeliDaBudeNavedenUPrijavi() {
            return pronalazacNeZeliDaBudeNavedenUPrijavi;
        }

        /**
         * Sets the value of the pronalazacNeZeliDaBudeNavedenUPrijavi property.
         * 
         */
        public void setPronalazacNeZeliDaBudeNavedenUPrijavi(boolean value) {
            this.pronalazacNeZeliDaBudeNavedenUPrijavi = value;
        }

        /**
         * Gets the value of the pronalazacJePodnosilacPrijave property.
         * 
         */
        public boolean isPronalazacJePodnosilacPrijave() {
            return pronalazacJePodnosilacPrijave;
        }

        /**
         * Sets the value of the pronalazacJePodnosilacPrijave property.
         * 
         */
        public void setPronalazacJePodnosilacPrijave(boolean value) {
            this.pronalazacJePodnosilacPrijave = value;
        }

        /**
         * Gets the value of the podaciOPronalazacu property.
         * 
         * @return
         *     possible object is
         *     {@link ZahtevZaPatent.Pronalazac.PodaciOPronalazacu }
         *     
         */
        public ZahtevZaPatent.Pronalazac.PodaciOPronalazacu getPodaciOPronalazacu() {
            return podaciOPronalazacu;
        }

        /**
         * Sets the value of the podaciOPronalazacu property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZahtevZaPatent.Pronalazac.PodaciOPronalazacu }
         *     
         */
        public void setPodaciOPronalazacu(ZahtevZaPatent.Pronalazac.PodaciOPronalazacu value) {
            this.podaciOPronalazacu = value;
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
         *         &lt;element name="fizicko_lice" type="{http://www.ftn.uns.ac.rs/zahtev_za_patent}TFizicko_Lice"/&gt;
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
        @XmlType(name = "", propOrder = {

        })
        public static class PodaciOPronalazacu {

            @XmlElement(name = "fizicko_lice", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
            protected TFizickoLice fizickoLice;
            @XmlElement(namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
            protected TAdresa adresa;
            @XmlElement(name = "dodatni_podaci", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
            protected TDodatniPodaci dodatniPodaci;

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
     *         &lt;element name="vrsta_punomocja"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;all&gt;
     *                   &lt;element name="punomocnik_za_zastupanje" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                   &lt;element name="punomocnik_za_prijem_pismena" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                 &lt;/all&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="licni_podaci" type="{http://www.ftn.uns.ac.rs/zahtev_za_patent}TLicni_Podaci"/&gt;
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
    public static class Punomocnik {

        @XmlElement(name = "vrsta_punomocja", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
        protected ZahtevZaPatent.Punomocnik.VrstaPunomocja vrstaPunomocja;
        @XmlElement(name = "licni_podaci", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
        protected TLicniPodaci licniPodaci;

        /**
         * Gets the value of the vrstaPunomocja property.
         * 
         * @return
         *     possible object is
         *     {@link ZahtevZaPatent.Punomocnik.VrstaPunomocja }
         *     
         */
        public ZahtevZaPatent.Punomocnik.VrstaPunomocja getVrstaPunomocja() {
            return vrstaPunomocja;
        }

        /**
         * Sets the value of the vrstaPunomocja property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZahtevZaPatent.Punomocnik.VrstaPunomocja }
         *     
         */
        public void setVrstaPunomocja(ZahtevZaPatent.Punomocnik.VrstaPunomocja value) {
            this.vrstaPunomocja = value;
        }

        /**
         * Gets the value of the licniPodaci property.
         * 
         * @return
         *     possible object is
         *     {@link TLicniPodaci }
         *     
         */
        public TLicniPodaci getLicniPodaci() {
            return licniPodaci;
        }

        /**
         * Sets the value of the licniPodaci property.
         * 
         * @param value
         *     allowed object is
         *     {@link TLicniPodaci }
         *     
         */
        public void setLicniPodaci(TLicniPodaci value) {
            this.licniPodaci = value;
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
         *         &lt;element name="punomocnik_za_zastupanje" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *         &lt;element name="punomocnik_za_prijem_pismena" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
        public static class VrstaPunomocja {

            @XmlElement(name = "punomocnik_za_zastupanje", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent")
            protected boolean punomocnikZaZastupanje;
            @XmlElement(name = "punomocnik_za_prijem_pismena", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent")
            protected boolean punomocnikZaPrijemPismena;

            /**
             * Gets the value of the punomocnikZaZastupanje property.
             * 
             */
            public boolean isPunomocnikZaZastupanje() {
                return punomocnikZaZastupanje;
            }

            /**
             * Sets the value of the punomocnikZaZastupanje property.
             * 
             */
            public void setPunomocnikZaZastupanje(boolean value) {
                this.punomocnikZaZastupanje = value;
            }

            /**
             * Gets the value of the punomocnikZaPrijemPismena property.
             * 
             */
            public boolean isPunomocnikZaPrijemPismena() {
                return punomocnikZaPrijemPismena;
            }

            /**
             * Sets the value of the punomocnikZaPrijemPismena property.
             * 
             */
            public void setPunomocnikZaPrijemPismena(boolean value) {
                this.punomocnikZaPrijemPismena = value;
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
     *         &lt;element name="ranija_prijava"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;all&gt;
     *                   &lt;element name="datum_podnosenja_ranije_prijave" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                   &lt;element name="broj_ranije_prijave" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="dvoslovna_oznaka_drzave"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;maxLength value="2"/&gt;
     *                         &lt;minLength value="2"/&gt;
     *                         &lt;pattern value="[A-Z][A-Z]"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/all&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
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
    @XmlType(name = "", propOrder = {

    })
    public static class ZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava {

        @XmlElement(name = "ranija_prijava", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
        protected ZahtevZaPatent.ZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava.RanijaPrijava ranijaPrijava;

        /**
         * Gets the value of the ranijaPrijava property.
         * 
         * @return
         *     possible object is
         *     {@link ZahtevZaPatent.ZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava.RanijaPrijava }
         *     
         */
        public ZahtevZaPatent.ZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava.RanijaPrijava getRanijaPrijava() {
            return ranijaPrijava;
        }

        /**
         * Sets the value of the ranijaPrijava property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZahtevZaPatent.ZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava.RanijaPrijava }
         *     
         */
        public void setRanijaPrijava(ZahtevZaPatent.ZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava.RanijaPrijava value) {
            this.ranijaPrijava = value;
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
         *         &lt;element name="datum_podnosenja_ranije_prijave" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *         &lt;element name="broj_ranije_prijave" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="dvoslovna_oznaka_drzave"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="2"/&gt;
         *               &lt;minLength value="2"/&gt;
         *               &lt;pattern value="[A-Z][A-Z]"/&gt;
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
        @XmlType(name = "", propOrder = {

        })
        public static class RanijaPrijava {

            @XmlElement(name = "datum_podnosenja_ranije_prijave", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar datumPodnosenjaRanijePrijave;
            @XmlElement(name = "broj_ranije_prijave", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
            protected String brojRanijePrijave;
            @XmlElement(name = "dvoslovna_oznaka_drzave", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
            protected String dvoslovnaOznakaDrzave;

            /**
             * Gets the value of the datumPodnosenjaRanijePrijave property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDatumPodnosenjaRanijePrijave() {
                return datumPodnosenjaRanijePrijave;
            }

            /**
             * Sets the value of the datumPodnosenjaRanijePrijave property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDatumPodnosenjaRanijePrijave(XMLGregorianCalendar value) {
                this.datumPodnosenjaRanijePrijave = value;
            }

            /**
             * Gets the value of the brojRanijePrijave property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBrojRanijePrijave() {
                return brojRanijePrijave;
            }

            /**
             * Sets the value of the brojRanijePrijave property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBrojRanijePrijave(String value) {
                this.brojRanijePrijave = value;
            }

            /**
             * Gets the value of the dvoslovnaOznakaDrzave property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDvoslovnaOznakaDrzave() {
                return dvoslovnaOznakaDrzave;
            }

            /**
             * Sets the value of the dvoslovnaOznakaDrzave property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDvoslovnaOznakaDrzave(String value) {
                this.dvoslovnaOznakaDrzave = value;
            }

        }

    }

}
