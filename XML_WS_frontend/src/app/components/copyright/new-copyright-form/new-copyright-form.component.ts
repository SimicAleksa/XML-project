import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators,FormGroup, FormControl, FormArray,} from '@angular/forms';
import { TitleStrategy } from '@angular/router';
import { RequestMaker } from 'src/app/services/request-maker.service';
import { LocalStorageManager } from 'src/app/utils/LocalStorageManager';
import { XMLParser } from 'src/app/utils/XMLParser';

@Component({
  selector: 'app-new-copyright-form',
  templateUrl: './new-copyright-form.component.html',
  styleUrls: ['./new-copyright-form.component.css']
})
export class NewCopyrightFormComponent implements OnInit {
  items_prilozi: any[] = [];
  items_autori: any[] = [];
  form: FormGroup;  

  private nameReg: RegExp = /^[A-Za-z\s]+$/;
  private numReg: RegExp = /^[0-9]{1,20}$/;

  private nameInpFieldValids = [Validators.required, Validators.pattern(this.nameReg)];
  private numInpFieldValids = [Validators.required, Validators.pattern(this.numReg)];


  public podnosilacJeIPronalazac:boolean = false;
  public autorJeAnoniman:boolean = false;
  public delo_stvoreno_u_radnom_odnosu:boolean = false;
  

  public isFizockoLice:boolean = true


  private pseudonimInfoFBObj = {
    pseudonim_ili_znak_autora: ['', this.nameInpFieldValids]
  };

  
  private podnosilacInfoFBObj = {
    ime: ['', this.nameInpFieldValids],
    prezime: ['', this.nameInpFieldValids],
    poslovnoIme: ['', this.nameInpFieldValids],
    telefon: ['', this.numInpFieldValids],
    eMail: ['', [Validators.required, Validators.email]],
    ulica: ['', this.nameInpFieldValids],
    grad: ['', this.nameInpFieldValids],
    brojUlice: ['', this.numInpFieldValids],
    drzavljanstvo: ['', this.nameInpFieldValids],
  };

  private autorInfoFBObj = {
    ime: ['', this.nameInpFieldValids],
    prezime: ['', this.nameInpFieldValids],
    ulica: ['', this.nameInpFieldValids],
    brojUlice: ['', this.numInpFieldValids],
    grad: ['', this.nameInpFieldValids],
    drzavljanstvo: ['', this.nameInpFieldValids],
    godina_smrti: ['', ],
    anoniman_autor: false,
  };

  private punomocnikInfoFBObj = {
    ime: ['', this.nameInpFieldValids],
    prezime: ['', this.nameInpFieldValids],
    ulica: ['', this.nameInpFieldValids],
    brojUlice: ['', this.numInpFieldValids],
    grad: ['', this.nameInpFieldValids],
  };

  private deloInfoFBObj = {
    naslov: ['', this.nameInpFieldValids],
    alternativni_naslov: ['', this.nameInpFieldValids],
    naslov_dela_prerade: ['', this.nameInpFieldValids],
    autor_dela_prerade: ['', this.nameInpFieldValids],
    vrsta_autorskog_dela: ['', this.nameInpFieldValids],
    forma_zapisa_autorskog_dela: ['', this.nameInpFieldValids],
    delo_stvoreno_u_radnom_odnosu: false,
    nacin_koriscenja_dela: ['', this.nameInpFieldValids],
  };

  private priloziInfoFBObj = {
    opis_dela: ['', this.nameInpFieldValids],
    primer_dela: ['', this.nameInpFieldValids],
  };
  

  public podaci_o_podnosiocu = this._formBuilder.group(this.podnosilacInfoFBObj);
  public pseudonim_ili_znak_autora = this._formBuilder.group(this.pseudonimInfoFBObj);
  public podaci_o_autoru = this._formBuilder.group(this.autorInfoFBObj);
  public podaci_o_punomocniku = this._formBuilder.group(this.punomocnikInfoFBObj);
  public podaci_o_delu = this._formBuilder.group(this.deloInfoFBObj);
  public prilozi = this._formBuilder.group(this.priloziInfoFBObj);

