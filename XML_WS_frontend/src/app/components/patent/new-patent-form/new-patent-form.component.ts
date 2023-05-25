import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators,FormGroup, FormControl, FormArray,} from '@angular/forms';
import { TitleStrategy } from '@angular/router';
import { RequestMaker } from 'src/app/services/request-maker.service';
import { LocalStorageManager } from 'src/app/utils/LocalStorageManager';
import { XMLParser } from 'src/app/utils/XMLParser';
@Component({
  selector: 'app-new-patent-form',
  templateUrl: './new-patent-form.component.html',
  styleUrls: ['./new-patent-form.component.css']
})
export class NewPatentFormComponent implements OnInit {
  items: any[] = [];
  form: FormGroup;  

  countries = ["AF", "AX", "AL", "DZ", "AS", "AD", "AO", "AI", "AQ", "AG", "AR", "AM",
   "AW", "AU", "AT", "AZ", "BS", "BH", "BD", "BB", "BE", "BZ", "BJ", "BM", "BT", "BO",
    "BQ", "BA", "BW", "BV", "BR", "IO", "BN", "BG", "BF", "BI", "KH", "CM", "CA", "CV",
     "KY", "CF", "TD", "CL", "CN", "CX", "CC", "CO", "KM", "CG", "CD", "CK", "CR", "HR",
      "CW", "CY", "CZ", "DK", "DJ", "DM", "DO", "EC", "EG", "SV", "GQ", "ER", "EE",
       "ET", "FK", "FO", "FJ", "FI", "FR", "GF", "PF", "TF", "GA", "GM", "GE", "DE",
        "GH", "GI", "GR", "GL", "GD", "GP", "GU", "GT", "GG", "GN", "GW", "GY", "HT",
         "HM", "VA", "HN", "HK", "HU", "HU", "IS", "IN", "ID", "IQ", "IE", "IM", "IL",
          "IT", "JM", "JP", "JE", "JO", "KZ", "KE", "KI", "KR", "KW", "KG", "LA", "LV",
           "LB", "LS", "LR", "LY", "LI", "LT", "LU", "MO", "MG", "MW", "MY", "MV", "ML",
            "MT", "MH", "MQ", "MR", "MU", "YT", "MX", "FM", "MD", "MC", "MN", "ME",
             "MS", "MA", "MZ", "MM", "NA", "NR", "NP", "NL", "NC", "NZ", "NI", "NE",
              "NG", "NU", "NF", "MK", "MP", "NO", "OM", "PK", "PW", "PS", "PA", "PG",
               "PY", "PE", "PH", "PN", "PL", "PT", "PR", "QA", "RE", "RO", "RW", "BL",
                "SH", "KN", "LC", "MF", "PM", "VC", "WS", "SM", "SA", "SN", "RS", "SC",
                 "SL", "SG", "SX", "SK", "SI", "SB", "SO", "ZA", "GS", "SS", "ES", "LK",
                  "SR", "SJ", "SE", "CH", "ST", "TW", "TJ", "TZ", "TH", "TG", "TK",
                   "TO", "TT", "TN", "TR", "TM", "TC", "TV", "UG", "UA", "AE", "GB",
                    "US", "UM", "UY", "UZ", "VU", "VE", "VN", "VG", "VI", "WF", "EH",
                     "YE", "ZM", "ZW"];

  private nameReg: RegExp = /^[A-Za-z\s]+$/;
  private numReg: RegExp = /^[0-9]{1,20}$/;

  private nameInpFieldValids = [Validators.required, Validators.pattern(this.nameReg)];
  private numInpFieldValids = [Validators.required, Validators.pattern(this.numReg)];


  public podnosilacJeIPronalazac:boolean = false;
  public pronalazacNeZeliDaBudeNaveden:boolean = false;
  public pronalazacJeIPodnosilac:boolean = false;
  public zaZastupanje:boolean = false;
  public zaPrijemPismena:boolean = false;
  public dopunska:boolean = false;
  public izdvojena:boolean = false;
  public elektronskimPutem:boolean = false;
  public papirnaForma:boolean = false;
  

  public isFizockoLice:boolean = false



