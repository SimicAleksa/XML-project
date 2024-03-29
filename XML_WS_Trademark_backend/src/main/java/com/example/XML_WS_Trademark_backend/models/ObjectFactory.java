
package com.example.XML_WS_Trademark_backend.models;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the models package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: models
     * 
     */
    public ObjectFactory() {
    }

    public ResenjeZahteva createResenjeZahteva() {
        return new ResenjeZahteva();
    }


    /**
     * Create an instance of {@link ZahtevZaPriznanjeZiga }
     * 
     */
    public ZahtevZaPriznanjeZiga createZahtevZaPriznanjeZiga() {
        return new ZahtevZaPriznanjeZiga();
    }

    /**
     * Create an instance of {@link ZahtevZaPriznanjeZiga.MetaData }
     * 
     */
    public ZahtevZaPriznanjeZiga.MetaData createZahtevZaPriznanjeZigaMetaData() {
        return new ZahtevZaPriznanjeZiga.MetaData();
    }

    /**
     * Create an instance of {@link KTPersona }
     * 
     */
    public KTPersona createKTPersona() {
        return new KTPersona();
    }

    /**
     * Create an instance of {@link KTZig }
     * 
     */
    public KTZig createKTZig() {
        return new KTZig();
    }

    /**
     * Create an instance of {@link ZahtevZaPriznanjeZiga.BrojeviKlasaRobeIliUsluga }
     * 
     */
    public ZahtevZaPriznanjeZiga.BrojeviKlasaRobeIliUsluga createZahtevZaPriznanjeZigaBrojeviKlasaRobeIliUsluga() {
        return new ZahtevZaPriznanjeZiga.BrojeviKlasaRobeIliUsluga();
    }

    /**
     * Create an instance of {@link KTTaksa }
     * 
     */
    public KTTaksa createKTTaksa() {
        return new KTTaksa();
    }

    /**
     * Create an instance of {@link ZahtevZaPriznanjeZiga.PriloziUzZahtev }
     * 
     */
    public ZahtevZaPriznanjeZiga.PriloziUzZahtev createZahtevZaPriznanjeZigaPriloziUzZahtev() {
        return new ZahtevZaPriznanjeZiga.PriloziUzZahtev();
    }

    /**
     * Create an instance of {@link KTAdresa }
     * 
     */
    public KTAdresa createKTAdresa() {
        return new KTAdresa();
    }

    /**
     * Create an instance of {@link KTKontaktInformacije }
     * 
     */
    public KTKontaktInformacije createKTKontaktInformacije() {
        return new KTKontaktInformacije();
    }

    /**
     * Create an instance of {@link ZahtevZaPriznanjeZiga.MetaData.BrojPrijave }
     * 
     */
    public ZahtevZaPriznanjeZiga.MetaData.BrojPrijave createZahtevZaPriznanjeZigaMetaDataBrojPrijave() {
        return new ZahtevZaPriznanjeZiga.MetaData.BrojPrijave();
    }

    /**
     * Create an instance of {@link ZahtevZaPriznanjeZiga.MetaData.DatumPodnosenja }
     * 
     */
    public ZahtevZaPriznanjeZiga.MetaData.DatumPodnosenja createZahtevZaPriznanjeZigaMetaDataDatumPodnosenja() {
        return new ZahtevZaPriznanjeZiga.MetaData.DatumPodnosenja();
    }

}
