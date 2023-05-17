import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators,FormGroup, FormControl,} from '@angular/forms';
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
  public podnosioci: { name: string, selected: boolean, representative: boolean, form: any }[];
  public podnosiocIndeks: number;
  public representIndeks: number;
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


  private personInfoFBObj = {
    ime: ['', this.nameInpFieldValids],
    telefon: ['', this.numInpFieldValids],
    eMail: ['', [Validators.required, Validators.email]],
    faks: ['', this.numInpFieldValids],
    ulica: ['', this.nameInpFieldValids],
    brojUlice: ['', this.numInpFieldValids],
    postanskiBroj: ['', this.numInpFieldValids],
    mestoPrebivalista: ['', this.nameInpFieldValids],
    drzavaPrebivalista: ['', this.nameInpFieldValids],
    drzavljanstvo: ['', this.nameInpFieldValids]
  };

  private trademarkInfoFBObj = {
    ulicaDostavljanje: ['', this.nameInpFieldValids],
    brojUliceDostavljanje: ['', this.numInpFieldValids],
    postanskiBrojDostavljanje: ['', this.numInpFieldValids],
    mestoPrebivalistaDostavljanje: ['', this.nameInpFieldValids],
    naEngleskom: ['', [Validators.required]],
    naSrpskom: ['', [Validators.required]],
  };

  private brojeviKlasaRobeIliUsluga = new Array<any>();

  private otherInfoFBObj = {
    datumPodnosenjaPrvobitnePrijave: ['', ],
    brojPrvobitnePrijave: ['', ],
    dvoslovnaOznakaDrzave: ['', ],
  }

  public podnosiocZahteva = this._formBuilder.group(this.personInfoFBObj);
  public pronalazac = this._formBuilder.group(this.personInfoFBObj);
  public punomocnik = this._formBuilder.group(this.personInfoFBObj);
  // public zajednickiPredstavnik = this._formBuilder.group(this.personInfoFBObj);
  public podaciZiga = this._formBuilder.group(this.trademarkInfoFBObj);
  public ostalo = this._formBuilder.group(this.otherInfoFBObj);
  

  public numbers = Array.from({length: 45}, (_, i) => i+1);

  constructor(private _formBuilder: FormBuilder, private xmlParser: XMLParser, private requestMaker: RequestMaker, private lStoargeManager: LocalStorageManager) {
    this.podnosioci = [{name: "Podnosioc 1", selected: true, representative: false, form: this.getPodnosiocFromForm()}];
    this.podnosiocIndeks = 0;
    this.representIndeks = 0;
    this.podnosioci[this.representIndeks].representative = true;
  }

  ngOnInit(): void {
  }

  addNewInput(): void {
    const newItem = {
      brojPrvobitnePrijave: new FormControl('', Validators.required),
      datumPodnosenjaPrvobitnePrijave: new FormControl('', Validators.required),
      dvoslovnaOznakaDrzave: new FormControl('', Validators.required)
    };

    this.items.push(newItem);
  }

  
