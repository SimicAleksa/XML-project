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
  items: any[] = [];
  form: FormGroup;  

  private nameReg: RegExp = /^[A-Za-z\s]+$/;
  private numReg: RegExp = /^[0-9]{1,20}$/;

  private nameInpFieldValids = [Validators.required, Validators.pattern(this.nameReg)];
  private numInpFieldValids = [Validators.required, Validators.pattern(this.numReg)];


  public podnosilacJeIPronalazac:boolean = false;
  

  public isFizockoLice:boolean = false


  private pseudonimInfoFBObj = {
    pseudonim_ili_znak_autora: ['', this.nameInpFieldValids],
  };

  
  private podnosilacInfoFBObj = {
    ime: ['', this.nameInpFieldValids],
    prezime: ['', this.nameInpFieldValids],
    poslovnoIme: ['', this.nameInpFieldValids],
    poslovnoSediste: ['', this.nameInpFieldValids],
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
  

  public podaci_o_podnosiocu = this._formBuilder.group(this.podnosilacInfoFBObj);
  public pseudonim_ili_znak_autora = this._formBuilder.group(this.pseudonimInfoFBObj);
  public podaci_o_autoru = this._formBuilder.group(this.autorInfoFBObj);
  public podaci_o_punomocniku = this._formBuilder.group(this.punomocnikInfoFBObj);
  public podaci_o_delu = this._formBuilder.group(this.deloInfoFBObj);

  constructor(private _formBuilder: FormBuilder, private xmlParser: XMLParser, private requestMaker: RequestMaker, private lStoargeManager: LocalStorageManager) {
  }

  ngOnInit(): void {

  }

  generateRandomString() {
    var timestamp = Date.now().toString();
    var randomString = Math.random().toString(36).substr(2) + timestamp;
    return randomString;
  }

  onSubmitBtnClick(): void {
    this.requestMaker
      .sendCopyRightRequest(this._getDocumentAsXML())
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

  _getDocumentAsXML(): any {
    const reqBody = {
      "_attributes": {
        "xmlns:a":"http://www.ftn.uns.ac.rs/AutorskaPrava",
        "xmlns:xsi": "http://www.w3.org/2001/XMLSchema-instance",
        "xmlns:pred": "http://www.ftn.uns.ac.rs/AutorskaPrava/pred/",
        "xsi:schemaLocation": "http://www.ftn.uns.ac.rs/AutorskaPrava zahtev_za_autorsko_pravo.xsd"
      },
      "a:broj_prijave": { _text: "P_"+this.generateRandomString()},
      "a:datum_podnosenja": { _text: new Date().toISOString().slice(0, 19) },
      "a:pseudonim_ili_znak_autora": { _text: "A_"+this.generateRandomString() }, 
      "a:podnosilac_prijave": this._getPodnosilacInfoJSONObj(this.podaci_o_podnosiocu.value)
    };
    return this.xmlParser.parseToXml("p:Zahtev_za_patent", reqBody);
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
}
