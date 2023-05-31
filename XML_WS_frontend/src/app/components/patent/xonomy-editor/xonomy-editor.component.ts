import { AfterViewInit, Component, OnInit } from '@angular/core';
import { XonomyService } from '../xonomy/xonomy.service';
import { RequestMaker } from 'src/app/services/request-maker.service';
import { LocalStorageManager } from 'src/app/utils/LocalStorageManager';
import { XMLParser } from 'src/app/utils/XMLParser';

declare var Xonomy:any;

@Component({
  selector: 'app-xonomy-editor',
  templateUrl: './xonomy-editor.component.html',
  styleUrls: ['./xonomy-editor.component.css']
})
export class XonomyEditorComponent implements OnInit, AfterViewInit {

  constructor(private xonomyService: XonomyService, private xmlParser: XMLParser,private requestMaker: RequestMaker, private lStoargeManager: LocalStorageManager) { }
  

  ngAfterViewInit(): void {
    let element = document.getElementById("xonomy-editor");
    let specification = this.xonomyService.patentXonomy;
    let xmlString = '<Zahtev_za_patent></Zahtev_za_patent>';
    Xonomy.render(xmlString, element, specification);
  }

  ngOnInit(): void {
    
  }

  generateRandomString() {
    var timestamp = Date.now().toString();
    var randomString = Math.random().toString(36).substr(2) + timestamp;
    return randomString;
  }

  onSubmitBtnClick(): void {
    let text = Xonomy.harvest();
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
          "p:email_naloga_podnosioca": { _text: this.lStoargeManager.getLoggedUserEmail() },
          "p:datum_pregledanja": { _text: "1900-01-01T00:00:00" }
        }
      }

    let popunjava_zavod = this.xmlParser.parseToXml("p:Zahtev_za_patent", reqBody);

    let otvaranje_zahtev_za_patent = popunjava_zavod.split("Zahtev_za_patent.xsd\">")

    let zatvaranje_zahtev_za_patent = otvaranje_zahtev_za_patent[1].split("/p:popunjava_zavod>")

    let xml_otvaranje_zahtev_za_patent = otvaranje_zahtev_za_patent[0]+"Zahtev_za_patent.xsd\">"

    let xml_popunjava_zavod = zatvaranje_zahtev_za_patent[0]+"/p:popunjava_zavod>"

    let xml_zatvaranje_za_patent = zatvaranje_zahtev_za_patent[1]


    text=text.replaceAll("</","!@#$%%TRQDSDSdasdsadafwa")
    text=text.replaceAll("<","<p:")
    text=text.replaceAll("!@#$%%TRQDSDSdasdsadafwa","</p:")
    text=text.replaceAll("xml:space='preserve'","")

    console.log(text);

    text=text.replaceAll("<p:Zahtev_za_patent>",xml_otvaranje_zahtev_za_patent+xml_popunjava_zavod)

    console.log("\n\n\n");

    console.log(text);
    

    this.requestMaker
      .sendPatentRequest(text)
      .subscribe({
        error: (err: any) => {
          alert('Neuspesno, nesto se desilo!');
        },
        complete: () => {
          alert('Prijava za patent je uspesno poslata!');
        }
    });
  }
}