deleteInput(index: number) {
  this.items[index].deleted = true;
  this.items.splice(index,1);
}


  getFormControlName(index: number): string {
    return `items[${index}].brojPrvobitnePrijave`;
  }

  getPodnosiocFromForm() {
    let p = this.podnosiocZahteva.value;
    return {
      ime: p.ime,
      telefon: p.telefon,
      eMail: p.eMail,
      faks: p.faks,
      ulica: p.ulica,
      brojUlice: p.brojUlice,
      postanskiBroj: p.postanskiBroj,
      mestoPrebivalista: p.mestoPrebivalista,
      drzavaPrebivalista: p.drzavaPrebivalista,
      drzavljanstvo: p.drzavljanstvo
    }
  }

  setPodnosiocFormFromSelection(){
    let currPodnosioc = this.podnosioci.at(this.podnosiocIndeks);
    this.podnosiocZahteva.patchValue({
      ime: currPodnosioc?.form.ime,
      telefon: currPodnosioc?.form.telefon,
      eMail: currPodnosioc?.form.eMail,
      faks: currPodnosioc?.form.faks,
      ulica: currPodnosioc?.form.ulica,
      brojUlice: currPodnosioc?.form.brojUlice,
      postanskiBroj: currPodnosioc?.form.postanskiBroj,
      mestoPrebivalista: currPodnosioc?.form.mestoPrebivalista,
      drzavaPrebivalista: currPodnosioc?.form.drzavaPrebivalista,
      drzavljanstvo: currPodnosioc?.form.drzavljanstvo
    });
  }

  resetPodnosiocForm(){
    this.podnosiocZahteva.setValue({
      ime: '',
      telefon: '',
      eMail: '',
      faks: '',
      ulica: '',
      brojUlice: '',
      postanskiBroj: '',
      mestoPrebivalista: '',
      drzavaPrebivalista: '',
      drzavljanstvo: ''
    });
  }

  onSubmitBtnClick(): void {
    this.requestMaker
      .sendTrademarkRequest(this._getDocumentAsXML())
      .subscribe({
        error: (err: any) => {
          alert('Neuspesno, nesto se desilo!');
        },
        complete: () => {
          alert('Prijava za zig je uspesno poslata!');
        }
    });
  }

  addPodnosioc(): void {
    this.saveChanges();
    this.podnosioci[this.podnosiocIndeks].selected = false;
    
    this.resetPodnosiocForm();
    this.podnosioci.push({name:'Podnosioc ' + (this.podnosioci.length+1) , selected: false, representative: false, form: this.getPodnosiocFromForm()});
    this.podnosiocIndeks = this.podnosioci.length-1;
    this.podnosioci[this.podnosiocIndeks].selected = true;
  }

  removePodnosioc(): void {
    if (this.podnosioci.length > 1) {
      if (this.podnosioci[this.podnosiocIndeks].representative) {
        this.representIndeks = 0;
        this.podnosioci[this.representIndeks].representative = true;
      }
      this.podnosioci.splice(this.podnosiocIndeks, 1);
      this.podnosiocIndeks = this.podnosioci.length-1;
      this.podnosioci[this.podnosiocIndeks].selected = true;
      this.podnosioci.forEach((podnosioc, i) => {
        podnosioc.name = "Podnosioc " + (i+1);
      });
      this.setPodnosiocFormFromSelection();
    }
  }

  toggleSelect(index: number): void {
    this.saveChanges();
    this.podnosioci[this.podnosiocIndeks].selected = false;

    this.podnosiocIndeks = index;
    this.podnosioci[this.podnosiocIndeks].selected = true;
    
    this.setPodnosiocFormFromSelection();
  }

  saveChanges() {
    this.podnosioci[this.podnosiocIndeks].form = this.getPodnosiocFromForm();
  }

  theSamePerson(): void {
    //todo podnosilac je ista osoba kao i pronalazac
  }

  doesntWantToBeApointed(): void {
    //todo pronalazac ne zeli da bude naveden u prijavi
  }

  forReception(): void {
    //todo ПУНОМОЋНИК ЗА ПРИЈЕМ ПИСМЕНА
  }

  forRepresentation(): void {
    //todo  ПУНОМОЋНИК ЗА ЗАСТУПАЊЕ
  }

  viaPapir(): void {
    //todo  Подносилац пријаве је сагласан да Завод врши достављање писмена у папирној форми 
  }

  viaMail(): void {
    //todo  Подносилац пријаве је сагласан да Завод врши достављање писмена искључиво
    // електронским путем у форми електронског документа (у овом случају неопходна је 
    //регистрација на порталу "еУправе")
  }

  separateEntry(): void {
    //todo  ИЗДВОЈЕНА ПРИЈАВА
  }

  additionalEntry(): void {
    //todo  ДОПУНСКА ПРИЈАВА 
  }

  onCheckboxChange(e: any): void {
    if (e.checked)
      this.brojeviKlasaRobeIliUsluga.push(e.source.value);
    else {
      let i = 0;
      this.brojeviKlasaRobeIliUsluga.forEach((item: any) => {
        if (item == e.source.value) {
          this.brojeviKlasaRobeIliUsluga.splice(i, 1);
          return;
        }
        i++;
      });
    }
  }

  _getDocumentAsXML(): any {
    let punomocnik = this.punomocnik.value;
    let zig = this.podaciZiga.value;
    let ostalo = this.ostalo.value;

    const reqBody = {
      "_attributes": {
        "xmlns:z": "http://www.ftn.uns.ac.rs/zahtev_za_zig",
        "xmlns:pred": "http://www.ftn.uns.ac.rs/zahtev_za_zig/pred/",
        "xmlns:xsi": "http://www.w3.org/2001/XMLSchema-instance",
        "xsi:schemaLocation": "http://www.ftn.uns.ac.rs/zahtev_za_zig ZahtevZaPriznjanjeZiga.xsd"
      },
      "z:MetaData": { 
        "z:BrojPrijave": { _text: ""},
        "z:EmailNalogaPodnosioca": { _text: this.lStoargeManager.getLoggedUserEmail() },
        "z:DatumPodnosenja": { _text: new Date().toISOString().slice(0, 19) }, 
        "z:DatumPregledanja": { _text: new Date().toISOString().slice(0, 19) }, 
        "z:Status": { _text: ""},
      }, 
      "z:PodnosiociPrijave": { "z:PodnosilacPrijave": this.mapPodnosiociForXML() },
      "z:Punomocnik": this._getPersonInfoJSONObj(punomocnik),
      "z:ZajednickiPredstavnik": this._getPersonInfoJSONObj(this.podnosioci[this.representIndeks].form),
      "z:Zig": this._getTrademarkInfoJSONObj(zig),
      "z:BrojeviKlasaRobeIliUsluga": { "z:BrojKlaseRobeIliUsluge": this.brojeviKlasaRobeIliUsluga.sort((a,b) => a - b) },
      "z:BrojPrvobitnePrijave": { _text: ostalo.brojPrvobitnePrijave },
      "z:DatumPodnosenjaPrvobitnePrijave": { _text: ostalo.datumPodnosenjaPrvobitnePrijave },
      "z:DvoslovnaOznakaDrzave": { _text: ostalo.dvoslovnaOznakaDrzave },
      "z:Taksa": this._getTaxesInfoJSONObj(ostalo)

    };
    return this.xmlParser.parseToXml("z:ZahtevZaPriznanjeZiga", reqBody);
  }

  mapPodnosiociForXML() {
    return this.podnosioci.map(p => {
      return this._getPersonInfoJSONObj(p.form);
    });
  }

  _getPersonInfoJSONObj(formData: any) {
    return {
      "z:Ime": { _text: formData.ime },
      "z:Adresa": { 
        "z:Ulica": { _text: formData.ulica},
        "z:BrojUlice": { _text: formData.brojUlice},
        "z:PostanskiBroj": { _text: formData.postanskiBroj},
        "z:MestoPrebivalista": { _text: formData.mestoPrebivalista},
        "z:DrzavaPrebivalista": { _text: formData.drzavaPrebivalista},
        "z:Drzavljanstvo": { _text: formData.drzavljanstvo}
      },
      "z:KontaktInformacije": {
        "z:Telefon": { _text: formData.telefon},
        "z:E-mail": { _text: formData.eMail},
        "z:Faks": { _text: formData.faks}
      }
    }
  }

  _getTrademarkInfoJSONObj(formData: any) {
    console.log(formData);
    return {
      "z:UlicaDostavljanje": { _text: formData.tipZiga },
      "z:BrojUliceDostavljanje": { _text: formData.tipZnaka },
      "z:PostanskiBrojDostavljanje": { _text: formData.transliteracija },
      "z:MestoPrebivalistaDostavljanje": { _text: formData.prevodZnaka },
      "z:NaEngleskom": { _text: formData.naEngleskom },
      "z:NaSrpskom": { _text: formData.naSrpskom }
    }
  }

  _getTaxesInfoJSONObj(formData: any) {
    return {
      "z:OsnovnaTaksa": { _text: formData.osnovnaTaksa },
      "z:TaksaZaBrojKlasa": { _text: formData.taksaZaBrojKlasa },
      "z:TaksaZaGrafickoResenje": { _text: formData.taksaZaGrafickoResenje },
      "z:Ukupno": { _text: Number(formData.osnovnaTaksa) + Number(formData.taksaZaBrojKlasa) + Number(formData.taksaZaGrafickoResenje) }
    }
  }

}