  private podnosilacInfoFBObj = {
    ime: ['', this.nameInpFieldValids],
    prezime: ['', this.nameInpFieldValids],
    poslovnoIme: ['', this.nameInpFieldValids],
    telefon: ['', this.numInpFieldValids],
    eMail: ['', [Validators.required, Validators.email]],
    faks: ['', this.numInpFieldValids],
    ulica: ['', this.nameInpFieldValids],
    brojUlice: ['', this.numInpFieldValids],
    postanskiBroj: ['', this.numInpFieldValids],
    mestoPrebivalista: ['', this.nameInpFieldValids],
    drzavaPrebivalista: ['', this.nameInpFieldValids],
    drzavljanstvo: ['', this.nameInpFieldValids],
    podnosilacJeIPronalazac:false
  };

  private pronalazacInfoFBObj = {
    ime: ['', this.nameInpFieldValids],
    prezime: ['', this.nameInpFieldValids],
    telefon: ['', this.numInpFieldValids],
    eMail: ['', [Validators.required, Validators.email]],
    faks: ['', this.numInpFieldValids],
    ulica: ['', this.nameInpFieldValids],
    brojUlice: ['', this.numInpFieldValids],
    postanskiBroj: ['', this.numInpFieldValids],
    mestoPrebivalista: ['', this.nameInpFieldValids],
    drzavaPrebivalista: ['', this.nameInpFieldValids],
    pronalazacNeZeliDaBudeNaveden:false,
    pronalazacJeIPodnosilac:false
  };


  private punomocnikInfoFBObj = {
    ime: ['', this.nameInpFieldValids],
    prezime: ['', this.nameInpFieldValids],
    poslovnoIme: ['', this.nameInpFieldValids],
    telefon: ['', this.numInpFieldValids],
    eMail: ['', [Validators.required, Validators.email]],
    ulica: ['', this.nameInpFieldValids],
    brojUlice: ['', this.numInpFieldValids],
    postanskiBroj: ['', this.numInpFieldValids],
    mestoPrebivalista: ['', this.nameInpFieldValids],
    drzavaPrebivalista: ['', this.nameInpFieldValids],
    drzavljanstvo: ['', this.nameInpFieldValids],
    zaZastupanje:false,
    zaPrijemPismena:false
  };

  private pronalazakInfoFBObj = {
    naEngleskom: ['', [Validators.required]],
    naSrpskom: ['', [Validators.required]],
  };

  private posiljkaInfoFBObj = {
    ulicaDostavljanje: ['', this.nameInpFieldValids],
    brojUliceDostavljanje: ['', this.numInpFieldValids],
    postanskiBrojDostavljanje: ['', this.numInpFieldValids],
    mestoPrebivalistaDostavljanje: ['', this.nameInpFieldValids],
    drzavaPrebivalistaDostavljanje: ['', this.nameInpFieldValids],
    elektronskimPutem:false,
    papirnaForma:false
  };

  private brojeviKlasaRobeIliUsluga = new Array<any>();

  private vrstaPrijaveInfoFBObj = {
    datumPodnosenjaPrvobitnePrijave: ['', ],
    brojPrvobitnePrijave: ['', ],
    dopunska:false,
    izdvojena:false
  }

  private ranijePrijaveInfoFBObj = 
      {datumPodnosenjaPrvobitnePrijave: ['', ],
      brojPrvobitnePrijave: ['', ],
      dvoslovnaOznakaDrzave: ['', ]}
  

  public podnosiocZahteva = this._formBuilder.group(this.podnosilacInfoFBObj);
  public pronalazac = this._formBuilder.group(this.pronalazacInfoFBObj);
  public punomocnik = this._formBuilder.group(this.punomocnikInfoFBObj);
  public podaciPatenta = this._formBuilder.group(this.pronalazakInfoFBObj);
  public podaciPosiljke = this._formBuilder.group(this.posiljkaInfoFBObj);
  public ostaloVrsta = this._formBuilder.group(this.vrstaPrijaveInfoFBObj);
  public ostaloRanije = this._formBuilder.group(this.ranijePrijaveInfoFBObj);
  
  public numbers = Array.from({length: 45}, (_, i) => i+1);

  constructor(private _formBuilder: FormBuilder, private xmlParser: XMLParser, private requestMaker: RequestMaker, private lStoargeManager: LocalStorageManager) {
  }

  ngOnInit(): void {

  }