  constructor(private _formBuilder: FormBuilder, private xmlParser: XMLParser, private requestMaker: RequestMaker, private lStoargeManager: LocalStorageManager) {
  }

  ngOnInit(): void {

  }

  addNewPrilog(): void {
    const newItem = {
      opis_dela: this.prilozi.get("opis_dela")?.value,
      primer_dela: this.prilozi.get("primer_dela")?.value,
    };
    this.items_prilozi.push(newItem);
    this.prilozi = this._formBuilder.group(this.priloziInfoFBObj);

  }

  addNewAutor(): void {
    const newItem = {
      anoniman_autor: this.podaci_o_autoru.get("anoniman_autor")?.value,
      autor:{
        drzavljanstvo: this.podaci_o_autoru.get("drzavljanstvo")?.value,
        ime: this.podaci_o_autoru.get("ime")?.value,
        prezime: this.podaci_o_autoru.get("prezime")?.value,
        ulica: this.podaci_o_autoru.get("ulica")?.value,
        brojUlice: this.podaci_o_autoru.get("brojUlice")?.value,
        grad: this.podaci_o_autoru.get("grad")?.value,
        godina_smrti: this.podaci_o_autoru.get("godina_smrti")?.value
      }
    };
    this.items_autori.push(newItem);
    this.podaci_o_autoru = this._formBuilder.group(this.autorInfoFBObj);

  }

  generateRandomString() {
    var timestamp = Date.now().toString();
    var randomString = Math.random().toString(36).substr(2) + timestamp;
    return randomString;
  }

  onSubmitBtnClick(): void {
    // console.log(this._getDocumentAsXML());
    
    this.requestMaker
      .sendCopyRightRequest(this._getDocumentAsXML())
      .subscribe({
        error: (err: any) => {
          alert('Neuspesno, nesto se desilo!');
        },
        complete: () => {
          alert('Prijava za copyright je uspesno poslata!');
        }
    });
  }


  dsur_odnosuChange(): void {
      this.podnosilacJeIPronalazac=!this.podnosilacJeIPronalazac
  }

  anoniman_autorChangeChange(): void {
    this.autorJeAnoniman=!this.autorJeAnoniman
}

  _getDocumentAsXML(): any {
    const reqBody = {
      "_attributes": {
        "xmlns:a":"http://www.ftn.uns.ac.rs/AutorskaPrava",
        "xmlns:xsi": "http://www.w3.org/2001/XMLSchema-instance",
        "xmlns:pred": "http://www.ftn.uns.ac.rs/AutorskaPrava/pred/",
        "xsi:schemaLocation": "http://www.ftn.uns.ac.rs/AutorskaPrava zahtev_za_autorsko_pravo.xsd"
      },
      "a:broj_prijave": { _text: "A_"+this.generateRandomString()},
      "a:datum_podnosenja": { _text: new Date().toISOString().slice(0, 19) },
      "a:status": { _text: "NERESENO" },
      "a:email_naloga_podnosioca": { _text: this.lStoargeManager.getLoggedUserEmail() },
      "a:datum_pregledanja": { _text: "TBD" },
      "a:pseudonim_ili_znak_autora": this._getPseudonimInfoJSONObj(this.pseudonim_ili_znak_autora.value),
      "a:podaci_o_podnosiocu": this._getPodnosilacInfoJSONObj(this.podaci_o_podnosiocu.value),
      "a:podaci_o_autoru": this._getAutorInfoJSONObj(this.items_autori),
      "a:podaci_o_punomocniku": this._getPunomocnikInfoJSONObj(this.podaci_o_punomocniku.value),
      "a:podaci_o_delu": this._getDeloInfoJSONObj(this.podaci_o_delu.value),
      "a:prilozi": this._getPriloziInfoJSONObj(this.items_prilozi)
    };
    return this.xmlParser.parseToXml("a:zahtev_za_autorsko_pravo", reqBody);
  }

