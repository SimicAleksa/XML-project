import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import { RequestMaker } from 'src/app/services/request-maker.service';
import { LocalStorageManager } from 'src/app/utils/LocalStorageManager';
import { XMLParser } from 'src/app/utils/XMLParser';


@Component({
  selector: 'app-new-trademark-form',
  templateUrl: './new-trademark-form.component.html',
  styleUrls: ['./new-trademark-form.component.css']
})
export class NewTrademarkFormComponent implements OnInit {
  public podnosioci: { name: string, selected: boolean, representative: boolean, form: any }[];
  public podnosiocIndeks: number;
  public representIndeks: number;

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
    drzavaPrebivalista: ['', this.nameInpFieldValids]
  };

  private trademarkInfoFBObj = {
    tipZiga: ['', [Validators.required]],
    tipZnaka: ['', [Validators.required]],
    boje: ['', [Validators.required]],
    opisZnaka: ['', [Validators.required]],
    transliteracija: ['', ],
    prevodZnaka: ['', ],
  };

  private brojeviKlasaRobeIliUsluga = new Array<any>();

  private otherInfoFBObj = {
    brojeviKlasaRobeIliUsluga: [this.brojeviKlasaRobeIliUsluga, ],
    pravoPrvenstvaIOsnov: ['', ],
    osnovnaTaksa: ['', this.numInpFieldValids],
    taksaZaBrojKlasa: ['', this.numInpFieldValids],
    taksaZaGrafickoResenje: ['', this.numInpFieldValids],
  }

  public podnosiocZahteva = this._formBuilder.group(this.personInfoFBObj);
  public punomocnik = this._formBuilder.group(this.personInfoFBObj);
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
      drzavaPrebivalista: p.drzavaPrebivalista
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
      drzavaPrebivalista: currPodnosioc?.form.drzavaPrebivalista
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
      drzavaPrebivalista: ''
    });
  }

  onSubmitBtnClick(): void {
    if (this.podaciZiga.value.tipZiga === "" || this.podaciZiga.value.tipZnaka === "") {
      alert("Tip ziga i znaka nisu odabrani! ");
      return;
    }

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

  changeRepresent(): void {
    this.podnosioci.forEach((podnosioc) => {
      if (podnosioc.representative)
        podnosioc.representative = false;
      else if (podnosioc.selected)
        podnosioc.representative = true;
    });
    this.representIndeks = this.podnosiocIndeks;
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
      "z:PravoPrvenstvaIOsnov": { _text: ostalo.pravoPrvenstvaIOsnov },
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
        "z:DrzavaPrebivalista": { _text: formData.drzavaPrebivalista}
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
      "z:TipZiga": { _text: formData.tipZiga },
      "z:TipZnaka": { _text: formData.tipZnaka },
      "z:Boje": { _text: formData.boje },
      "z:TransliteracijaZnaka": { _text: formData.transliteracija },
      "z:PrevodZnaka": { _text: formData.prevodZnaka },
      "z:OpisZnaka": { _text: formData.opisZnaka }
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