  generateRandomString() {
    var timestamp = Date.now().toString();
    var randomString = Math.random().toString(36).substr(2) + timestamp;
    return randomString;
  }

  addNewInput(): void {
    alert("DODATO")
    const newItem = {
      brojPrvobitnePrijave: this.ostaloRanije.get("brojPrvobitnePrijave")?.value,
      datumPodnosenjaPrvobitnePrijave: this.ostaloRanije.get("datumPodnosenjaPrvobitnePrijave")?.value,
      dvoslovnaOznakaDrzave: this.ostaloRanije.get("dvoslovnaOznakaDrzave")?.value,
    };
    this.items.push(newItem);
    this.ostaloRanije = this._formBuilder.group(this.ranijePrijaveInfoFBObj);

  }

  onSubmitBtnClick(): void {

    // console.log(this.items);
    // console.log(this.punomocnik);
    // alert("usao")

    // console.log(this._getDocumentAsXML())

    this.requestMaker
      .sendPatentRequest(this._getDocumentAsXML())
      .subscribe({
        error: (err: any) => {
          alert('Neuspesno, nesto se desilo!');
        },
        complete: () => {
          alert('Prijava za zig je uspesno poslata!');
        }
    });
  }


  theSamePerson(): void {
    //todo podnosilac je ista osoba kao i pronalazac
      this.podnosilacJeIPronalazac=!this.podnosilacJeIPronalazac
  }

  theSamePersonYetAgain(): void {
    //todo pronalazac je ista osoba kao i podnosilac
    this.pronalazacJeIPodnosilac=!this.pronalazacJeIPodnosilac
  }

  doesntWantToBeApointed(): void {
    //todo pronalazac ne zeli da bude naveden u prijavi
    this.pronalazacNeZeliDaBudeNaveden=!this.pronalazacNeZeliDaBudeNaveden
  }

  forReception(): void {
    //todo ПУНОМОЋНИК ЗА ПРИЈЕМ ПИСМЕНА
    this.zaPrijemPismena=!this.zaPrijemPismena
  }

  forRepresentation(): void {
    //todo  ПУНОМОЋНИК ЗА ЗАСТУПАЊЕ
    this.zaZastupanje=!this.zaZastupanje
  }

  viaPapir(): void {
    //todo  Подносилац пријаве је сагласан да Завод врши достављање писмена у папирној форми 
    this.papirnaForma=!this.papirnaForma
  }

  viaMail(): void {
    //todo  Подносилац пријаве је сагласан да Завод врши достављање писмена искључиво
    // електронским путем у форми електронског документа (у овом случају неопходна је 
    //регистрација на порталу "еУправе")
    this.elektronskimPutem=!this.elektronskimPutem
  }

  separateEntry(): void {
    //todo  ИЗДВОЈЕНА ПРИЈАВА
    this.izdvojena=!this.izdvojena
  }

  additionalEntry(): void {
    //todo  ДОПУНСКА ПРИЈАВА 
    this.dopunska=!this.dopunska
  }

  _getDocumentAsXML(): any {
    const reqBody = {
      "_attributes": {
        "xmlns:p": "http://www.ftn.uns.ac.rs/zahtev_za_patent",
        "xmlns:pred": "http://www.ftn.uns.ac.rs/zahtev_za_patent/pred",
        "xmlns:xsi": "http://www.w3.org/2001/XMLSchema-instance",
        "xsi:schemaLocation": "http://www.ftn.uns.ac.rs/zahtev_za_patent Zahtev_za_patent.xsd"
      },
      "p:popunjava_zavod": { 
        "p:broj_prijave": { _text: "P_"+this.generateRandomString()},
        "p:datum_prijema": { _text: new Date().toISOString().slice(0, 19) },
        "p:priznati_datum_podnosenja": { _text: new Date().toISOString().slice(0, 19) }, 
        "p:status": { _text: "NERESENO" },
      }, 
      "p:naziv_pronalaska": this._getNazivInfoJSONObj(this.podaciPatenta.value) ,
      "p:podnosilac_prijave": this._getPodnosilacInfoJSONObj(this.podnosiocZahteva.value) ,
      "p:pronalazac": this._getPronalazacInfoJSONObj(this.pronalazac.value) ,
      "p:punomocnik": this._getPunomocnikInfoJSONObj(this.punomocnik.value),
      "p:dostavljanje_podaci": this._getDostavljanjeInfoJSONObj(this.podaciPosiljke.value),
      "p:prijava": this._getOstaloVrstaPrijaveInfoJSONObj(this.ostaloVrsta.value),
      "p:zahtev_za_priznanje_prava_prvenstva_iz_ranijih_prijava":{
        "p:ranija_prijava": this._getRanijePrijaveInfoJSONObj(this.items),
      } 

    };
    return this.xmlParser.parseToXml("p:Zahtev_za_patent", reqBody);
  }
  _getRanijePrijaveInfoJSONObj(listaRanijihPrijava: any) {
    let result: { "p:datum_podnosenja_ranije_prijave": { _text: any; }; "p:broj_ranije_prijave": { _text: any; }; "p:dvoslovna_oznaka_drzave": { _text: any; }; }[] = [];

    listaRanijihPrijava.forEach((formData: { datumPodnosenjaPrvobitnePrijave: any; brojPrvobitnePrijave: any; dvoslovnaOznakaDrzave: any; }) => {
      result.push({
          "p:datum_podnosenja_ranije_prijave": { _text: formData.datumPodnosenjaPrvobitnePrijave },
          "p:broj_ranije_prijave": { _text: formData.brojPrvobitnePrijave },
          "p:dvoslovna_oznaka_drzave": { _text: formData.dvoslovnaOznakaDrzave }
      });
    });

    return result;
  }