  _getPriloziInfoJSONObj(listaAutora: any) {
    let result: { "a:opis_dela": { _text: any; }; "a:primer_dela": { _text: any; }; }[]= [];

    listaAutora.forEach((formData: { opis_dela: any; primer_dela: any;}) => {
      result.push({
        "a:opis_dela": { _text: formData.opis_dela },
        "a:primer_dela": { _text: formData.primer_dela },
      });
    });

    return result;
  }


  _getDeloInfoJSONObj(formData: any) {
    return {
      "a:naslov": { _text: formData.naslov},
      "a:alternativni_naslov": { _text: formData.alternativni_naslov},
      "a:podaci_o_delu_prerade": { 
        "a:naslov_dela_prerade": { _text: formData.naslov_dela_prerade },
        "a:autor_dela_prerade": { _text: formData.autor_dela_prerade },
      },
      "a:vrsta_autorskog_dela": { _text: formData.vrsta_autorskog_dela},
      "a:forma_zapisa_autorskog_dela": { _text: formData.forma_zapisa_autorskog_dela},
      "a:delo_stvoreno_u_radnom_odnosu": { _text: formData.delo_stvoreno_u_radnom_odnosu},
      "a:nacin_koriscenja_dela": { _text: formData.nacin_koriscenja_dela},
    }
  }

  _getPunomocnikInfoJSONObj(formData: any) {
    return {
      "a:ime": { _text: formData.ime},
      "a:prezime": { _text: formData.prezime},
      "a:adresa": { 
        "a:ulica": { _text: formData.ulica },
        "a:broj": { _text: formData.brojUlice },
        "a:grad": { _text: formData.grad },
      }
    }
  }

  _getAutorInfoJSONObj(listaAutora: any) {
    let result: { "a:anoniman_autor"?: { _text: any; }; "a:autor"?: { "a:godina_smrti": { _text: any; }; "a:drzavljanstvo": { _text: any; }; "a:ime": { _text: any; }; "a:prezime": { _text: any; }; "a:adresa": { "a:ulica": { _text: any; }; "a:broj": { _text: any; }; "a:grad": { _text: any; }; }; }; }[]= [];

    listaAutora.forEach((formData: { anoniman_autor: any; autor: any;}) => {
      if(formData.anoniman_autor)
        result.push({
          "a:anoniman_autor": { _text: formData.anoniman_autor },
        });
      else
        result.push({
            "a:autor": {
              "a:godina_smrti": { _text: formData.autor.godina_smrti },
              "a:drzavljanstvo": { _text: formData.autor.drzavljanstvo },
              "a:ime": { _text: formData.autor.ime },
              "a:prezime": { _text: formData.autor.prezime },
              "a:adresa": { 
                "a:ulica": { _text: formData.autor.ulica },
                "a:broj": { _text: formData.autor.brojUlice },
                "a:grad": { _text: formData.autor.grad },
              }
            }
        });
    });

    return result;
  }

  _getPseudonimInfoJSONObj(formData: any) {
    return {
      _text: formData.pseudonim_ili_znak_autora
    }
  }


  _getPodnosilacInfoJSONObj(formData: any) {
    if(this.isFizockoLice)
      return {
        "a:lice": { 
          "a:fizicko_lice": { 
            "a:ime": { _text: formData.ime},
            "a:prezime": { _text: formData.prezime},
            "a:drzavljanstvo": { _text: formData.drzavljanstvo},
            "a:adresa": { 
              "a:ulica": { _text: formData.ulica },
              "a:broj": { _text: formData.brojUlice },
              "a:grad": { _text: formData.grad },
            }
          },
          "a:telefon": { _text: formData.telefon},
          "a:email": { _text: formData.eMail},
        }
      }
      else
      return {
        "a:lice": { 
          "a:pravno_lice": { 
            "a:poslovno_ime": { _text: formData.poslovnoIme},
            "a:podaci_o_sedistu":{ 
              "a:ulica": { _text: formData.ulica },
              "a:broj": { _text: formData.brojUlice },
              "a:grad": { _text: formData.grad },
            }
          },
          "a:telefon": { _text: formData.telefon},
          "a:email": { _text: formData.eMail},
        }
      }
    }
  }