  _getOstaloVrstaPrijaveInfoJSONObj(formData: any) {
    return {
      "p:dopunska_prijava": { _text: formData.dopunska },
      "p:izdvojena_prijava": { _text: formData.izdvojena },
      "p:broj_osnovne_prijave": { _text: formData.brojPrvobitnePrijave },
      "p:datum_podnosenja_osnovne_prijave": { _text: formData.datumPodnosenjaPrvobitnePrijave },
    }
  }

  _getNazivInfoJSONObj(formData: any) {
    return {
      "p:na_srpskom_jeziku": { _text: formData.naSrpskom },
      "p:na_engleskom_jeziku": { _text: formData.naEngleskom },
    }
  }

  _getDostavljanjeInfoJSONObj(formData: any) {
    return {
        "p:adresa": { 
          "p:ulica": { _text: formData.ulicaDostavljanje  },
          "p:broj_objekta": { _text: formData.brojUliceDostavljanje  },
          "p:postanski_broj": { _text: formData.postanskiBrojDostavljanje },
          "p:mesto": { _text: formData.mestoPrebivalistaDostavljanje },
          "p:drzava": { _text: formData.drzavaPrebivalistaDostavljanje }
        },
        "p:podnosilac_saglasan_dostavljanje_elektronskim_putem": { _text: formData.elektronskimPutem},
        "p:podnosilac_saglasan_dostavljanje_u_papirnoj_formi": { _text: formData.papirnaForma},
      }
    }


  _getPodnosilacInfoJSONObj(formData: any) {
    if(this.isFizockoLice)
      return {
        "p:podnosilac_prijave_je_i_pronalazac": { _text: this.podnosilacJeIPronalazac },
        "p:licni_podaci": { 
          "p:fizicko_pravno_lice": { 
            "p:fizicko_lice": { 
              "p:ime": { _text: formData.ime},
              "p:prezime": { _text: formData.prezime},
            }
          },
          "p:drzavljanstvo": { _text: formData.drzavljanstvo },
          "p:adresa": { 
            "p:ulica": { _text: formData.ulica },
            "p:broj_objekta": { _text: formData.brojUlice },
            "p:postanski_broj": { _text: formData.postanskiBroj },
            "p:mesto": { _text: formData.mestoPrebivalista },
            "p:drzava": { _text: formData.drzavaPrebivalista }
          },
          "p:dodatni_podaci": { 
            "p:broj_telefona": { _text: formData.brojUlice},
            "p:broj_faksa": { _text: formData.postanskiBroj},
            "p:e_posta": { _text: formData.mestoPrebivalista},
          }
        }
      }
      else
      return {
        "p:podnosilac_prijave_je_i_pronalazac": { _text: this.podnosilacJeIPronalazac },
        "p:licni_podaci": { 
          "p:fizicko_pravno_lice": { 
            "p:pravno_lice": { 
              "p:poslovno_ime": { _text: formData.poslovnoIme},
            }
          },
          "p:drzavljanstvo": { _text: formData.drzavljanstvo },
          "p:adresa": { 
            "p:ulica": { _text: formData.ulica },
            "p:broj_objekta": { _text: formData.brojUlice },
            "p:postanski_broj": { _text: formData.postanskiBroj },
            "p:mesto": { _text: formData.mestoPrebivalista },
            "p:drzava": { _text: formData.drzavaPrebivalista }
          },
          "p:dodatni_podaci": { 
            "p:broj_telefona": { _text: formData.brojUlice},
            "p:broj_faksa": { _text: formData.postanskiBroj},
            "p:e_posta": { _text: formData.mestoPrebivalista},
          }
        }
      }
  }

  _getPronalazacInfoJSONObj(formData: any) {
    return {
      "p:pronalazac_ne_zeli_da_bude_naveden_u_prijavi": { _text: formData.pronalazacNeZeliDaBudeNaveden  },
      "p:pronalazac_je_podnosilac_prijave": { _text: formData.pronalazacJeIPodnosilac  },
      "p:podaci_o_pronalazacu": { 
        "p:fizicko_lice": { 
          "p:ime": { _text: formData.ime},
          "p:prezime": { _text: formData.prezime},
        },
        "p:adresa": { 
          "p:ulica": { _text: formData.ulica },
          "p:broj_objekta": { _text: formData.brojUlice },
          "p:postanski_broj": { _text: formData.postanskiBroj },
          "p:mesto": { _text: formData.mestoPrebivalista },
          "p:drzava": { _text: formData.drzavaPrebivalista }
        },
        "p:dodatni_podaci": { 
          "p:broj_telefona": { _text: formData.brojUlice},
          "p:broj_faksa": { _text: formData.postanskiBroj},
          "p:e_posta": { _text: formData.mestoPrebivalista},
        }
      }
    }
  }

  _getPunomocnikInfoJSONObj(formData: any) {
    if(this.isFizockoLice)
      return {
        "p:vrsta_punomocja": { 
          "p:punomocnik_za_zastupanje": { _text: formData.zaZastupanje  },
          "p:punomocnik_za_prijem_pismena": { _text: formData.zaPrijemPismena  }
        },
      
        "p:licni_podaci": { 
          "p:fizicko_pravno_lice": { 
            "p:fizicko_lice": { 
              "p:ime": { _text: formData.ime},
              "p:prezime": { _text: formData.prezime},
            }
          },
          "p:drzavljanstvo": { _text: formData.drzavljanstvo },
          "p:adresa": { 
            "p:ulica": { _text: formData.ulica },
            "p:broj_objekta": { _text: formData.brojUlice },
            "p:postanski_broj": { _text: formData.postanskiBroj },
            "p:mesto": { _text: formData.mestoPrebivalista },
            "p:drzava": { _text: formData.drzavaPrebivalista }
          },
          "p:dodatni_podaci": { 
            "p:broj_telefona": { _text: formData.brojUlice},
            "p:broj_faksa": { _text: formData.postanskiBroj},
            "p:e_posta": { _text: formData.mestoPrebivalista},
          }
        }
      }
    else
    return {
      "p:vrsta_punomocja": { 
        "p:punomocnik_za_zastupanje": { _text: formData.zaZastupanje  },
        "p:punomocnik_za_prijem_pismena": { _text: formData.zaPrijemPismena  }
      },
    
      "p:licni_podaci": { 
        "p:fizicko_pravno_lice": { 
          "p:pravno_lice": { 
            "p:poslovno_ime": { _text: formData.poslovnoIme},
          }
        },
        "p:drzavljanstvo": { _text: formData.drzavljanstvo },
        "p:adresa": { 
          "p:ulica": { _text: formData.ulica },
          "p:broj_objekta": { _text: formData.brojUlice },
          "p:postanski_broj": { _text: formData.postanskiBroj },
          "p:mesto": { _text: formData.mestoPrebivalista },
          "p:drzava": { _text: formData.drzavaPrebivalista }
        },
        "p:dodatni_podaci": { 
          "p:broj_telefona": { _text: formData.brojUlice},
          "p:broj_faksa": { _text: formData.postanskiBroj},
          "p:e_posta": { _text: formData.mestoPrebivalista},
        }
      }
    }
  }
}
